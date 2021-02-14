package cat.copernic.pfinal.jose.m08pfinal.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

enum class CourseApiFilter(val value: String) { //No lo necesito
    SHOW_RENT("rent"),
    SHOW_BUY("buy"),
    SHOW_ALL("all") }

private const val BASE_URL = "http://www.xtec.cat/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CourseApiService {
    @GET("~jmendez1/forteco/courses.json")
    suspend fun getProperties(@Query("filter") type: String): List<CourseProperty>
}
object CourseApi{
    val retrofitService: CourseApiService by Lazy { retrofit.create(CourseApiService::class.java)}
}