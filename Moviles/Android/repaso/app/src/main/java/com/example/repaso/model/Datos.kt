package com.example.repaso.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Datos(

    val id : Int,
    val nombre : String?,
    val descripcion : String

) : Parcelable {
}