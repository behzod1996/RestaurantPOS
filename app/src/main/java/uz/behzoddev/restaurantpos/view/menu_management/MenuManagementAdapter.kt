package uz.behzoddev.restaurantpos.view.menu_management

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.ItemRowMenuBinding
import javax.inject.Inject

class MenuManagementAdapter @Inject constructor() : RecyclerView.Adapter<MenuManagementAdapter.MenuManagementViewHolder>() {


    inner class MenuManagementViewHolder(val binding: ItemRowMenuBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<FoodItem> () {
            override fun areItemsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
                return oldItem.foodItemId == newItem.foodItemId
            }

            override fun areContentsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
                return oldItem.foodItemName == newItem.foodItemName
                        && oldItem.foodItemPrice == newItem.foodItemPrice
                        && oldItem.foodItemCategory == newItem.foodItemCategory
                        && oldItem.foodItemSubCount == newItem.foodItemSubCount

            }
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)

    // https://medium.com/simform-engineering/listadapter-a-recyclerview-adapter-extension-5359d13bd879
    // https://www.raywenderlich.com/21954410-speed-up-your-android-recyclerview-using-diffutil
    // https://www.raywenderlich.com/1560485-android-recyclerview-tutorial-with-kotlin
    // https://www.raywenderlich.com/272-intermediate-recyclerview-tutorial-with-kotlin
    // https://www.raywenderlich.com/29024188-recyclerview-selection-library-tutorial-for-android-adding-new-actions
    // https://github.com/h6ah4i/android-advancedrecyclerview
    // https://developer.android.com/courses/pathways/android-development-with-kotlin-10
    // https://medium.com/@farshidabazari/improve-recyclerview-performance-ede5cec6c5bf
    // https://proandroiddev.com/recyclerview-pro-tips-part-1-8a291594bafc

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuManagementViewHolder {
       val binding = ItemRowMenuBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuManagementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuManagementViewHolder, position: Int) {
        val foodItem = differ.currentList[position]
        holder.binding.apply {
            tvMenuItemName.text = foodItem.foodItemName
            tvMenuItemNumber.text = foodItem.foodItemId.toString()
            tvMenuItemPrice.text = foodItem.foodItemPrice.toString()
            tvMenuItemQuantity.text = foodItem.foodItemSubCount.toString()
            tvMenuItemCategory.text = foodItem.foodItemCategory
        }
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(foodItem) }
        }
    }

    private var onItemClickListener : ((FoodItem) -> Unit)? = null

    fun setOnClickListener(listener: (FoodItem) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }
}