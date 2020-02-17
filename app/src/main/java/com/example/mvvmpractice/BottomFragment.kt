package com.example.mvvmpractice


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_bottom.*

/**
 * A simple [Fragment] subclass.
 */
class BottomFragment : Fragment() {

    private lateinit var rootView: View
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_bottom, container, false)
        mainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getInput().observe(this, Observer {
            if (it.isNotEmpty()) {
                var str = it
                var newString = "I am Rashid " + str
                appendedTextView.setText("Appended Result = " + newString)
            } else {
                appendedTextView.setText("Appended Result = ")
            }
        })

    }


}
