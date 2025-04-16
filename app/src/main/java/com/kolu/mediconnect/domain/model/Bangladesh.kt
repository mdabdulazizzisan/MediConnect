package com.kolu.mediconnect.domain.model

object BangladeshLocations {
    val divisions = listOf(
        "Dhaka",
        "Chittagong",
        "Rajshahi",
        "Khulna",
        "Barishal",
        "Sylhet",
        "Rangpur"
    )

    val districts = mapOf(
        "Dhaka" to listOf("Dhaka", "Gazipur", "Narayanganj"),
        "Chittagong" to listOf("Chittagong", "Cox's Bazar", "Feni"),
        "Rajshahi" to listOf("Rajshahi", "Pabna", "Natore"),
        "Khulna" to listOf("Khulna", "Jessore", "Satkhira"),
        "Barishal" to listOf("Barishal", "Patuakhali", "Bhola"),
        "Sylhet" to listOf("Sylhet", "Moulvibazar", "Habiganj"),
        "Rangpur" to listOf("Rangpur", "Dinajpur", "Gaibandha")
    )

    val thanas = mapOf(
        "Dhaka" to listOf("Dhanmondi", "Gulshan", "Mirpur", "Uttara", "Mohammadpur"),
        "Gazipur" to listOf("Tongi", "Sreepur", "Kaliakair", "Kapasia", "Kaliganj"),
        "Narayanganj" to listOf("Narayanganj Sadar", "Bandar", "Rupganj", "Sonargaon", "Araihazar"),
        "Chittagong" to listOf("Kotwali", "Panchlaish", "Double Mooring", "Chandgaon", "Bakalia"),
        "Cox's Bazar" to listOf("Cox's Bazar Sadar", "Chakaria", "Teknaf", "Ukhiya", "Ramu"),
        "Feni" to listOf("Feni Sadar", "Chhagalnaiya", "Daganbhuiyan", "Parshuram", "Fulgazi"),
        "Rajshahi" to listOf("Rajshahi Sadar", "Boalia", "Motihar", "Shah Makhdum", "Paba"),
        "Pabna" to listOf("Pabna Sadar", "Ishwardi", "Santhia", "Bera", "Sujanagar"),
        "Natore" to listOf("Natore Sadar", "Baraigram", "Bagatipara", "Lalpur", "Singra"),
        "Khulna" to listOf("Khulna Sadar", "Sonadanga", "Khalishpur", "Daulatpur", "Batiaghata"),
        "Jessore" to listOf("Jessore Sadar", "Abhaynagar", "Bagherpara", "Keshabpur", "Manirampur"),
        "Satkhira" to listOf("Satkhira Sadar", "Assasuni", "Debhata", "Kaliganj", "Tala"),
        "Barishal" to listOf("Barishal Sadar", "Babuganj", "Bakerganj", "Banaripara", "Gournadi"),
        "Patuakhali" to listOf("Patuakhali Sadar", "Bauphal", "Dashmina", "Galachipa", "Kalapara"),
        "Bhola" to listOf("Bhola Sadar", "Borhanuddin", "Char Fasson", "Lalmohan", "Tazumuddin"),
        "Sylhet" to listOf("Sylhet Sadar", "Beanibazar", "Golapganj", "Zakiganj", "Kanaighat"),
        "Moulvibazar" to listOf("Moulvibazar Sadar", "Barlekha", "Juri", "Kamalganj", "Kulaura"),
        "Habiganj" to listOf("Habiganj Sadar", "Bahubal", "Chunarughat", "Madhabpur", "Nabiganj"),
        "Rangpur" to listOf("Rangpur Sadar", "Badarganj", "Gangachara", "Kaunia", "Mithapukur"),
        "Dinajpur" to listOf("Dinajpur Sadar", "Birampur", "Birganj", "Bochaganj", "Chirirbandar"),
        "Gaibandha" to listOf("Gaibandha Sadar", "Fulchhari", "Gobindaganj", "Palashbari", "Sundarganj")
    )

