package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.model.myContact.BaseContactResponse
import id.co.iconpln.controlflowapp.model.myContact.ContactResponse
import retrofit2.Callback

class MyContactNetworkRepository {

    fun getContacts(): MutableLiveData<ArrayList<ContactResponse>> {
        
        val contactsData = MutableLiveData<ArrayList<ContactResponse>>()

        NetworkConfig.contactApi().fetchContacts().enqueue(object : Callback<BaseContactResponse<ContactResponse>> {})

        return contactsData
    }
}
