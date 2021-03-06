package uz.behzoddev.restaurantpos.view.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.common.extensions.showToastLong
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.data.local.models.FoodOrderItem
import uz.behzoddev.restaurantpos.databinding.FragmentColdBrewCoffeeBinding
import uz.behzoddev.restaurantpos.presentation.store.ColdBrewViewModel
import uz.behzoddev.restaurantpos.view.order_store.OrderStoreAdapter


@AndroidEntryPoint
class ColdBrewCoffeeFragment : BaseFragment<FragmentColdBrewCoffeeBinding>() {

    private val coldBrewAdapter = OrderStoreAdapter()
    private val coldBrewViewModel: ColdBrewViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentColdBrewCoffeeBinding {
        return FragmentColdBrewCoffeeBinding.inflate(inflater,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observerColdBrew()
        //onClickColdBrew()
        onClickMenu()
    }

    private fun initRecyclerView() = with(binding) {
        coldBrewRecyclerView.adapter = coldBrewAdapter
        // When you call that function, the size (with and height) of recycler view
        // won’t change on the adapter insert/update/delete
        coldBrewRecyclerView.setHasFixedSize(true)
        coldBrewAdapter.setOnAddClickListener(object : OrderStoreAdapter.FoodItemListener {
            override fun addToMenu(foodItem: FoodItem) {

            }
        })
    }

    /*
    private fun onClickColdBrew() {
        coldBrewAdapter.setDetailClickListener {
            val bundle = Bundle().apply {
                putParcelable("food_item",it)
            }
            findNavController().navigate(R.id.actionMenuFragmentToDetailConfirmFragment,bundle)
        }
    }*/

    private fun onClickMenu() {
        coldBrewAdapter.setOnClickListener {

        }
    }
    private fun observerColdBrew() = lifecycleScope.launchWhenCreated {
        coldBrewViewModel.coldBrewState.collect { result ->
            when(result) {
                is ItemState.Loading -> {

                }
                is ItemState.Empty -> {

                }
                is ItemState.Failure -> {

                }
                is ItemState.Success -> {
                    fetchAllColdBrew(result.data)
                }
            }

        }
    }

    private fun fetchAllColdBrew(list: List<FoodItem>) = coldBrewAdapter.diffUtil.submitList(list)

}