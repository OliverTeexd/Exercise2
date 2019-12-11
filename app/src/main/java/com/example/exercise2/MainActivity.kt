package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener{cal()}
        buttonReset.setOnClickListener{reset()}
    }
    private fun cal(){
        Toast.makeText(this, "BMI calculated",
            Toast.LENGTH_SHORT).show()

        var weight = editTextWeight.text.toString().toDouble()
        var height = editTextHeight.text.toString().toDouble()

        val bmi1 = (height /100)  * (height / 100)
        val bmi2 = weight / bmi1
        val bmi:Double = String.format("%.2f",bmi2).toDouble()

        if(bmi < 18.5){
            imageViewProfile.setImageResource(R.drawable.under)
            textViewBMI.setText("BMI: "+bmi+"(Underweight)")
        }
        else if(bmi >=18.5 && bmi<=24.9){
            imageViewProfile.setImageResource(R.drawable.normal)
            textViewBMI.setText("BMI: "+bmi+"(Normal)")
        }
        else if(bmi >= 25){
            imageViewProfile.setImageResource(R.drawable.over)
            textViewBMI.setText("BMI: "+bmi+"(Overweight)")
        }
    }
    private fun reset(){
        editTextWeight.setText(null)
        editTextHeight.setText(null)
        textViewBMI.setText(null)
        imageViewProfile.setImageResource(R.drawable.empty)
    }
}
