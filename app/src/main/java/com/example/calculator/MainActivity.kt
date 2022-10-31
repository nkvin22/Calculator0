package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity(){

    private lateinit var resultTextView: TextView
    private var operand = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {

            var text = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (text == "0") {
                text = ""
            }

            var result = text

            if (!(text.contains(".")) || (number != ".")) {
                result += number
            }

            resultTextView.text = result

        }

    }


    fun operationClick(clickedView: View) {

        if (clickedView is TextView) {

            if(resultTextView.text!=""){
                operand = resultTextView.text.toString().toDouble()
                operation = clickedView.text.toString()
                resultTextView.text = ""
            }

        }

    }

    fun equalsClick(clickedView: View){

        val secondOperand = resultTextView.text.toString().toDouble()

        when (operation){
            "+" -> resultTextView.text = (operand + secondOperand).toString()
            "-" -> resultTextView.text = (operand - secondOperand).toString()
            "*" -> resultTextView.text = (operand * secondOperand).toString()
            "/" -> resultTextView.text = (operand / secondOperand).toString()
        }

        if (resultTextView.text.toString().endsWith(".0")){
            resultTextView.text=resultTextView.text.toString().dropLast(2)
        }
    }


    fun clearClick(clickedView: View){
        operand=0.0
        resultTextView.text = ""

    }

    fun delClick(clickedView: View){

        val length = resultTextView.length()

        if (length > 0)
            resultTextView.text = resultTextView.text.subSequence(0, length - 1)
    }


}