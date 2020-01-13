package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.model.myContact.BaseContactResponse
import id.co.iconpln.controlflowapp.model.myContact.ContactResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyContactNetworkRepository {

    fun fetchContacts(): MutableLiveData<ArrayList<ContactResponse>> {

        val contactsData = MutableLiveData<ArrayList<ContactResponse>>()
        val listContact = ArrayList<ContactResponse>()

        NetworkConfig.contactApi().fetchContacts().enqueue(object : Callback<BaseContactResponse<ContactResponse>> {
            override fun onFailure(call: Call<BaseContactResponse<ContactResponse>>, t: Throwable) {
                contactsData.postValue(null)
            }

            override fun onResponse(
                call: Call<BaseContactResponse<ContactResponse>>,
                response: Response<BaseContactResponse<ContactResponse>>
            ) {
                if (response.isSuccessful) {
                    val listContactSize = response.body()?.contacts?.size as Int
                    for (i in 0 until listContactSize) {
                        listContact.add(response.body()?.contacts?.get(i) as ContactResponse)
                    }
                    contactsData.postValue(listContact)
                }
            }
        })

        return contactsData
    }
}
