package ua.example.savestate.base

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.Observer
import ua.example.savestate.R

open class BaseChuckFragment : BaseFragment(R.layout.fragment_chuck) {

    protected lateinit var buttonChuck1: Button
    protected lateinit var buttonChuck2: Button
    protected lateinit var buttonChuck3: Button
    private lateinit var imageView: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init views
        buttonChuck1 = view.findViewById(R.id.fragment_chuck1)
        buttonChuck2 = view.findViewById(R.id.fragment_chuck2)
        buttonChuck3 = view.findViewById(R.id.fragment_chuck3)
        imageView = view.findViewById(R.id.fragment_image_view)
    }


    protected val liveDataObserver = Observer<String> {
        imageView.load(it)
    }
}