package ua.example.savestate.old

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.example.savestate.base.DummyDataProvider

class OldViewModel : ViewModel() {

    private val _liveData: MutableLiveData<String> = MutableLiveData()
    val liveData: LiveData<String> = _liveData

    private val dataProvider = DummyDataProvider()

    fun requestDummyData(someId: Int) {
        _liveData.value = dataProvider.chuckImages[someId]
    }

}
