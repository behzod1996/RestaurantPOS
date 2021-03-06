package uz.behzoddev.restaurantpos.view.option_settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentOptionSettingsBinding

@AndroidEntryPoint
class OptionSettingsFragment : BaseFragment<FragmentOptionSettingsBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOptionSettingsBinding {
        return FragmentOptionSettingsBinding.inflate(inflater,container,false)
    }

    private fun onNavigatePinSettings() {

    }
}