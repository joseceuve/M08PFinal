package cat.copernic.pfinal.jose.m08pfinal.overview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cat.copernic.pfinal.jose.m08pfinal.databinding.FragmentVistasBinding
import cat.copernic.pfinal.jose.m08pfinal.network.CourseProperty


class AdaptadorFotoGrid(private val onClickListener: OnClickListener): ListAdapter<CourseProperty, AdaptadorFotoGrid.CursePropertyViewHolder>(DiffCallback) {


    class CursePropertyViewHolder(private var binding: FragmentVistasBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: CourseProperty) {
           // binding.property = marsProperty creo que es la propiedad GONE O VISIBLE
            Log.e("Jose","CurseProperty")
            binding.executePendingBindings()
        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<CourseProperty>() {
        override fun areItemsTheSame(oldItem: CourseProperty, newItem: CourseProperty): Boolean {
            Log.e("Jose","Old Item")
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CourseProperty, newItem: CourseProperty): Boolean {
            Log.e("Jose","areContents")
            return oldItem.numSemi == newItem.numSemi
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CursePropertyViewHolder {
        Log.e("Jose","onCreate")
        return CursePropertyViewHolder(FragmentVistasBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: CursePropertyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(marsProperty)
        }
        Log.e("Jose","onBinding")
        holder.bind(marsProperty)
    }

    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [MarsProperty]
     * associated with the current item to the [onClick] function.
     * @param clickListener lambda that will be called with the current [MarsProperty]
     */
    class OnClickListener(val clickListener: (marsProperty:CourseProperty) -> Unit) {
        fun onClick(marsProperty:CourseProperty) = clickListener(marsProperty)
    }
}