package ua.example.savestate.oldApproach

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import ua.example.savestate.base.BaseChuckFragment

class OldFragment : BaseChuckFragment() {

    companion object {
        private const val BUNDLE_STR_DATA = "bundle_str_data"
    }

    private val viewModel by viewModels<OldViewModel>()
    private var selectedId = -1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //set click listeners
        buttonChuck1.setOnClickListener {
            viewModel.requestDummyData(0)
            selectedId = 0
        }
        buttonChuck2.setOnClickListener {
            viewModel.requestDummyData(1)
            selectedId = 1
        }
        buttonChuck3.setOnClickListener {
            viewModel.requestDummyData(2)
            selectedId = 2
        }
        viewModel.liveData.observe(viewLifecycleOwner, liveDataObserver)
        savedInstanceState?.let { bundle ->
            bundle.getInt(BUNDLE_STR_DATA).let {
                if (it != -1) {
                    viewModel.requestDummyData(it)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(BUNDLE_STR_DATA, selectedId)
    }

}
