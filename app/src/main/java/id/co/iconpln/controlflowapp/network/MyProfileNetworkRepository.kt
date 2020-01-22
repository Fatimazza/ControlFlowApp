package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.model.myProfile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileNetworkRepository {

    fun doLogin(profileLoginUser: ProfileLoginUser): MutableLiveData<ProfileLoginResponse> {

        val loginData = MutableLiveData<ProfileLoginResponse>()

        NetworkConfig.profileApi().loginUser(profileLoginUser).enqueue(object : Callback<BaseProfileLoginResponse<ProfileLoginResponse>> {
            override fun onFailure(
                call: Call<BaseProfileLoginResponse<ProfileLoginResponse>>,
                t: Throwable
            ) {
                loginData.postValue(null)
            }

            override fun onResponse(
                call: Call<BaseProfileLoginResponse<ProfileLoginResponse>>,
                response: Response<BaseProfileLoginResponse<ProfileLoginResponse>>
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

    fun doRegister(profileRegisterUser: ProfileRegisterUser)
            : MutableLiveData<ProfileResponse> {

        val registerData = MutableLiveData<ProfileResponse>()

        NetworkConfig.profileApi().registerUser(profileRegisterUser)
            .enqueue(object : Callback<ProfileRegisterResponse<ProfileResponse>> {
                override fun onFailure(
                    call: Call<ProfileRegisterResponse<ProfileResponse>>,
                    t: Throwable
                ) {
                    registerData.postValue(null)
                }

                override fun onResponse(
                    call: Call<ProfileRegisterResponse<ProfileResponse>>,
                    response: Response<ProfileRegisterResponse<ProfileResponse>>
                ) {
                    if (response.isSuccessful) {
                        val registerResponse = response.body()?.data
                        registerData.postValue(registerResponse)
                    } else {
                        registerData.postValue(null)
                    }
                }
            })

        return registerData

    }

    fun getProfile(token: String): MutableLiveData<ProfileResponse> {

        val profileData = MutableLiveData<ProfileResponse>()

        NetworkConfig.profileApi().getProfile(token).enqueue(
            object : Callback<BaseProfileResponse<ProfileResponse>> {
                override fun onFailure(
                    call: Call<BaseProfileResponse<ProfileResponse>>,
                    t: Throwable
                ) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<BaseProfileResponse<ProfileResponse>>,
                    response: Response<BaseProfileResponse<ProfileResponse>>
                ) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        )

        return profileData

    }

}
