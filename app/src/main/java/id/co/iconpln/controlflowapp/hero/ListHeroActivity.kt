package id.co.iconpln.controlflowapp.hero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.Hero
import id.co.iconpln.controlflowapp.model.HeroesData
import kotlinx.android.synthetic.main.activity_hero.*

class ListHeroActivity : AppCompatActivity() {

    private var listHero: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)

        setupListHero()
        showRecyclerGrid()
    }

    private fun setupListHero() {
        rvListHero.setHasFixedSize(true)
        listHero.addAll(HeroesData.listDataHero)
        setupListDivider()
    }

    private fun showRecyclerList() {
        rvListHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(listHero)
        rvListHero.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClick(hero: Hero) {
                Toast.makeText(this@ListHeroActivity, "You choose ${hero.name}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupListDivider() {
        val dividerItemDecoration =  DividerItemDecoration(rvListHero.context, DividerItemDecoration.VERTICAL)
        rvListHero.addItemDecoration(dividerItemDecoration)
    }

    private fun showRecyclerGrid() {
        rvListHero.layoutManager = GridLayoutManager(this,2)
        val gridHeroAdapter = GridHeroAdapter(listHero)
        rvListHero.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridHeroAdapter.OnItemClickCallback{
            override fun onItemClick(hero: Hero) {
                Toast.makeText(this@ListHeroActivity, "You choose ${hero.name}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_hero, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setListMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setListMode(mode: Int) {
        when (mode) {
            R.id.action_hero_list -> {

            }
            R.id.action_hero_grid -> {

            }
        }
    }
}
