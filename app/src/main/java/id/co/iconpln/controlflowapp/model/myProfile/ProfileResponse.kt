package id.co.iconpln.controlflowapp.model.myProfile

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileResponse(
    val balance: Int,
    val created_at: String,
    val device_id: String,
    val email: String,
    val id: Int,
    val is_active: Boolean,
    val language: String,
    val name: String,
    val notif_token: String,
    val phone: String,
    val updated_at: String
): Parcelable
