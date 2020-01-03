package com.example.labexercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDOB.setOnClickListener{
            getSaving(it)
        }


    }

    private fun getSaving(view:View){
        var bSaving = 0
        var investment:Double
        var calender = Calendar.getInstance()

        val cYear = calender.get(Calendar.YEAR)
        val cMonth = calender.get(Calendar.MONTH)
        val cDay = calender.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
            txtDOB.setText(day.toString() + "-" + month.toString() + "-" + year.toString())
            val calAge = cYear- year
            when(calAge){

                in 16..20 -> bSaving = 5000
                in 21..25 -> bSaving = 14000
                in 26..30 -> bSaving = 29000
                in 31..35 -> bSaving = 50000
                in 36..40 -> bSaving = 78000
                in 41..45 -> bSaving = 116000
                in 46..50 -> bSaving = 165000
                in 51..55 -> bSaving = 228000
                else -> bSaving = 0

            }

            bSaving.toDouble()
            investment = bSaving * 0.30
            age.setText(calAge.toString())
            salary.setText("RM"+bSaving.toString())
            allowance.setText("RM"+investment.toString())
        }, cYear, cMonth, cDay)
        dpd.show()


        }
}
