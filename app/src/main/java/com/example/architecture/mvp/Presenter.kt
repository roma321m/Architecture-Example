package com.example.architecture.mvp

class Presenter(
    private val view: IView,
    private val sumProvider: SumProvider
) : IPresenter {

    override fun sumClicked(a: String?, b: String?) {
        if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
            view.showInputError()
            return
        }

        val result = sumProvider.getSum(a.toInt(), b.toInt())
        view.showResult(result)
    }
}