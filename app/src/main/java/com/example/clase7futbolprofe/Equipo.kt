package com.example.clase7futbolprofe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Equipo (
    val id:Int,
    val nombre:String,
    val total:Int,
    val pais:Pais,
    val logo:String
): Parcelable

enum class Pais {
    ARGENTINA,
    BRASIL,
    CHILE,
    URUGUAY,
    PARAGUAY,
    COLOMBIA
}



