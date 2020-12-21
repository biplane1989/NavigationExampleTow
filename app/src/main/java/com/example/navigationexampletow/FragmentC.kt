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
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels

class FragmentC : Fragment() {

    val TAG = "TAG"
    private  val nestedViewModel: NestedViewModel by navGraphViewModels(R.id.nav_nested)
    private val exampleObserver = Observer<Int> {
        Log.d(TAG, "count C: " + it)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        nestedViewModel.getLivedata().observe(viewLifecycleOwner, exampleObserver)
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnA = view.findViewById<Button>(R.id.btn_a)
        val btnMain = view.findViewById<Button>(R.id.btn_main)
        val btnChild = view.findViewById<Button>(R.id.btn_child)

        btnA.setOnClickListener(View.OnClickListener {
            val action = FragmentCDirections.actionCToA()
            findNavController().navigate(action)
        })

        btnMain.setOnClickListener(View.OnClickListener {
            val action = FragmentCDirections.actionToMain()
            findNavController().navigate(action)
        })

        btnChild.setOnClickListener(View.OnClickListener {
            val action = FragmentCDirections.actionToChild()
            findNavController().navigate(action)
        })
    }
}