package com.kolu.mediconnect.domain.model

object BangladeshLocations {
    val divisions = listOf(
        "Dhaka",
        "Chittagong",
        "Rajshahi",
        "Khulna",
        "Barishal",
        "Sylhet",
        "Rangpur",
        "Mymensingh"
    )

    val districts = mapOf(
        "Dhaka" to listOf(
            "Dhaka",
            "Gazipur",
            "Narayanganj",
            "Manikganj",
            "Munshiganj",
            "Narsingdi",
            "Tangail"
        ),
        "Chittagong" to listOf(
            "Chittagong",
            "Cox's Bazar",
            "Rangamati",
            "Bandarban",
            "Khagrachari",
            "Feni",
            "Lakshmipur"
        ),
        // Add other division districts as needed
    )

    val thanas = mapOf(
        "Dhaka" to listOf(
            "Mirpur",
            "Mohammadpur",
            "Dhanmondi",
            "Gulshan",
            "Uttara",
            "Banani",
            "Badda",
            "Savar"
        ),
        "Chittagong" to listOf(
            "Kotwali",
            "Panchlaish",
            "Double Mooring",
            "Chandgaon",
            "Bakalia",
            "Bayazid Bostami"
        ),
        // Add other district thanas as needed
    )

    val hospitals = mapOf(
        "Dhaka" to listOf(
            "Dhaka Medical College Hospital",
            "Bangabandhu Sheikh Mujib Medical University",
            "Evercare Hospital Dhaka",
            "Square Hospital",
            "United Hospital"
        ),
        "Chittagong" to listOf(
            "Chittagong Medical College Hospital",
            "Max Hospital Chittagong",
            "Parkview Hospital",
            "Imperial Hospital",
            "Chittagong Diabetic Hospital"
        ),
        "Savar" to listOf(
            "Enam Medical College Hospital",
            "Gana Hospital",
            "Savar Upazila Health Complex",
            "Daffodil Medical College Hospital"
        ),
        // Add other district hospitals as needed
    )
}