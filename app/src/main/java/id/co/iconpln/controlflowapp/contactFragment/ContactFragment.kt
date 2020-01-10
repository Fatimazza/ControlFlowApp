package id.co.iconpln.controlflowapp.contactFragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.contact.ContactAdapter
import kotlinx.android.synthetic.main.fragment_contact.*

/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {

    private lateinit var adapter: ContactAdapter

    private lateinit var contactFragmentViewModel: ContactFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        showListContact()
    }

    private fun initViewModel() {
        contactFragmentViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(ContactFragmentViewModel::class.java)
    }

    private fun showListContact() {
        adapter = ContactAdapter()
        adapter.notifyDataSetChanged()

        rvContactFragmentList.layoutManager = LinearLayoutManager(requireContext())
        rvContactFragmentList.adapter = adapter
    }
    
}
