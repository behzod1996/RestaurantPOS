package uz.behzoddev.restaurantpos.view.menu_add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.behzoddev.restaurantpos.common.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentAddMenuBinding

class MenuAddFragment : BaseFragment<FragmentAddMenuBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddMenuBinding {
        return FragmentAddMenuBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}