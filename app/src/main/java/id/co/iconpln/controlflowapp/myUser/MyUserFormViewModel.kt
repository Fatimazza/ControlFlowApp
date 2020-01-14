package id.co.iconpln.controlflowapp.myUser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.model.myUser.UserDataResponse
import id.co.iconpln.controlflowapp.network.MyUserNetworkRepository

class MyUserFormViewModel : ViewModel() {

    fun updateUser(id: Int, userData: UserDataResponse): MutableLiveData<UserDataResponse> {
        return MyUserNetworkRepository().updateUser(id, userData)
    }

    fun deleteUser(id: Int): MutableLiveData<UserDataResponse> {
        return MyUserNetworkRepository().deleteUser(id)
    }

}
