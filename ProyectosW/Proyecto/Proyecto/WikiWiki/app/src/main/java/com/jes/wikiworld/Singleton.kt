package com.jes.wikiworld

object Singleton {
    private var userName: String? = null

    fun setUserName(name: String) {
        userName = name
    }

    fun getUserName(): String? {
        return userName
    }


    object AdditionalInfoProvider {
        private val additionalInfoMap = mapOf(
            "Alpinismo" to "Desde las cordilleras hasta las cumbres más altas, el alpinismo es una actividad emocionante que te lleva a explorar la naturaleza en su forma más majestuosa.",
            "Running" to "Descubre las mejores pistas y senderos para correr, mantente en forma y disfruta del aire libre mientras exploras nuevos lugares.",
            "Senderismo" to "Desde las montañas mas peligrosas hasta donde tus pies te lleven.",
            "Surf" to "Los mejores lugares, donde las olas surcan hasta los cielos.",
            "Ciclismo" to "Tu elijes con qué bicicleta haces tus rutas, pero recuerda que por muy cara que sea la bicicleta son tus piernas las que mandan."
        )

        fun getAdditionalInfo(activity: String): String? {
            return additionalInfoMap[activity]
        }


    }
}