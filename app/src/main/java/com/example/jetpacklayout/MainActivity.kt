package com.example.jetpacklayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    private val viewModel :MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewModel)
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel) {
    remember { mutableStateListOf("Micheal", "Arun") }
    val newNameState = viewModel.textFieldValue.hasActiveObservers()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingList(
            newNameState.toString()
        ) { newName ->
            viewModel.onTxtChange(newName)
        }
    }
}

@Composable
fun GreetingList(
    textFieldSting: String, textFieldChange: (newName: String) -> Unit
) {
//    for (name in greetingListState) {
//        Greeting(name = name)
//    }

    BasicTextField(
        value = textFieldSting,
        onValueChange = textFieldChange
    )
    Greeting(name = textFieldSting)
    Button(onClick = { }) {
        Text(text = textFieldSting)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", style = MaterialTheme.typography.headlineMedium)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //MainScreen(viewModel)
}