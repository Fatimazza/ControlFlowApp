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
import id.co.iconpln.controlflowapp.databinding.ActivityListHeroBinding
import id.co.iconpln.controlflowapp.model.Hero

class ListHeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListHeroBinding

    private var listHero: ArrayList<Hero> = arrayListOf()

    private var title: String = "Mode List"
    private var mode: Int = 0

    companion object {
        private const val STATE_TITLE = "state_title"
        private const val STATE_LIST = "state_list"
        private const val STATE_MODE = "state_mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListHero()

        if (savedInstanceState == null) {
            mode = R.id.action_hero_list
            setActionBarTitle(title)
            showRecyclerList()
        } else {
            title = savedInstanceState.getString(STATE_TITLE).toString()
            val stateList = savedInstanceState.getParcelableArrayList<Hero>(STATE_LIST)
            val stateMode = savedInstanceState.getInt(STATE_MODE)

            setActionBarTitle(title)
            if (stateList != null) {
                listHero.addAll(stateList)
            }
            setListMode(stateMode)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_TITLE, title)
        outState.putParcelableArrayList(STATE_LIST, listHero)
        outState.putInt(STATE_MODE, mode)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun setupListHero() {
        binding.rvListHero.setHasFixedSize(true)
        listHero.addAll(getDataHero())
        setupListDivider()
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

    private fun showRecyclerList() {
        binding.rvListHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(listHero)
        binding.rvListHero.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClick(hero: Hero) {
                Toast.makeText(this@ListHeroActivity, "You choose ${hero.name}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun setupListDivider() {
        val dividerItemDecoration =
            DividerItemDecoration(binding.rvListHero.context, DividerItemDecoration.VERTICAL)
        binding.rvListHero.addItemDecoration(dividerItemDecoration)
    }

    private fun showRecyclerGrid() {
        binding.rvListHero.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(listHero)
        binding.rvListHero.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridHeroAdapter.OnItemClickCallback {
            override fun onItemClick(hero: Hero) {
                Toast.makeText(this@ListHeroActivity, "You choose ${hero.name}", Toast.LENGTH_SHORT)
                    .show()
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

    private fun setListMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_hero_list -> {
                title = "Mode List"
                showRecyclerList()
            }

            R.id.action_hero_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }
        }
        mode = selectedMode
        setActionBarTitle(title)
    }
}
