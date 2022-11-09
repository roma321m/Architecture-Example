package com.example.architecture.mvvm

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.architecture.R
import com.example.architecture.mvvm.text_field_numbers.TextFieldNumbers

@Composable
fun CalculatorView(viewModel: CalculatorViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFieldNumbers(
            onValueChange = { newNumber->
                viewModel.handleEvent(CalculatorEvent.UpdateTextA(newNumber))
            }
        )

        Spacer(modifier = Modifier.padding(10.dp))

        TextFieldNumbers(
            onValueChange = { newNumber->
                viewModel.handleEvent(CalculatorEvent.UpdateTextB(newNumber))
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {
            viewModel.handleEvent(CalculatorEvent.SumClicked)
        }) {
            Text(text = "Sum")
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {
            viewModel.handleEvent(CalculatorEvent.ClearSumResult)
        }) {
            Text(text = "Clear Sum")
        }

        Spacer(modifier = Modifier.padding(10.dp))

        if (viewModel.isError) {
            Text(text = stringResource(id = R.string.input_error), color = Color.Red)
        } else {
            Text(text = viewModel.result, color = Color.Green)
        }
    }
}