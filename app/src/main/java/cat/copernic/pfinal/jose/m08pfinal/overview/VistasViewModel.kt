package cat.copernic.pfinal.jose.m08pfinal.overview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.copernic.pfinal.jose.m08pfinal.network.CourseApi
import cat.copernic.pfinal.jose.m08pfinal.network.CourseProperty
import kotlinx.coroutines.launch
import java.lang.Exception

enum class CourseApiSatatus {LOADING, ERROR, DONE }





class VistasViewModel: ViewModel() {
    private val _status = MutableLiveData<CourseApiSatatus>()
    val status: LiveData<CourseApiSatatus>
        get() = _status

    private val _properties = MutableLiveData<List<CourseProperty>>()

    val properties: LiveData<List<CourseProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<CourseProperty>()
    val navigateToSelectedProperty: LiveData<CourseProperty>
        get() = _navigateToSelectedProperty

/*    init {
        getCourseRealEstateProperties(CourseApiFilter.SHOW_ALL)
    }

    private fun getCourseRealEstateProperties(filter: CourseApiFilter) {
        viewModelScope.launch {
            _status.value = CourseApiSatatus.LOADING
            try {
                _properties.value = CourseApi.retrofitService.getProperties(filter.value)
                _status.value = CourseApiSatatus.DONE
            }catch (e: Exception){
                _status.value = CourseApiSatatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }
  */
    fun diplayPropertyDetails(couseProperty: CourseProperty){
        _navigateToSelectedProperty.value = couseProperty
    }

    fun displayPropertyDetailComplete(){
        _navigateToSelectedProperty.value = null
    }

}