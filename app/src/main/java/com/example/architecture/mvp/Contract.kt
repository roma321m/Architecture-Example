package com.example.architecture.mvp


interface IPresenter {
    fun sumClicked(a: String?, b: String?)
}

interface IView {
    fun showResult(result: Int)
    fun showInputError()
}
