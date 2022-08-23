package ua.example.savestate.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ua.example.savestate.R
import ua.example.savestate.base.BaseFragment


class MainFragment : BaseFragment(R.layout.fragment_main) {

    private lateinit var buttonOld: Button
    private lateinit var buttonNew: Button
    private lateinit var textinfo: TextView

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init views
        buttonOld = view.findViewById(R.id.fragment_main_btn_old)
        buttonNew = view.findViewById(R.id.fragment_main_btn_new)
        textinfo = view.findViewById(R.id.fragment_info_text)
        //init listeners
        buttonOld.setOnClickListener {
            viewModel.saveInfoData(State.OLD_BUTTON)
            getNavigator().openOldApproach()
        }
        buttonNew.setOnClickListener {
            viewModel.saveInfoData(State.NEW_BUTTON)
            getNavigator().openNewApproach()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getInfo().observe(viewLifecycleOwner, infoObserver)
    }

    private val infoObserver = Observer<State> {
        when (it) {
            State.DEFAULT -> R.string.fragment_main_tv_default
            State.OLD_BUTTON -> R.string.fragment_main_tv_old
            State.NEW_BUTTON -> R.string.fragment_main_tv_new
            else -> R.string.fragment_main_tv_error
        }.also { stringRes -> textinfo.setText(stringRes) }
    }
}