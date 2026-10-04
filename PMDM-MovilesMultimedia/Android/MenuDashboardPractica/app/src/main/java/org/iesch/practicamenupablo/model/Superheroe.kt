package org.iesch.practicamenupablo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Superheroe(
    val nombre: String,
    val alterEgo: String,
    val bio: String,
    val poder: Float
) : Parcelable