package ua.example.savestate.old

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ua.example.savestate.R
import ua.example.savestate.base.BaseChuckFragment
import ua.example.savestate.base.BaseFragment
import ua.example.savestate.base.load

class OldFragment : BaseChuckFragment() {

    companion object {
        private const val BUNDLE_STR_DATA = "bundle_str_data"
    }

    private lateinit var viewModel: OldViewModel
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
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OldViewModel::class.java)
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
