package id.co.iconpln.controlflowapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    var name: String = "",
    var desc: String = "",
    var photo: String = ""
): Parcelable
