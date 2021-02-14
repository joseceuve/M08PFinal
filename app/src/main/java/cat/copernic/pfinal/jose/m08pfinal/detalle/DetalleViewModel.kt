package cat.copernic.pfinal.jose.m08pfinal.detalle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cat.copernic.pfinal.jose.m08pfinal.network.CourseProperty

class DetalleViewModel( courseProperty: CourseProperty, app: Application): AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<CourseProperty>()

    val selectedProperty: LiveData<CourseProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = courseProperty
    }


}