package com.example.spacedaily.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacedaily.data.NASAAPIInterface
import com.example.spacedaily.data.PhotoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class MainViewModel : ViewModel(), KoinComponent {
    private val nasaAPIInterface: NASAAPIInterface by inject()

    private val _dailyPhotos = MutableStateFlow(
        PhotoResponse(
            date = "",
            explanation = "",
            hdurl = "",
            mediaType = "",
            serviceVersion = "",
            title = "",
            url = ""
        )
    )
    val dailyPhotos = _dailyPhotos.asStateFlow()

    init {
        getDailyPhoto()
    }


    private fun getDailyPhoto() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = nasaAPIInterface.getDailyPhoto()
            _dailyPhotos.emit(response)

        } catch (e: Exception) { }
    }
}

private val fakePhoto = PhotoResponse(
    date = "",
    explanation = "",
    hdurl = "",
    mediaType = "",
    serviceVersion = "",
    title = "",
    url = ""
)