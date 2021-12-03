package com.example.l3

import android.content.res.Configuration
import android.os.Bundle
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var textView: TextView
    private lateinit var buttonToast: Button
    private lateinit var spinner: Spinner
    private lateinit var adapter: ArrayAdapter<CharSequence>
    private lateinit var container: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView1)
        buttonToast = findViewById(R.id.button_toast_RR)
        buttonToast.setOnClickListener { displayToast() }
        spinner = findViewById(R.id.spinner1)
        container = findViewById(R.id.container)

        adapter = ArrayAdapter.createFromResource(
            this,
            R.array.options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        val item = menu.findItem(R.id.app_bar_switch) as MenuItem
        item.setActionView(R.layout.switch_item)
        val switchAB = item
            .actionView.findViewById<Switch>(R.id.switchAB)
        switchAB.isChecked = true
        switchAB.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES;
            } else {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO;

            }
        }
        return true
    }


    private fun displayToast() =
        Toast.makeText(applicationContext, "Hello Kotlin", Toast.LENGTH_LONG).show()


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

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()

            setContentView(R.layout.activity_main)
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            setContentView(R.layout.activity_main2)
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()

        }
    }


}