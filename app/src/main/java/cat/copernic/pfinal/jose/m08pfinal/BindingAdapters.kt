package cat.copernic.pfinal.jose.m08pfinal

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import cat.copernic.pfinal.jose.m08pfinal.overview.AdaptadorFotoGrid
import cat.copernic.pfinal.jose.m08pfinal.overview.CourseApiSatatus
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import cat.copernic.pfinal.jose.m08pfinal.network.CourseProperty



/**
 * When there is no Mars property data (data is null), hide the [RecyclerView], otherwise show it.
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CourseProperty>?) {
    val adapter = recyclerView.adapter as AdaptadorFotoGrid
    adapter.submitList(data)
}

/**
 * Uses the Glide library to load an image by URL into an [ImageView]
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    Log.e("Jose","imageUrl")
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.ic_launcher_background) //Imagen de loading
                .error(R.drawable.ic_launcher_background)) //Imagen broken, no encontrada
            .into(imgView)
    }
}

/**
 * This binding adapter displays the [MarsApiStatus] of the network request in an image view.  When
 * the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view.
 */
@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: CourseApiSatatus?) {
    when (status) {

        CourseApiSatatus.LOADING -> {
            Log.e("Jose","Loading")
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_launcher_background) //Animacion de loading en R.drawable....
        }
        CourseApiSatatus.ERROR -> {
            Log.e("Jose","Error")
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_launcher_background) //Imagen Error no cargada
        }
        CourseApiSatatus.DONE -> {
            Log.e("Jose","DONE")
            statusImageView.visibility = View.GONE
        }
    }
}