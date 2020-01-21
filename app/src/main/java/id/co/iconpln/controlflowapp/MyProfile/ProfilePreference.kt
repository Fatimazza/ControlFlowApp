package id.co.iconpln.controlflowapp.MyProfile

import android.content.Context
import id.co.iconpln.controlflowapp.model.myProfile.Profile

internal class ProfilePreference(context: Context) {

    companion object {
        private const val PREFS_PROFILE = "profile_prefs"
        private const val TOKEN = "token"
    }

    private val preferences = context.getSharedPreferences(PREFS_PROFILE, Context.MODE_PRIVATE)

    fun setProfile(value: Profile) {
        val editor = preferences.edit()
        editor.putString(TOKEN, value.userToken)
        editor.apply()
    }

    fun getProfile(): Profile {
        val model = Profile()
        model.userToken = preferences.getString(TOKEN, "")
        return model
    }

}
