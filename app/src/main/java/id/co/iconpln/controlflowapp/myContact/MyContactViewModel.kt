package id.co.iconpln.controlflowapp.myContact


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.model.myContact.ContactResponse
import id.co.iconpln.controlflowapp.network.MyContactNetworkRepository

class MyContactViewModel : ViewModel() {

    fun getListContacts(): MutableLiveData<ArrayList<ContactResponse>> {
        return MyContactNetworkRepository().fetchContacts()
    }
}
