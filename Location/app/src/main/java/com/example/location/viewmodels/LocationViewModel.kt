package com.example.location.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.location.models.LocationLiveData

class LocationViewModel(context: Context): ViewModel() {
    private val locationLiveData = LocationLiveData(context)

    fun getLocationLiveData() = locationLiveData
 }