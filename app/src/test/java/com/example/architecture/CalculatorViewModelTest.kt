package com.example.architecture

import com.example.architecture.mvvm.CalculatorEvent
import com.example.architecture.mvvm.CalculatorViewModel
import org.junit.Before
import org.junit.Test

class CalculatorViewModelTest {
    private lateinit var calculatorViewModel: CalculatorViewModel

    @Before
    fun setUp() {
        calculatorViewModel = CalculatorViewModel()
    }

    // CalculatorEvent.UpdateTextA

    @Test
    fun `update text A, when new text is empty, A is empty`() {
        val newA = ""

        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextA(newA))

        assert(calculatorViewModel.textA.isEmpty())
    }

    @Test
    fun `update text A, when new text contain non digit chars, A is not changed`() {
        val oldA = calculatorViewModel.textA
        val newA = "not int"

        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextA(newA))

        assert(calculatorViewModel.textA == oldA)
    }

    @Test
    fun `update text A, when new text is decimal, A is not changed`() {
        val oldA = calculatorViewModel.textA
        val newA = "1.1"

        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextA(newA))

        assert(calculatorViewModel.textA == oldA)
    }

    @Test
    fun `update text A, when new text is integer, A is changed to the new text`() {
        val oldA = calculatorViewModel.textA
        val newA = "111"

        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextA(newA))

        assert(calculatorViewModel.textA == newA && calculatorViewModel.textA != oldA)
    }

    // CalculatorEvent.UpdateTextB

    @Test
    fun `update text B, when new text is empty, B is empty`() {
        val newB = ""

        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextB(newB))

        assert(calculatorViewModel.textB.isEmpty())
    }

    @Test
    fun `update text B, when new text contain non digit chars, B is not changed`() {
        val oldB = calculatorViewModel.textB
        val newB = "not int"

        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextB(newB))

        assert(calculatorViewModel.textB == oldB)
    }

    @Test
    fun `update text B, when new text is decimal, B is not changed`() {
        val oldB = calculatorViewModel.textB
        val newB = "1.1"

        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextB(newB))

        assert(calculatorViewModel.textB == oldB)
    }

    @Test
    fun `update text B, when new text is integer, B is changed to the new text`() {
        val oldB = calculatorViewModel.textB
        val newB = "111"

        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextB(newB))

        assert(calculatorViewModel.textB == newB && calculatorViewModel.textB != oldB)
    }

    // CalculatorEvent.ClearSumResult

    @Test
    fun `clear sum result, always, result text changes to empty text`() {


        calculatorViewModel.handleEvent(CalculatorEvent.ClearSumResult)

        assert(calculatorViewModel.result.isEmpty())
    }

    // CalculatorEvent.SumClicked

    @Test
    fun `sum clicked, when a and b are integers, result text changes to the sum`() {
        val a = "10"
        val b = "5"
        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextA(a))
        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextB(b))

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked)

        assert(calculatorViewModel.result == "15")
    }

    @Test
    fun `sum clicked, when a is empty and b is integer, isError true`() {
        val a = ""
        val b = "5"
        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextA(a))
        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextB(b))

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked)

        assert(calculatorViewModel.isError)
    }

    @Test
    fun `sum clicked, when b is empty and a is integer, isError true`() {
        val a = "5"
        val b = ""
        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextA(a))
        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextB(b))

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked)

        assert(calculatorViewModel.isError)
    }

    @Test
    fun `sum clicked, when b and a are empty, isError true`() {
        val a = ""
        val b = ""
        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextA(a))
        calculatorViewModel.handleEvent(CalculatorEvent.UpdateTextB(b))

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked)

        assert(calculatorViewModel.isError)
    }
}