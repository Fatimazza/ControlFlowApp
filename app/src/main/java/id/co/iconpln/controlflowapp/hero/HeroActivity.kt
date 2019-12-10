package id.co.iconpln.controlflowapp.hero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.Hero
import id.co.iconpln.controlflowapp.model.HeroesData
import kotlinx.android.synthetic.main.activity_hero.*

class HeroActivity : AppCompatActivity() {

    private var listHero: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)

        setupListHero()
        showRecyclerList()
    }

    private fun setupListHero() {
        rvListHero.setHasFixedSize(true)
        listHero.addAll(HeroesData.listDataHero)
    }

    private fun showRecyclerList() {
        rvListHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = HeroAdapter(listHero)
        rvListHero.adapter = listHeroAdapter
    }
}
