package cat.copernic.pfinal.jose.m08pfinal.overview

import android.os.Bundle
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
    private val viewModel: VistasViewModel by Lazy{
        ViewModelProvider(this).get(VistasViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__vistas, container, false)
    }

}