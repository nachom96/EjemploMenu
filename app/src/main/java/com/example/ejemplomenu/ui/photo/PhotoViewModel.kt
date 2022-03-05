package com.example.ejemplomenu.ui.photo

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class PhotoViewModel : ViewModel() {

   private var _isVisible : MutableLiveData<Boolean> = MutableLiveData(true)
    val isVisible: LiveData<Boolean>
    get() = _isVisible

    val lblPhotoVisibility: LiveData<Int> = _isVisible.map {
        if (it) View.VISIBLE else View.INVISIBLE
    }

    fun toggleVisibility(){
        _isVisible.value = _isVisible.value?.not() ?: true
    }
}