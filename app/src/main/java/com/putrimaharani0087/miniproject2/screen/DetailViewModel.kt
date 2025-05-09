package com.putrimaharani0087.miniproject2.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrimaharani0087.miniproject2.database.TaskDao
import com.putrimaharani0087.miniproject2.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DetailViewModel(private val dao: TaskDao) : ViewModel() {

    // Fungsi untuk menambahkan task
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

    // Fungsi untuk mendapatkan task berdasarkan ID
    suspend fun getTask(id: Long): Task? {
        return dao.getTaskById(id)
    }

    // Fungsi untuk memperbarui task
    fun update(id: Long, judul: String, deskripsi: String, deadline: String) {
        val task = Task(
            id = id,
            judul = judul,
            deskripsi = deskripsi,
            deadline = deadline
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(task)
        }
    }

    // Fungsi untuk menghapus task berdasarkan ID
    fun deleteById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }

    // Fungsi untuk soft delete (hapus sementara)
    fun softDelete(task: Task) = viewModelScope.launch {
        dao.update(task.copy(isDeleted = true))
    }

    // Fungsi untuk mengembalikan task yang terhapus
    fun restore(task: Task) = viewModelScope.launch {
        val restoredTask = task.copy(isDeleted = false)
        dao.update(restoredTask) // Memulihkan tugas yang terhapus
    }

    // Mendapatkan daftar task yang terhapus
    val deletedTasks: StateFlow<List<Task>> = dao.getDeletedTasks()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

}