    val hospitals = mapOf(
        "Dhanmondi" to listOf(
            "Anwer Khan Modern Medical College Hospital",
            "Popular Diagnostic Center",
            "Green Life Medical College Hospital",
            "Ibn Sina Hospital",
            "Labaid Specialized Hospital",
            "Samorita Hospital",
            "Gonoshasthaya Nagar Hospital"
        ),
        "Gulshan" to listOf(
            "United Hospital",
            "Apollo Hospitals Dhaka",
            "Evercare Hospital Dhaka",
            "Praava Health",
            "Gulshan Clinic",
            "Labaid Diagnostic Center",
            "Medi Aid Diagnostic Center"
        ),
        "Mirpur" to listOf(
            "Dhaka Dental College Hospital",
            "National Heart Foundation Hospital",
            "Islamia Eye Hospital",
            "Care Medical College Hospital",
            "Mirpur General Hospital",
            "Al-Helal Specialized Hospital",
            "Shahid Suhrawardy Medical College Hospital"
        ),
        "Uttara" to listOf(
            "Uttara Adhunik Medical College Hospital",
            "Aichi Hospital",
            "Uttara Crescent Hospital",
            "Uttara Women's Medical College Hospital",
            "Uttara Central Hospital",
            "Uttara General Hospital",
            "Uttara Diagnostic Center"
        ),
        "Mohammadpur" to listOf(
            "Mohammadpur Central University Hospital",
            "City Hospital Ltd.",
            "Mohammadpur Fertility Services & Training Centre",
            "Mohammadpur Medical Centre",
            "Ibn Sina Diagnostic & Consultation Center",
            "Al-Manar Hospital",
            "Popular Diagnostic Center"
        ),
        "Tongi" to listOf(
            "Tongi General Hospital",
            "Tongi Diabetic Hospital",
            "Tongi Eye Hospital",
            "Tongi Children's Hospital",
            "Tongi Women's Hospital",
            "Tongi Orthopedic Hospital",
            "Tongi Heart Center"
        ),
        "Sreepur" to listOf(
            "Sreepur Upazila Health Complex",
            "Sreepur Diabetic Hospital",
            "Sreepur Eye Hospital",
            "Sreepur Children's Hospital",
            "Sreepur Women's Hospital"
        ),
        "Kaliakair" to listOf(
            "Kaliakair Upazila Health Complex",
            "Kaliakair Diabetic Hospital",
            "Kaliakair Eye Hospital"
        ),
        "Kapasia" to listOf(
            "Kapasia Upazila Health Complex",
            "Kapasia Community Clinic",
            "Kapasia Mother and Child Hospital",
            "Sheba Medical Center"
        ),
        "Kaliganj" to listOf(
            "Kaliganj Upazila Health Complex",
            "Kaliganj General Hospital",
            "Kaliganj Community Health Center",
            "Rural Medical Services"
        ),
        "Narayanganj Sadar" to listOf(
            "Narayanjanj Sadar Hospital",
            "Narayanganj Diabetic Hospital",
            "Narayanganj Eye Hospital"
        ),
        "Bandar" to listOf(
            "Bandar Health Complex",
            "Port City Hospital",
            "Bandar Medical Center",
            "Riverside Hospital",
            "Community Health Services"
        ),
        "Rupganj" to listOf(
            "Rupganj Upazila Health Complex",
            "Rupganj Modern Hospital",
            "Eastern Medical Center",
            "Green View Hospital"
        ),
        "Kotwali" to listOf(
            "Chittagong Medical College Hospital",
            "Chittagong General Hospital",
            "National Hospital",
            "Delta Medical Center",
            "Imperial Hospital Ltd"
        ),
        "Panchlaish" to listOf(
            "Chittagong Metropolitan Hospital",
            "Max Hospital & Diagnostic",
            "Royal Hospital",
            "Surgiscope Hospital",
            "Center Point Hospital"
        ),
        "Cox's Bazar Sadar" to listOf(
            "Cox's Bazar District Hospital",
            "Cox's Bazar Medical Center",
            "Sadar Modern Hospital",
            "Beach Way Hospital",
            "Cox's Bazar General Hospital"
        ),
        "Chakaria" to listOf(
            "Chakaria Upazila Health Complex",
            "Chakaria Community Hospital",
            "Chakaria Medical Services",
            "Bay of Bengal Medical Center"
        ),
        "Feni Sadar" to listOf(
            "Feni General Hospital",
            "Feni Diabetes Hospital",
            "Feni Specialized Hospital",
            "Central Medical Services"
        ),
        "Chhagalnaiya" to listOf(
            "Chhagalnaiya Upazila Health Complex",
            "Chhagalnaiya Community Clinic",
            "Rural Health Center"
        ),
        "Rajshahi Sadar" to listOf(
            "Rajshahi Medical College Hospital",
            "Rajshahi City Hospital",
            "Popular Diagnostic Center",
            "Christian Mission Hospital",
            "North Bengal Medical College Hospital"
        ),
        "Boalia" to listOf(
            "Boalia Medical Center",
            "Rajshahi Metropolitan Hospital",
            "Boalia Specialized Hospital",
            "Central Hospital Boalia"
        ),
        "Pabna Sadar" to listOf(
            "Pabna General Hospital",
            "Mental Hospital",
            "Pabna Medical Center",
            "Pabna Prime Hospital",
            "Pabna Health Services"
        ),
        "Ishwardi" to listOf(
            "Ishwardi Upazila Health Complex",
            "Rooppur Medical Center",
            "Railway Hospital",
            "Ishwardi Community Hospital"
        ),
        "Natore Sadar" to listOf(
            "Natore District Hospital",
            "Natore Medical Center",
            "Sadar Central Hospital",
            "Natore General Hospital"
        ),
        "Baraigram" to listOf(
            "Baraigram Upazila Health Complex",
            "Community Health Center",
            "Baraigram Medical Services"
        ),
        "Khulna Sadar" to listOf(
            "Khulna Medical College Hospital",
            "Gazi Medical College Hospital",
            "Khulna City Medical College Hospital",
            "Islami Bank Hospital",
            "Shaheed Sheikh Abu Naser Specialized Hospital"
        ),
        "Sonadanga" to listOf(
            "Sonadanga Medical Center",
            "Khulna Shishu Hospital",
            "Sonadanga General Hospital",
            "Modern Diagnostic Center"
        ),
        "Jessore Sadar" to listOf(
            "Jessore General Hospital",
            "Jessore Medical College Hospital",
            "Popular Medical Center",
            "Ad-din Hospital",
            "Jessore Central Hospital"
        ),
        "Abhaynagar" to listOf(
            "Abhaynagar Upazila Health Complex",
            "Abhaynagar Medical Services",
            "Rural Health Center",
            "Community Clinic Abhaynagar"
        ),
        "Satkhira Sadar" to listOf(
            "Satkhira Medical College Hospital",
            "Satkhira General Hospital",
            "Satkhira Specialized Hospital",
            "District Health Complex"
        ),
        "Assasuni" to listOf(
            "Assasuni Upazila Health Complex",
            "Rural Health Center Assasuni",
            "Assasuni Community Hospital"
        ),
        "Barishal Sadar" to listOf(
            "Sher-e-Bangla Medical College Hospital",
            "Barishal General Hospital",
            "City Hospital Barishal",
            "Sadar Hospital",
            "Modern Medical Center"
        ),
        "Babuganj" to listOf(
            "Babuganj Upazila Health Complex",
            "Babuganj Community Medical Center",
            "Rural Health Services"
        ),
        "Patuakhali Sadar" to listOf(
            "Patuakhali General Hospital",
            "Patuakhali Medical College Hospital",
            "Sadar Medical Center",
            "District Health Complex"
        ),
        "Bauphal" to listOf(
            "Bauphal Upazila Health Complex",
            "Bauphal Community Hospital",
            "Rural Medical Center"
        ),
        "Bhola Sadar" to listOf(
            "Bhola District Hospital",
            "Bhola General Hospital",
            "Sadar Medical Services",
            "Island Medical Center"
        ),
        "Borhanuddin" to listOf(
            "Borhanuddin Upazila Health Complex",
            "Borhanuddin Community Hospital",
            "Rural Health Center"
        ),
        "Sylhet Sadar" to listOf(
            "Sylhet MAG Osmani Medical College Hospital",
            "Mount Adora Hospital",
            "North East Medical College Hospital",
            "Popular Medical Center",
            "Jalalabad Ragib-Rabeya Medical College Hospital"
        ),
        "Beanibazar" to listOf(
            "Beanibazar Upazila Health Complex",
            "Beanibazar Community Hospital",
            "Border Area Medical Center",
            "Rural Health Services"
        ),
        "Moulvibazar Sadar" to listOf(
            "Moulvibazar District Hospital",
            "Moulvibazar General Hospital",
            "Tea Garden Medical Center",
            "Sadar Medical Services"
        ),
        "Barlekha" to listOf(
            "Barlekha Upazila Health Complex",
            "Barlekha Community Hospital",
            "Rural Medical Center"
        ),
        "Habiganj Sadar" to listOf(
            "Habiganj District Hospital",
            "Habiganj Medical Center",
            "Sadar General Hospital",
            "Central Medical Services"
        ),
        "Bahubal" to listOf(
            "Bahubal Upazila Health Complex",
            "Bahubal Community Health Center",
            "Rural Medical Services"
        ),
        "Rangpur Sadar" to listOf(
            "Rangpur Medical College Hospital",
            "Rangpur General Hospital",
            "Prime Medical College Hospital",
            "Rangpur Central Hospital",
            "Doctor's Community Hospital"
        ),
        "Badarganj" to listOf(
            "Badarganj Upazila Health Complex",
            "Badarganj Community Hospital",
            "Rural Medical Center"
        ),
        "Dinajpur Sadar" to listOf(
            "M Abdur Rahim Medical College Hospital",
            "Dinajpur General Hospital",
            "Dinajpur Medical Center",
            "Northern Medical College Hospital"
        ),
        "Birampur" to listOf(
            "Birampur Upazila Health Complex",
            "Birampur Community Hospital",
            "Border Area Medical Center"
        ),
        "Gaibandha Sadar" to listOf(
            "Gaibandha District Hospital",
            "Gaibandha General Hospital",
            "Sadar Medical Center",
            "Modern Hospital Gaibandha"
        ),
        "Fulchhari" to listOf(
            "Fulchhari Upazila Health Complex",
            "Fulchhari Community Hospital",
            "Riverbank Medical Center"
        )
    )

