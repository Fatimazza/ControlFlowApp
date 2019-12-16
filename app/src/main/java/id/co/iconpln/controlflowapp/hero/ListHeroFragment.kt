package id.co.iconpln.controlflowapp.hero


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.Hero
import id.co.iconpln.controlflowapp.model.HeroesData
import kotlinx.android.synthetic.main.fragment_list_hero.*

/**
 * A simple [Fragment] subclass.
 */
class ListHeroFragment : Fragment() {

    private var listHero: ArrayList<Hero> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_hero, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListHero()
        showRecyclerViewList()
    }

    private fun setupListHero() {
        rvFragmentListHero.setHasFixedSize(true)
        listHero.addAll(HeroesData.listDataHero)
    }

    private fun showRecyclerViewList() {
        rvFragmentListHero.layoutManager = LinearLayoutManager(requireContext())
        val listHeroAdapter = ListHeroAdapter(listHero)
        rvFragmentListHero.adapter = listHeroAdapter
    }
}
