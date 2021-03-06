package uz.behzoddev.restaurantpos.view.menu_settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentMenuSettingBinding

@AndroidEntryPoint
class MenuSettingsFragment : BaseFragment<FragmentMenuSettingBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuSettingBinding {
        return FragmentMenuSettingBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onNavigateMenuManagement()
    }

    private fun onNavigateMenuManagement() = with(binding) {
        btnMenuManagement.setOnClickListener {
            findNavController().navigate(R.id.actionMenuSettingsFragmentToMenuManagementFragment)
        }
    }
}