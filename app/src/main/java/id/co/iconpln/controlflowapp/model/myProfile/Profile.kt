package id.co.iconpln.controlflowapp.model.myProfile

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    var userToken: String? = null
) : Parcelable
