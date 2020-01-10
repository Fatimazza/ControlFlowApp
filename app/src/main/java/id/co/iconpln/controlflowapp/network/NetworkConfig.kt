package id.co.iconpln.controlflowapp.network

import id.co.iconpln.controlflowapp.BuildConfig
import id.co.iconpln.controlflowapp.model.contact.ContactResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

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
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun contactApi(): ContactAPIService {
            return getRetrofit().create(ContactAPIService::class.java)
        }

    }

}

interface ContactAPIService {

    @GET("contacts")
    fun fetchContacts()
            : Call<ContactResponse>

}
