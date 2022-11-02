package com.example.architecture.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.architecture.mvp.SumProvider

class CalculatorViewModel : ViewModel() {

    var isError by mutableStateOf(false)
    var result by mutableStateOf("result")

    var textA by mutableStateOf("")
        private set
    var textB by mutableStateOf("")
        private set

    fun handleEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.SumClicked -> handleSumClicked()
            is CalculatorEvent.ClearSumResult -> handleClearSumText()
            is CalculatorEvent.UpdateTextA -> handleUpdateTextA(event.newText)
            is CalculatorEvent.UpdateTextB -> handleUpdateTextB(event.newText)
        }
    }

    private fun handleUpdateTextA(newText: String) {
        if (checkInput(newText))
            textA = newText
    }

    private fun handleUpdateTextB(newText: String) {
        if (checkInput(newText))
            textB = newText
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

    private fun checkInput(str: String): Boolean {
        if (str.isEmpty())
            return true
        return try {
            str.toInt()
            true
        } catch (e: Exception) {
            false
        }
    }
}