    val doctors = mapOf(
        "Anwer Khan Modern Medical College Hospital" to listOf(
            "Dr. Ahsan Habib",
            "Dr. Shirin Akter",
            "Dr. Farzana Rahman",
            "Dr. Shamsul Haque",
            "Dr. Rashedul Islam"
        ),
        "Popular Diagnostic Center" to listOf(
            "Dr. Shakib Al Hasan",
            "Dr. Shabnam Akter",
            "Dr. Tanvir Ahmed",
            "Dr. Nusrat Jahan",
            "Dr. Mahmudul Hasan"
        ),
        "Green Life Medical College Hospital" to listOf(
            "Dr. Shirin Akter",
            "Dr. Farzana Rahman",
            "Dr. Shamsul Haque",
            "Dr. Rashedul Islam",
            "Dr. Ahsan Habib"
        ),
    )

    val doctorSchedules = mapOf(
        "Dr. Ahsan Habib" to listOf(
            "10:00 AM",
            "11:00 AM",
            "12:00 PM",
            "1:00 PM",
            "2:00 PM"
        ),
        "Dr. Shirin Akter" to listOf(
            "10:30 AM",
            "11:30 AM",
            "12:30 PM",
            "1:30 PM",
            "2:30 PM"
        ),
        "Dr. Farzana Rahman" to listOf(
            "10:00 AM",
            "11:00 AM",
            "12:00 PM",
            "1:00 PM",
            "2:00 PM"
        ),
    )
}