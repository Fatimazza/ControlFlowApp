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

        NetworkConfig.contactApi().fetchContacts().enqueue(object : Callback<BaseContactResponse<ContactResponse>> {
            override fun onFailure(call: Call<BaseContactResponse<ContactResponse>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<BaseContactResponse<ContactResponse>>,
                response: Response<BaseContactResponse<ContactResponse>>
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        return contactsData
    }
}
