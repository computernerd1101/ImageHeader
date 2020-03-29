package com.computernerd1101.imageheader.ui.main

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _floatingActionClicked = MutableLiveData<Boolean>()
    val floatingActionClicked: LiveData<Boolean>
        get() = _floatingActionClicked

    fun floatingActionDone() {
        _floatingActionClicked.value = false
    }

    fun onFloatingAction() {
        uiScope.launch {
            _floatingActionClicked.value = true
        }
    }

}
