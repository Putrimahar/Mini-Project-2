package com.putrimaharani0087.miniproject2.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrimaharani0087.miniproject2.database.TaskDao
import com.putrimaharani0087.miniproject2.model.Task
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: TaskDao) : ViewModel() {

    val data: StateFlow<List<Task>> = dao.getTask().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )
}