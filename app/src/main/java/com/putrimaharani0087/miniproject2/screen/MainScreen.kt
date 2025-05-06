package com.putrimaharani0087.miniproject2.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.putrimaharani0087.miniproject2.R
import com.putrimaharani0087.miniproject2.model.Task
import com.putrimaharani0087.miniproject2.ui.theme.MiniProject2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFFD6CCC2), // warna biru custom
                    titleContentColor = Color.Black
                )
            )
        }
    ) { innerpadding ->
        ScreenContent(Modifier.padding(innerpadding))
    }
}

@Composable
fun ScreenContent(modifier: Modifier = Modifier) {
    val viewModel: MainViewModel = viewModel()
    val data = viewModel.data

    if (data.isEmpty()) {
        Column(
            modifier = modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.list_kosong),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

    }
    else {
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            items(data) {
                ListItem(task = it)
                HorizontalDivider()
            }
        }
    }
}

@Composable
fun ListItem(task: Task) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = task.judul,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = task.deskripsi,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = task.deadline)
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    MiniProject2Theme {
        MainScreen()
    }
}