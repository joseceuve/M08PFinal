package cat.copernic.pfinal.jose.m08pfinal.detalle

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import cat.copernic.pfinal.jose.m08pfinal.R

import cat.copernic.pfinal.jose.m08pfinal.databinding.FragmentDetalleBinding

/**
 * Fragmento que muestra el detalle
 */
class Fragment_Detalle : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.e("Jose","Fragment_Detalle")
        val application = requireNotNull(activity).application
        val binding = FragmentDetalleBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val courseProperty = Fragment_DetalleArgs.fromBundle(arguments!!).selectedProperty
        val viewModelFactory = DetalleViewModelFactory(courseProperty, application)
        binding.viewModel = ViewModelProvider(
            this,viewModelFactory).get(DetalleViewModel::class.java)


        return binding.root
    }


}