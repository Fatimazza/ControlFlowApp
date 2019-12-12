package id.co.iconpln.controlflowapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.fragment_last.*

/**
 * A simple [Fragment] subclass.
 */
class LastFragment : Fragment() {

    companion object {
        const val EXTRA_NAME_FRAGMENT = "extra_name_fragment"
        var message: String = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val name = arguments?.getString(EXTRA_NAME_FRAGMENT)
        tvLastName.text = name
        tvLastMessage.text = message
    }

}
