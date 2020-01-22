package id.co.iconpln.controlflowapp.MyProfile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.model.myProfile.ProfileResponse
import id.co.iconpln.controlflowapp.network.MyProfileNetworkRepository

class MyProfileViewModel : ViewModel() {

    fun getProfile(token: String): MutableLiveData<ProfileResponse> {
        return MyProfileNetworkRepository().getProfile(token)
    }
    
}
