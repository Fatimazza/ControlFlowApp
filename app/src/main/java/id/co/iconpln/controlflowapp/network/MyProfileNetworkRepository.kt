package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.model.myProfile.BaseProfileResponse
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginResponse
import id.co.iconpln.controlflowapp.model.myProfile.ProfileLoginUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileNetworkRepository {

    fun doLogin(profileLoginUser: ProfileLoginUser): MutableLiveData<ProfileLoginResponse> {

        val loginData = MutableLiveData<ProfileLoginResponse>()

        NetworkConfig.profileApi().loginUser(profileLoginUser).enqueue(object : Callback<BaseProfileResponse<ProfileLoginResponse>> {
            override fun onFailure(
                call: Call<BaseProfileResponse<ProfileLoginResponse>>,
                t: Throwable
            ) {
                loginData.postValue(null)
            }

            override fun onResponse(
                call: Call<BaseProfileResponse<ProfileLoginResponse>>,
                response: Response<BaseProfileResponse<ProfileLoginResponse>>
            ) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()?.data
                    loginData.postValue(loginResponse)
                } else {
                    loginData.postValue(null)

                }
            }
        })

        return loginData
    }

}
