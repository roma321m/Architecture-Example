package com.example.architecture.mvvm.text_field_numbers

class InputValidator {

    fun updateText(currentText: String, newText: String): String {
        return if (checkInput(newText)) newText else currentText
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