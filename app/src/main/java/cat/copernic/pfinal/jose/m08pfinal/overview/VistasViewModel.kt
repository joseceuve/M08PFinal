package cat.copernic.pfinal.jose.m08pfinal.overview
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.copernic.pfinal.jose.m08pfinal.network.CourseApi
import cat.copernic.pfinal.jose.m08pfinal.network.CourseApiFilter
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

     init {
        getCourseRealEstateProperties(CourseApiFilter.SHOW_ALL)
    }

    private fun getCourseRealEstateProperties(filter: CourseApiFilter) {
        viewModelScope.launch {
            Log.e("Jose","getCourseRealEstateProperties")
            _status.value = CourseApiSatatus.LOADING
            try {
                Log.e("Jose","Try")
                _properties.value = CourseApi.retrofitService.getProperties(filter.value)
                _status.value = CourseApiSatatus.DONE
            }catch (e: Exception){
                Log.e("Jose","Catch")
                _status.value = CourseApiSatatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }
    fun updateFilter(filter: CourseApiFilter){
        getCourseRealEstateProperties(filter)
    }

    fun diplayPropertyDetails(couseProperty: CourseProperty){
        Log.e("Jose","displayPropertyDetails")
        _navigateToSelectedProperty.value = couseProperty
    }

    fun displayPropertyDetailComplete(){
        Log.e("Jose","displayPropertyDetailComplete")
        _navigateToSelectedProperty.value = null
    }

}