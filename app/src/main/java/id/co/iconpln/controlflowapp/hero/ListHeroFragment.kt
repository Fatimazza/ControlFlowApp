package id.co.iconpln.controlflowapp.hero


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    private lateinit var listHeroAdapter: ListHeroAdapter

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
        setListHeroItemClickListener()
    }

    private fun setupListHero() {
        rvFragmentListHero.setHasFixedSize(true)
        listHero.addAll(getDataHero())
    }

    private fun getDataHero(): ArrayList<Hero> {
        val heroName = resources.getStringArray(R.array.hero_name)
        val heroDesc = resources.getStringArray(R.array.hero_description)
        val heroPhoto = resources.getStringArray(R.array.hero_photo)

        val listHero = ArrayList<Hero>()
        for (position in heroName.indices) {
            val hero = Hero(
                heroName[position],
                heroDesc[position],
                heroPhoto[position]
            )
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerViewList() {
        rvFragmentListHero.layoutManager = LinearLayoutManager(requireContext())
        listHeroAdapter = ListHeroAdapter(listHero)
        rvFragmentListHero.adapter = listHeroAdapter
    }

    private fun setListHeroItemClickListener() {
        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback{
            override fun onItemClick(hero: Hero) {
                Toast.makeText(requireContext(), "You choose ${hero.name}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
