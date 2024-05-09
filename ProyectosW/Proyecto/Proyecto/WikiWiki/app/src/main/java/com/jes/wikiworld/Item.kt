package com.jes.wikiworld

import java.io.Serializable

data class Item(
    val id: Int,
    val description: String,
    val nombre: String,
    val additionalInfo: String// Campo para almacenar información adicional
) : Serializable
