package cat.copernic.pfinal.jose.m08pfinal.network

import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


/**
 * Clase con los valores a recuperar
 */
@Parcelize
data class CourseProperty(
    @Json(name = "numero_seminari")
    val numSemi: String,
    val titol: String,
    @Json(name = "empresa_organitzadora")
    val empOrga: String,
    val logo: String
)