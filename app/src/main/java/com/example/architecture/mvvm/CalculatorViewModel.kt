package com.example.architecture.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var isError by mutableStateOf(false)
    var result by mutableStateOf("result")

    private var textA = ""
    private var textB = ""

    fun handleEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.SumClicked -> handleSumClicked()
            is CalculatorEvent.ClearSumResult -> handleClearSumText()
            is CalculatorEvent.UpdateTextA -> handleUpdateTextA(event.newText)
            is CalculatorEvent.UpdateTextB -> handleUpdateTextB(event.newText)
        }
    }

    private fun handleUpdateTextA(newNumber: String) {
        textA = newNumber
    }

    private fun handleUpdateTextB(newNumber: String) {
        textB = newNumber
    }

    private fun handleClearSumText() {
        result = ""
    }

    private fun handleSumClicked() {
        if (textA.isEmpty() || textB.isEmpty()) {
            isError = true
            return
        }

        isError = false
        result = "${SumProvider().getSum(textA.toInt(), textB.toInt())}"
    }
}