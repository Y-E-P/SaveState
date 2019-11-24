package ua.example.savestate.newApproach

import android.os.Bundle
import android.view.View
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import ua.example.savestate.base.BaseChuckFragment

class NewFragment : BaseChuckFragment() {


    private lateinit var viewModel: NewViewModel

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
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = SavedStateViewModelFactory(requireActivity().application, this).let {
            ViewModelProvider(this, it).get(NewViewModel::class.java)
        }
        viewModel.liveData.observe(viewLifecycleOwner, liveDataObserver)
    }

}
