package ua.example.savestate.newApproach

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ua.example.savestate.base.DummyDataProvider

class NewViewModel(
    private val state: SavedStateHandle,
    private val dataProvider: DummyDataProvider
) : ViewModel() {

    companion object {
        private const val STATE_ID = "state_id"
    }

    private val _liveData: MutableLiveData<String> = MutableLiveData()
    val liveData: LiveData<String> = _liveData

    init {
        if (state.contains(STATE_ID)) {
            _liveData.value = dataProvider.chuckImages[state.get<Int>(STATE_ID)!!]
        }
    }

    fun requestDummyData(someId: Int) {
        state[STATE_ID] = someId
        _liveData.value = dataProvider.chuckImages[someId]
    }

}
