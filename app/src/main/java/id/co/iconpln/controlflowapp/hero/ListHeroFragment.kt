package id.co.iconpln.controlflowapp.hero


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.databinding.FragmentListHeroBinding
import id.co.iconpln.controlflowapp.model.Hero
import id.co.iconpln.controlflowapp.model.HeroesData

/**
 * A simple [Fragment] subclass.
 */
class ListHeroFragment : Fragment() {

    private var _binding: FragmentListHeroBinding? = null
    private val binding get() = _binding!!

    private var listHero: ArrayList<Hero> = arrayListOf()
    private lateinit var listHeroAdapter: ListHeroAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListHeroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListHero()
        showRecyclerViewList()
        setListHeroItemClickListener()
    }

    private fun setupListHero() {
        binding.rvFragmentListHero.setHasFixedSize(true)
        listHero.addAll(HeroesData.listDataHero)
    }

    private fun showRecyclerViewList() {
        binding.rvFragmentListHero.layoutManager = LinearLayoutManager(requireContext())
        listHeroAdapter = ListHeroAdapter(listHero)
        binding.rvFragmentListHero.adapter = listHeroAdapter
    }

    private fun setListHeroItemClickListener() {
        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClick(hero: Hero) {
                Toast.makeText(requireContext(), "You choose ${hero.name}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    // Clean up binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
