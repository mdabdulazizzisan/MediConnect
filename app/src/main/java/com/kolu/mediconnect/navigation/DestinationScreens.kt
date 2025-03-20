package com.kolu.mediconnect.navigation

import kotlinx.serialization.Serializable

sealed class DestinationScreens {
    @Serializable
    data object Home: DestinationScreens()

    @Serializable
    data object Login: DestinationScreens()

    @Serializable
    data object Register: DestinationScreens()
}