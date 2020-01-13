package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.model.myUser.BaseUserResponse
import id.co.iconpln.controlflowapp.model.myUser.UserDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyUserNetworkRepository {

    fun getAllUsers(): MutableLiveData<ArrayList<UserDataResponse>> {

        val usersData = MutableLiveData<ArrayList<UserDataResponse>>()
        val listUser = ArrayList<UserDataResponse>()

        NetworkConfig.userApi().getAllUsers().enqueue(object : Callback<BaseUserResponse<UserDataResponse>> {
            override fun onFailure(call: Call<BaseUserResponse<UserDataResponse>>, t: Throwable) {
                usersData.postValue(null)
            }

            override fun onResponse(
                call: Call<BaseUserResponse<UserDataResponse>>,
                response: Response<BaseUserResponse<UserDataResponse>>
            ) {
                if (response.isSuccessful) {
                    val listUserSize = response.body()?.data?.size as Int
                    for (i in 0 until listUserSize) {
                        listUser.add(response.body()?.data?.get(i) as UserDataResponse)
                    }
                    usersData.postValue(listUser)
                }
            }
        })

        return usersData
    }

}
