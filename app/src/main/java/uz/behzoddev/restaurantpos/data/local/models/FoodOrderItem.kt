package uz.behzoddev.restaurantpos.data.local.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class FoodOrderItem(
    val item: FoodItem,
    var quantity: Int,
    var note: String,
    var extraCost: Float
): Parcelable {

    fun getAmount() : Float = item.foodItemPrice * quantity + extraCost

}

