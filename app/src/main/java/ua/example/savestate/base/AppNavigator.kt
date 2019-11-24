package ua.example.savestate.base

import androidx.navigation.NavController
import ua.example.savestate.R

class AppNavigator(private val controller: NavController) {

    fun openOldApproach() {
        controller.navigate(R.id.action_mainFragment_to_oldFragment)
    }

    fun openNewApproach() {
        controller.navigate(R.id.action_mainFragment_to_newFragment)
    }

    fun popback() {
        controller.popBackStack()
    }
}