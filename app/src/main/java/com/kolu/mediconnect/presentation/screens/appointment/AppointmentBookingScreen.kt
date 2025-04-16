package com.kolu.mediconnect.presentation.screens.appointment

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.kolu.mediconnect.domain.model.BangladeshLocations
import com.kolu.mediconnect.presentation.components.DatePickerField
import com.kolu.mediconnect.presentation.components.DropDown
import com.kolu.mediconnect.presentation.components.TimeSlotPicker

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppointmentBookingScreen(
    modifier: Modifier = Modifier,
    onAppointmentSuccess: (appointmentId: String) -> Unit,
    viewModel: AppointmentViewModel
) {
    val context = LocalContext.current

    Box(modifier = modifier.fillMaxSize()) {
        val appointment by viewModel.appointment.collectAsState()
        
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Book An Appointment",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 50.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            DropDown(
                modifier = Modifier.padding(16.dp),
                items = BangladeshLocations.divisions,
                placeholder = "Division",
                selectedItem = appointment.division,
                onItemSelected = {
                    viewModel.updateDivision(it)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            DropDown(
                modifier = Modifier.padding(16.dp),
                items = BangladeshLocations.districts[appointment.division] ?: emptyList(),
                placeholder = "District",
                selectedItem = appointment.district,
                onItemSelected = {
                    viewModel.updateDistrict(it)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            DropDown(
                modifier = Modifier.padding(16.dp),
                items = BangladeshLocations.thanas[appointment.district] ?: emptyList(),
                placeholder = "Thana",
                selectedItem = appointment.thana,
                onItemSelected = {
                    viewModel.updateThana(it)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            DropDown(
                modifier = Modifier.padding(16.dp),
                items = BangladeshLocations.hospitals[appointment.thana] ?: emptyList(),
                placeholder = "Hospital",
                selectedItem = appointment.hospital,
                onItemSelected = {
                    viewModel.updateHospital(it)
                    // Reset doctor when hospital changes
                    viewModel.updateDoctorName("")
                    // Reset time when hospital changes
                    viewModel.updateTime("")
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            
            // Replace TextField with DropDown for doctor selection
            DropDown(
                modifier = Modifier.padding(16.dp),
                items = BangladeshLocations.doctors[appointment.hospital] ?: emptyList(),
                placeholder = "Select Doctor",
                selectedItem = appointment.doctorName,
                onItemSelected = {
                    viewModel.updateDoctorName(it)
                    // Reset time when doctor changes
                    viewModel.updateTime("")
                }
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            DatePickerField(
                modifier = Modifier.padding(16.dp),
                placeholder = "Appointment Date",
                selectedDate = appointment.date,
                onDateSelected = {
                    viewModel.updateDate(it)
                    // Reset time when date changes
                    viewModel.updateTime("")
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            
            // Replace TimePickerField with TimeSlotPicker
            if (appointment.doctorName.isNotEmpty()) {
                val doctorSchedule = BangladeshLocations.doctorSchedules[appointment.doctorName] ?: emptyList()
                TimeSlotPicker(
                    modifier = Modifier.padding(16.dp),
                    availableTimeSlots = doctorSchedule,
                    selectedTimeSlot = appointment.time,
                    onTimeSlotSelected = {
                        viewModel.updateTime(it)
                    }
                )
            } else {
                Text(
                    text = "Select a doctor to view available time slots",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(120.dp),
                value = appointment.symptoms,
                onValueChange = {
                    viewModel.updateSymptoms(it)
                },
                label = { Text("Symptoms") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                maxLines = 5,
                singleLine = false
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = {
                    viewModel.bookAppointment(
                        onSuccess = { appointmentId ->
                            Toast.makeText(context, "Appointment booked successfully!", Toast.LENGTH_SHORT).show()
                            onAppointmentSuccess(appointmentId)
                        },
                        onFailure = { errorMessage ->
                            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            ) {
                Text(text = "Book Appointment")
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun AppointmentBookingScreenPrev() {
//    MediConnectTheme {
//        AppointmentBookingScreen(
//            viewModel = AppointmentBookingViewModel(AppointmentRepo(
//                auth = TODO(),
//                firestore = TODO()
//            ))
//        )
//    }
//}

