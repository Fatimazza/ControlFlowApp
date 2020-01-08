package id.co.iconpln.controlflowapp.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel() {

    private val listContacts = MutableLiveData<ArrayList<Contact>>()

    internal fun setContact() {
        
    }

    internal fun getContact(): LiveData<ArrayList<Contact>> {
        return listContacts
    }

}
