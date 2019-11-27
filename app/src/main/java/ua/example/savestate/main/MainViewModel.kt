package ua.example.savestate.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val state: SavedStateHandle) : ViewModel() {

    companion object {
        private const val INFO_STATE = "info_state"
    }


    fun getInfo(): LiveData<State> = state.getLiveData(INFO_STATE, State.DEFAULT)

    fun saveInfoData(infoState: State) {
        state.set(INFO_STATE, infoState)
    }
}


enum class State {
    DEFAULT, OLD_BUTTON, NEW_BUTTON
}