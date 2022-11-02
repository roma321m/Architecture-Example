package com.example.architecture.render_mvp

data class ViewState(val error: Boolean, val result: Int?)

interface IPresenter {
    fun sumClicked(a: String?, b: String?)
}

interface IView {
    fun render(viewState: ViewState)
}
