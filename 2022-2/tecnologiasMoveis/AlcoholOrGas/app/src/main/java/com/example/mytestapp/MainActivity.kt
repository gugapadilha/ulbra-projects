package com.example.mytestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button_calculate)
        val input1 = findViewById<EditText>(R.id.input1)
        val input2 = findViewById<EditText>(R.id.input2)
        val output = findViewById<TextView>(R.id.output_text)


        button.setOnClickListener(){
            output.text = "You clicked the button :)"

            val input1_value = input1.text.toString().toDouble()
            val input2_value = input2.text.toString().toDouble()

            if ((input1_value / input2_value) < 0.7) {
                output.text = "Please use Alcohol"
            } else {
                output.text = "Please use Gas"
            }


        }

    }
}