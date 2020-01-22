package id.co.iconpln.controlflowapp.myProfileLogin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginResponse
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginUser
import id.co.iconpln.controlflowapp.network.MyProfileNetworkRepository

class MyProfileLoginViewModel : ViewModel() {

    companion object {
        var errorMessage = ""
    }

    fun login(profileLoginUser: ProfileLoginUser): MutableLiveData<ProfileLoginResponse> {
        return MyProfileNetworkRepository().doLogin(profileLoginUser)
    }

}
