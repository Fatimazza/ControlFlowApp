package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.model.myUser.BaseUserResponse
import id.co.iconpln.controlflowapp.model.myUser.UserDataResponse
import retrofit2.Callback

class MyUserNetworkRepository {

    fun getAllUsers(): MutableLiveData<ArrayList<UserDataResponse>> {

        val usersData = MutableLiveData<ArrayList<UserDataResponse>>()
        val listUser = ArrayList<UserDataResponse>()

        NetworkConfig.userApi().getAllUsers().enqueue(object : Callback<BaseUserResponse<UserDataResponse>> {})

        return usersData
    }

}
