package ua.example.savestate.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val state: SavedStateHandle) : ViewModel() {

    companion object {
        private const val INFO_STATE = "info_state"
        private const val TAG = "MainViewModel"
    }

    init {
        Log.d(TAG, "Created")
    }

    fun getInfo(): LiveData<State> = state.getLiveData(INFO_STATE, State.DEFAULT)

    fun saveInfoData(infoState: State) {
        state.set(INFO_STATE, infoState)
    }
}


enum class State {
    DEFAULT, OLD_BUTTON, NEW_BUTTON
}