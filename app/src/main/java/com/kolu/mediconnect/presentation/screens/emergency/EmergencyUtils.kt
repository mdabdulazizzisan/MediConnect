package com.kolu.mediconnect.presentation.screens.emergency

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.telephony.SmsManager
import android.widget.Toast
import androidx.core.content.ContextCompat

fun sendEmergencySms(context: Context, phoneNumber: String, message: String): Boolean {
    return try {
        // Check for SMS permission
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.SEND_SMS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            true
        } else {
            Toast.makeText(
                context,
                "SMS permission not granted",
                Toast.LENGTH_SHORT
            ).show()
            false
        }
    } catch (e: Exception) {
        Toast.makeText(
            context,
            "Failed to send SMS: ${e.message}",
            Toast.LENGTH_SHORT
        ).show()
        false
    }
}

fun makeEmergencyCall(context: Context, phoneNumber: String): Boolean {
    return try {
        // Check for call permission
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$phoneNumber")
            context.startActivity(intent)
            true
        } else {
            Toast.makeText(
                context,
                "Call permission not granted",
                Toast.LENGTH_SHORT
            ).show()
            false
        }
    } catch (e: Exception) {
        Toast.makeText(
            context,
            "Failed to initiate call: ${e.message}",
            Toast.LENGTH_SHORT
        ).show()
        false
    }
}