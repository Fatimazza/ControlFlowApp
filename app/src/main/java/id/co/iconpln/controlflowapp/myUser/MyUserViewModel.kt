package id.co.iconpln.controlflowapp.myUser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.model.myUser.UserDataResponse
import id.co.iconpln.controlflowapp.network.MyUserNetworkRepository

class MyUserViewModel : ViewModel() {

    fun getListUsers(): MutableLiveData<ArrayList<UserDataResponse>> {
        return MyUserNetworkRepository().getAllUsers()
    }
}
