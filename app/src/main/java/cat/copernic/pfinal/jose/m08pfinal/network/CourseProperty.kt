package cat.copernic.pfinal.jose.m08pfinal.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


/**
 * Clase con los valores a recuperar
 */
@Parcelize
data class CourseProperty(
    @Json(name = "numero_seminari")
    val numSemi: String,
    @Json(name = "titol")
    val titol: String,
    @Json(name = "empresa_organitzadora")
    val empOrga: String,
    @Json(name = "logo")
    val logo: String
): Parcelable