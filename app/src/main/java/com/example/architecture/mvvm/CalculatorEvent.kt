package com.example.architecture.mvvm

sealed class CalculatorEvent {
    class UpdateTextA(val newText: String) : CalculatorEvent()
    class UpdateTextB(val newText: String) : CalculatorEvent()
    object SumClicked : CalculatorEvent()
    object ClearSumResult : CalculatorEvent()
}