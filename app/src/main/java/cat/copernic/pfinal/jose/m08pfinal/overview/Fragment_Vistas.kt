package cat.copernic.pfinal.jose.m08pfinal.overview

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import cat.copernic.pfinal.jose.m08pfinal.R
import cat.copernic.pfinal.jose.m08pfinal.databinding.FragmentVistasBinding
import cat.copernic.pfinal.jose.m08pfinal.network.CourseApiFilter

/**
 * Fragmento de las vistas
 */
class Fragment_Vistas : Fragment() {
    private val viewModel: VistasViewModel by lazy {
        Log.e("Jose","viewModel")
        ViewModelProvider(this).get(VistasViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("Jose","Fragment_Vistas")
        val binding = FragmentVistasBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = AdaptadorFotoGrid(AdaptadorFotoGrid.OnClickListener{
            viewModel.diplayPropertyDetails(it)
        })
        viewModel.navigateToSelectedProperty.observe(this, Observer {
            if (null != it){
                this.findNavController().navigate(Fragment_VistasDirections.actionShowDetail(it))
                viewModel.displayPropertyDetailComplete()
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.updateFilter(
            when(item.itemId){
                R.id.show_rent_menu -> CourseApiFilter.SHOW_RENT
                R.id.show_buy_menu -> CourseApiFilter.SHOW_BUY
                else -> CourseApiFilter.SHOW_ALL
            }
        )
        return true
    }

}