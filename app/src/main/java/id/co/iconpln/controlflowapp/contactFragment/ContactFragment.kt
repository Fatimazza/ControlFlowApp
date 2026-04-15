package id.co.iconpln.controlflowapp.contactFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.contact.ContactAdapter
import id.co.iconpln.controlflowapp.databinding.FragmentContactBinding


class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ContactAdapter

    private lateinit var contactFragmentViewModel: ContactFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        showListContact()

        showLoading(true)
        contactFragmentViewModel.setContact()
        fetchContactData()
    }

    private fun initViewModel() {
        contactFragmentViewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        ).get(ContactFragmentViewModel::class.java)
    }

    private fun showListContact() {
        adapter = ContactAdapter()
        adapter.notifyDataSetChanged()

        binding.rvContactFragmentList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvContactFragmentList.adapter = adapter
    }

    private fun fetchContactData() {
        //get value from View Model's Live Data
        contactFragmentViewModel.getContact().observe(viewLifecycleOwner, Observer { contactItem ->
            if (contactItem != null) {
                adapter.setData(contactItem)
                showLoading(false)
            }
            contactFragmentViewModel.toastMessage.observe(viewLifecycleOwner) { message ->
                message?.let {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.pbContactFragmentLoading.visibility = View.VISIBLE
        } else {
            binding.pbContactFragmentLoading.visibility = View.GONE
        }
    }
}
