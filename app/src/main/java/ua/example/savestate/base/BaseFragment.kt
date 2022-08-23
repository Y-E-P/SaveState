package ua.example.savestate.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import ua.example.savestate.MainActivity

abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    fun getNavigator(): AppNavigator = (requireActivity() as MainActivity).appNavigator

}