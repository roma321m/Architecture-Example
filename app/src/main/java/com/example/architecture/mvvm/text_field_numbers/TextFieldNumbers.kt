package com.example.architecture.mvvm.text_field_numbers

import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun TextFieldNumbers(onValueChange: (String) -> Unit) { // Todo - return Int 

    var text by remember {
        mutableStateOf("")
    }

    TextField(
        value = text,
        onValueChange = { newText ->
            text = InputValidator().updateText(text, newText)
            onValueChange(text)
        }
    )
}

