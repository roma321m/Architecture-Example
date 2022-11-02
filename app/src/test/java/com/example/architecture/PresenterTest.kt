package com.example.architecture

import com.example.architecture.mvp.IView
import com.example.architecture.mvp.Presenter
import com.example.architecture.mvp.SumProvider
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class PresenterTest {

    private val view: IView = mockk(relaxUnitFun = true)
    private val sumProvider: SumProvider = mockk(relaxed = true)

    private lateinit var presenter: Presenter

    @Before
    fun setUp() {
        presenter = Presenter(view, sumProvider)
    }

    @Test
    fun `sumClicked, when A is null, show error`() {
        val a = null
        val b = "5"

        presenter.sumClicked(a, b)

        verify {
          view.showInputError()
        }
    }

    @Test
    fun `sumClicked, when A is empty, show error`() {
        val a = ""
        val b = "5"

        presenter.sumClicked(a, b)

        verify {
            view.showInputError()
        }
    }

    @Test
    fun `sumClicked, when B is null, show error`() {
        val a = "1"
        val b = null

        presenter.sumClicked(a, b)

        verify {
            view.showInputError()
        }
    }

    @Test
    fun `sumClicked, when B is empty, show error`() {
        val a = "1"
        val b = ""

        presenter.sumClicked(a, b)

        verify {
            view.showInputError()
        }
    }

    @Test
    fun `sumClicked, when A and B are numbers, don't show error`() {
        val a = "4"
        val b = "5"

        presenter.sumClicked(a, b)

        verify(exactly = 0) {
            view.showInputError()
        }
    }

    @Test
    fun `sumClicked, when A and B are numbers, show valid answer`() {
        val a = "1"
        val b = "5"
        val expectedResult = 900
        every { sumProvider.getSum(any(), any()) }.answers { expectedResult }

        presenter.sumClicked(a, b)

        verify {
            view.showResult(expectedResult)
        }
    }
}