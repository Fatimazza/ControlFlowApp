package id.co.iconpln.controlflowapp.contact

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class ContactViewModel : ViewModel() {

    private val listContacts = MutableLiveData<ArrayList<Contact>>()

    internal fun setContact() {
        val client = AsyncHttpClient()
        val listItemContacts = ArrayList<Contact>()
        val url = "https://api.androidhive.info/contacts/"

        // Request Contact API
        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {
                try {
                    //get data list JSON Array
                    val result = String(responseBody)
                    val responseObject = JSONObject(result)
                    val arrayContacts = responseObject.getJSONArray("contact")

                    //convert JSON Object to readable data
                    //data in JSON Object is read by its KEY, exp. id, name
                    for (i in 0 until arrayContacts.length()) {
                        val contact = arrayContacts.getJSONObject(i)
                        val contactItem = Contact()

                        contactItem.id = contact.getString("id")
                        contactItem.name = contact.getString("name")
                        contactItem.email = contact.getString("email")
                        contactItem.mobile = contact.getJSONObject("phone").getString("mobile")

                        listItemContacts.add(contactItem)
                    }

                    //post realtime latest value from Background Thread
                    listContacts.postValue(listItemContacts)

                } catch (e: Exception) {
                    Log.d("Exception", e.message.toString())
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                Log.d("onFailure", error.message.toString())
            }
        })
    }

    internal fun getContact(): LiveData<ArrayList<Contact>> {
        return listContacts
    }

}
