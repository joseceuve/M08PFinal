package cat.copernic.pfinal.jose.m08pfinal.detalle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import cat.copernic.pfinal.jose.m08pfinal.databinding.FragmentDetalleBinding

/**
 * Fragmento que muestra el detalle
 */
class Fragment_Detalle : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetalleBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val courseProperty = Fragment_DetalleArgs.fromBundle(arguments!!).selectedProperty
        val viewModelFactory = DetalleViewModelFactory(courseProperty, application)
        /*binding.viewModel =  viewModelProvider(
                this, viewModelFactory).get((DetailViewModel::class.java)
        )*/ //El bind de la dataclas

        return binding.root
    }


}