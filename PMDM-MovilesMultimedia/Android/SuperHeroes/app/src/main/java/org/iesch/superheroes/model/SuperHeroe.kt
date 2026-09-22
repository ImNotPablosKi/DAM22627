package org.iesch.superheroes.model

// 1 - Me creo el objeto SuperHeroe y lo hago parcelizable


data class SuperHeroe (

    val nombre: String,
    val alterEgo: String,
    val bio: String,
    val power: Float

)