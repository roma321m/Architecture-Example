package com.example.architecture.render_mvp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.architecture.R
import com.example.architecture.mvp.SumProvider

class MvpActivity : AppCompatActivity(), IView {

    private var numA: EditText? = null
    private var numB: EditText? = null

    private var txtResult: TextView? = null

    private lateinit var presenter: IPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        numA = findViewById(R.id.editTextNumberA)
        numB = findViewById(R.id.editTextNumberB)

        txtResult = findViewById(R.id.txtResult)

        findViewById<Button>(R.id.buttonSum).setOnClickListener {
            val a = numA?.text?.toString()
            val b = numB?.text?.toString()

            presenter.sumClicked(a, b)
        }

        presenter = Presenter(this, SumProvider())
    }

    override fun render(viewState: ViewState) {
        if (viewState.error) {
            txtResult?.text = getString(R.string.input_error)
            txtResult?.setTextColor(Color.RED)
        } else if (viewState.result != null) {
            txtResult?.text = "${viewState.result}"
            txtResult?.setTextColor(Color.GREEN)
        }
    }
}