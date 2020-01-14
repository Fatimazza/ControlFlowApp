package id.co.iconpln.controlflowapp.model.myUser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDataResponse(
    val address: String,
    val id: Int,
    val name: String,
    val phone: String
): Parcelable
