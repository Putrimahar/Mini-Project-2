package com.putrimaharani0087.miniproject2.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrimaharani0087.miniproject2.database.TaskDao
import com.putrimaharani0087.miniproject2.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val dao: TaskDao) : ViewModel() {

    fun insert(judul: String, deskripsi: String, deadline: String) {
        val task = Task(
            judul = judul,
            deskripsi = deskripsi,
            deadline = deadline
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(task)
        }
    }

    fun getTask(id: Long): Task? {
        return null
    }
}