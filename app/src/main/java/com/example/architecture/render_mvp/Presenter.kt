package com.example.architecture.render_mvp

import com.example.architecture.mvp.SumProvider

class Presenter(
    private val view: IView,
    private val sumProvider: SumProvider
) : IPresenter {

    private var lastViewState: ViewState? = null

    override fun sumClicked(a: String?, b: String?) {
        if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
            lastViewState = ViewState(error = true, result = null)
            view.render(lastViewState!!)
            return
        }

        val result = sumProvider.getSum(a.toInt(), b.toInt())
        lastViewState = ViewState(error = false, result = result)
        view.render(lastViewState!!)
    }
}