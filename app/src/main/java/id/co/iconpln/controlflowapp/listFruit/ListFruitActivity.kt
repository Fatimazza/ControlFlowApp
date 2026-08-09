package id.co.iconpln.controlflowapp.listFruit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.databinding.ActivityListHeroBinding
import id.co.iconpln.controlflowapp.model.FruitRepository

class ListFruitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = FruitRepository()
        val fruitList = repository.getFruits()

        binding.rvListHero.layoutManager = LinearLayoutManager(this)
        binding.rvListHero.adapter = ListFruitAdapter(fruitList)
    }
}
