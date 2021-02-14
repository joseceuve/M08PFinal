package cat.copernic.pfinal.jose.m08pfinal.detalle

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cat.copernic.pfinal.jose.m08pfinal.network.CourseProperty
import java.lang.IllegalArgumentException

class DetalleViewModelFactory(
    private val courseProperty: CourseProperty,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetalleViewModel::class.java)) {
            return DetalleViewModel(courseProperty, application) as T
        }
        throw IllegalArgumentException("Clase ViewModel desconocida")
    }
}