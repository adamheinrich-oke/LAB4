package com.example.l3

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var textView: TextView
    private lateinit var buttonToast: Button
    private lateinit var buttonToast2: Button
    private lateinit var spinner: Spinner
    private lateinit var adapter: ArrayAdapter<CharSequence>
    private lateinit var container: RelativeLayout
    private lateinit var editText: EditText
    private lateinit var textviewDice: TextView
    private lateinit var diceButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView1)
        buttonToast = findViewById(R.id.button_toast_RR)
        buttonToast.setOnClickListener { displayToast() }
        spinner = findViewById(R.id.spinner1)
        container = findViewById(R.id.container)
        editText = findViewById(R.id.input)
        buttonToast2 = findViewById(R.id.button2)
        diceButton = findViewById(R.id.button3)
        textviewDice = findViewById(R.id.textView3)

        buttonToast2.setOnClickListener { displayInput() }
        diceButton.setOnClickListener { Dice() }
        adapter = ArrayAdapter.createFromResource(
            this,
            R.array.options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

    }

    private fun Dice() {
        val value = (1..6).random()
        textviewDice.text = value.toString()
    }


    private fun displayToast() =
        Toast.makeText(applicationContext, "Hello Kotlin", Toast.LENGTH_LONG).show()

    private fun displayInput() {
        val text: String = editText.text.toString().trim()
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }

    override fun onItemSelected(
        adapterView: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {

        if (adapterView?.getItemAtPosition(position) == "Choose option:") {
            //

        } else {
            when (adapterView?.getItemAtPosition(position).toString()) {
                "Size" -> textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36F)
                "Get Default" -> textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}