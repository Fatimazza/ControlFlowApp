package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.model.myUser.*
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

    fun updateUser(id: Int, userData: UserDataResponse): MutableLiveData<UserDataResponse>{

        val updatedUserData = MutableLiveData<UserDataResponse>()

        NetworkConfig.userApi().updateUser(id, userData).enqueue(object : Callback<UpdatedUserResponse<UserDataResponse>> {
            override fun onFailure(
                call: Call<UpdatedUserResponse<UserDataResponse>>,
                t: Throwable
            ) {
                updatedUserData.postValue(null)
            }

            override fun onResponse(
                call: Call<UpdatedUserResponse<UserDataResponse>>,
                response: Response<UpdatedUserResponse<UserDataResponse>>
            ) {
                if (response.isSuccessful) {
                    val updatedUserResponse = response.body()?.updated_user as UserDataResponse
                    updatedUserData.postValue(updatedUserResponse)
                } else {
                    updatedUserData.postValue(null)
                }
            }
        })

        return updatedUserData

    }

    fun deleteUser(id: Int): MutableLiveData<UserDataResponse> {

        val deleteUserData = MutableLiveData<UserDataResponse>()

        NetworkConfig.userApi().deleteUser(id).enqueue(object : Callback<DeletedUserResponse<UserDataResponse>>{
            override fun onFailure(
                call: Call<DeletedUserResponse<UserDataResponse>>,
                t: Throwable
            ) {
                deleteUserData.postValue(null)
            }

            override fun onResponse(
                call: Call<DeletedUserResponse<UserDataResponse>>,
                response: Response<DeletedUserResponse<UserDataResponse>>
            ) {
                if (response.isSuccessful) {
                    val deleteUserResponse = response.body()?.deleted_user as UserDataResponse
                    deleteUserData.postValue(deleteUserResponse)
                } else {
                    deleteUserData.postValue(null)
                }
            }
        })

        return deleteUserData

    }

    fun createUser(userData: UserDataResponse): MutableLiveData<UserDataResponse> {

        val createdUserData = MutableLiveData<UserDataResponse>()

        NetworkConfig.userApi().createUser(userData).enqueue(object : Callback<CreatedUserResponse<UserDataResponse>>{
            override fun onFailure(
                call: Call<CreatedUserResponse<UserDataResponse>>,
                t: Throwable
            ) {
                createdUserData.postValue(null)
            }

            override fun onResponse(
                call: Call<CreatedUserResponse<UserDataResponse>>,
                response: Response<CreatedUserResponse<UserDataResponse>>
            ) {
                if (response.isSuccessful) {
                    val createUserResponse = response.body()?.created_users as UserDataResponse
                    createdUserData.postValue(createUserResponse)
                } else {
                    createdUserData.postValue(null)
                }
            }
        } )

        return createdUserData
    }

}
