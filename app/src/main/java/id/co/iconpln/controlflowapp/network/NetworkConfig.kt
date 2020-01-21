package id.co.iconpln.controlflowapp.network

import id.co.iconpln.controlflowapp.BuildConfig
import id.co.iconpln.controlflowapp.model.myContact.BaseContactResponse
import id.co.iconpln.controlflowapp.model.myContact.ContactResponse
import id.co.iconpln.controlflowapp.model.myUser.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

class NetworkConfig {

    companion object {

        @Volatile
        private var retrofit: Retrofit? = null

        private fun getRetrofit(): Retrofit {
            return retrofit ?: synchronized(this) {
                retrofit ?: buildRetrofit().also {
                    retrofit = it
                }
            }
        }

        private fun buildRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.CONTACT_BASE_URL)
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun getUserRetrofit(): Retrofit {
            return retrofit ?: synchronized(this) {
                retrofit ?: buildUserRetrofit().also {
                    retrofit = it
                }
            }
        }

        private fun buildUserRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.USER_BASE_URL)
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun getProfileRetrofit(): Retrofit {
            return retrofit ?: synchronized(this) {
                retrofit ?: buildProfileRetrofit().also {
                    retrofit = it
                }
            }
        }

        private fun buildProfileRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.PROFILE_BASE_URL)
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun getInterceptor(): OkHttpClient {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
        }

        fun contactApi(): ContactAPIService {
            return getRetrofit().create(ContactAPIService::class.java)
        }

        fun userApi(): UserAPIService {
            return getUserRetrofit().create(UserAPIService::class.java)
        }

        fun profileApi(): ProfileAPIService {
            return getProfileRetrofit().create(ProfileAPIService::class.java)
        }

    }

}

interface ContactAPIService {

    @GET("contacts")
    fun fetchContacts()
            : Call<BaseContactResponse<ContactResponse>>

}

interface UserAPIService {

    @GET("api/v1/users")
    fun getAllUsers()
            : Call<BaseUserResponse<UserDataResponse>>

    @PUT("api/v1/user/{id}")
    fun updateUser(@Path("id") id: Int, @Body userData: UserDataResponse)
            : Call<UpdatedUserResponse<UserDataResponse>>

    @DELETE("api/v1/user/{id}")
    fun deleteUser(@Path("id") id: Int)
            : Call<DeletedUserResponse<UserDataResponse>>

    @POST("api/v1/user")
    fun createUser(@Body userData: UserDataResponse)
            : Call<CreatedUserResponse<UserDataResponse>>

    @GET("api/v1/user/{id}")
    fun getUser(@Path("id") id: Int)
            : Call<SingleUserResponse<UserDataResponse>>
}

interface ProfileAPIService {

}
