package com.putrimaharani0087.miniproject2.screen

import androidx.lifecycle.ViewModel
import com.putrimaharani0087.miniproject2.model.Task

class MainViewModel : ViewModel() {
    val data = listOf(
        Task(
            1,
            "Mengerjakan TP Mobpro",
            "kerjakan sebelum jam praktikum",
            "2025-05-21 23:59:59"
        ),
        Task(
            2,
            "Mengerjakan TP Mobpro",
            "kerjakan sebelum jam praktikum",
            "2025-05-21 23:59:59"
        ),
        Task(
            3,
            "Mengerjakan TP Mobpro",
            "kerjakan sebelum jam praktikum",
            "2025-05-21 23:59:59"
        ),
        Task(
            4,
            "Mengerjakan TP Mobpro",
            "kerjakan sebelum jam praktikum",
            "2025-05-21 23:59:59"
        ),
        Task(
            5,
            "Mengerjakan TP Mobpro",
            "kerjakan sebelum jam praktikum",
            "2025-05-21 23:59:59"
        ),
        Task(
            6,
            "Mengerjakan TP Mobpro",
            "kerjakan sebelum jam praktikum",
            "2025-05-21 23:59:59"
        ),
        Task(
            7,
            "Mengerjakan TP Mobpro",
            "kerjakan sebelum jam praktikum",
            "2025-05-21 23:59:59"
        ),
    )

    fun getTugas(id: Long): Task? {
        return data.find { it.id == id }
    }
}