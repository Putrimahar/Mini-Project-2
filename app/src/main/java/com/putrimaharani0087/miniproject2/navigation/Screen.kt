package com.putrimaharani0087.miniproject2.navigation

import com.putrimaharani0087.miniproject2.screen.KEY_ID_TASK

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_TASK}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}