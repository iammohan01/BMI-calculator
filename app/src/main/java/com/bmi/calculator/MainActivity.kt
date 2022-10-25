package com.bmi.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var weight =findViewById<TextView>(R.id.et_weight)
        var height =findViewById<TextView>(R.id.et_height)
        var calcBT = findViewById<Button>(R.id.bt_calculate)


        calcBT.setOnClickListener {

            var weigh = weight.text.toString()
            var heigh = height.text.toString()

            Log.i("MyTag",weigh)
            Log.i("MyTag",heigh)


            if (weigh.isNullOrEmpty() && heigh.isNullOrEmpty()){
                Toast.makeText(this,"Enter Weight and Height",Toast.LENGTH_SHORT).show()
            }
            else if ( weigh.isNullOrEmpty()){
                Toast.makeText(this,"Enter Weight",Toast.LENGTH_SHORT).show()
            }
            else if ( heigh.isNullOrEmpty()){
                Toast.makeText(this,"Enter Height",Toast.LENGTH_SHORT).show()
            }
            else{
                calculateBMI(weigh.toFloat(),heigh.toFloat())
            }
        }
    }
    private fun calculateBMI(weight:Float,height:Float){
        var tv_bmi = findViewById<TextView>(R.id.tv_bmi_value)
        var bmi = weight/((height/100)*(height/100))

        tv_bmi.text = String.format("%.2f", bmi)

    }
}