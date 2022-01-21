package ua.example.savestate.newApproach

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import ua.example.savestate.base.BaseChuckFragment
import ua.example.savestate.base.DummyDataProvider

class NewFragment : BaseChuckFragment() {


    private val viewModel by viewModels<NewViewModel> {
        NewViewModelStateFactory(DummyDataProvider(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //set click listeners
        buttonChuck1.setOnClickListener {
            viewModel.requestDummyData(0)
        }
        buttonChuck2.setOnClickListener {
            viewModel.requestDummyData(1)
        }
        buttonChuck3.setOnClickListener {
            viewModel.requestDummyData(2)
        }
        viewModel.liveData.observe(viewLifecycleOwner, liveDataObserver)
    }
}
