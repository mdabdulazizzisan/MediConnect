package com.kolu.mediconnect.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.kolu.mediconnect.domain.model.Appointment
import com.kolu.mediconnect.domain.repository.AppointmentRepository
import kotlinx.coroutines.tasks.await

class AppointmentRepo(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AppointmentRepository {

    private val appointmentCollection = firestore.collection(APPOINTMENT_COLLECTION)
    
    companion object {
        private const val APPOINTMENT_COLLECTION = "appointments"
        private const val USER_ID_FIELD = "userId"
    }
    
    override suspend fun bookAppointment(appointment: Appointment): String? {
        return try {
            // Ensure the appointment has the current user's ID
            val currentUserId = auth.currentUser?.uid ?: return null
            val appointmentWithUserId = appointment.copy(userId = currentUserId)
            
            // Add the appointment to Firestore
            val documentReference = appointmentCollection.add(appointmentWithUserId).await()
            
            // Update the appointment with the generated ID
            val appointmentId = documentReference.id
            appointmentCollection.document(appointmentId)
                .update("id", appointmentId)
                .await()
                
            appointmentId
        } catch (e: Exception) {
            ""
        }
    }

    override suspend fun getAllAppointment(): List<Appointment> {
        return try {
            val currentUserId = auth.currentUser?.uid ?: return emptyList()
            
            val snapshot = appointmentCollection
                .whereEqualTo(USER_ID_FIELD, currentUserId)
                .get()
                .await()
                
            snapshot.documents.mapNotNull { document ->
                document.toObject<Appointment>()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getAppointmentById(id: String): Appointment? {
        return try {
            val currentUserId = auth.currentUser?.uid ?: return null
            
            val document = appointmentCollection.document(id).get().await()
            val appointment = document.toObject<Appointment>()
            
            // Verify this appointment belongs to the current user
            if (appointment?.userId == currentUserId) {
                appointment
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun updateAppointment(appointment: Appointment): Boolean {
        return try {
            val currentUserId = auth.currentUser?.uid ?: return false
            
            // Verify this appointment belongs to the current user
            val existingAppointment = getAppointmentById(appointment.id) ?: return false
            if (existingAppointment.userId != currentUserId) return false
            
            // Update the appointment
            appointmentCollection.document(appointment.id)
                .set(appointment)
                .await()
                
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun deleteAppointment(appointment: Appointment): Boolean {
        return try {
            val currentUserId = auth.currentUser?.uid ?: return false
            
            // Verify this appointment belongs to the current user
            if (appointment.userId != currentUserId) return false
            
            // Delete the appointment
            appointmentCollection.document(appointment.id)
                .delete()
                .await()
                
            true
        } catch (e: Exception) {
            false
        }
    }
}
