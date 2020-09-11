package com.mikail.gadslearnerboard.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikail.gadslearnerboard.api.ApiHelper
import com.mikail.gadslearnerboard.R
import com.mikail.gadslearnerboard.api.RetrofitBuilder
import com.mikail.gadslearnerboard.Status
import com.mikail.gadslearnerboard.adapter.HoursAdapter
import com.mikail.gadslearnerboard.model.HoursModel
import com.mikail.gadslearnerboard.model.HoursModelItem
import com.mikail.gadslearnerboard.testItem
import com.mikail.gadslearnerboard.viewmodel.MainViewMOdelFactory
import com.mikail.gadslearnerboard.viewmodel.MainViewModel

class LearningLeadersFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var hourslist: MutableList<HoursModelItem>
    private lateinit var viewModelFactory: MainViewMOdelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModelFactory = MainViewMOdelFactory(
            ApiHelper(
                RetrofitBuilder.apiService
            )
        )
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)

        }
        recyclerView.setHasFixedSize(true)

        viewModel.hours().observe(viewLifecycleOwner, Observer { result ->

            when (result.status) {

                Status.SUCCESS -> {
                  val adapter = result.data?.let { HoursAdapter(it) }
                    recyclerView.adapter = adapter
                }
                Status.ERROR -> {
                    Toast.makeText(activity, result.message, Toast.LENGTH_SHORT).show()


                }
            }

        })


    }


}