package com.example.navigationexampletow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavGraphNavigator
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels

class FragmentA : Fragment() {

    val TAG = "TAG"
    private  val nestedViewModel: NestedViewModel by navGraphViewModels(R.id.nav_nested)

    private val exampleObserver = Observer<Int> {
        Log.d(TAG, "count A: " + it)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        nestedViewModel.getLivedata().observe(viewLifecycleOwner, exampleObserver)
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnB = view.findViewById<Button>(R.id.btn_b)

        btnB.setOnClickListener(View.OnClickListener {
            val action = FragmentADirections.actionAToB()
            findNavController().navigate(action)
        })
    }
}