package com.example.CalcMaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inputtextview: TextView
    private lateinit var outputtextview : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fullclearbutton: Button = findViewById(R.id.fullclear)
        val deletebutton: Button = findViewById(R.id.delete)
        val dividebutton: Button = findViewById(R.id.divide)
        val button1button: Button = findViewById(R.id.button1)
        val button2button: Button = findViewById(R.id.button2)
        val button3button: Button = findViewById(R.id.button3)
        val button4button: Button = findViewById(R.id.button4)
        val button5button: Button = findViewById(R.id.button5)
        val button6button: Button = findViewById(R.id.button6)
        val button7button: Button = findViewById(R.id.button7)
        val button8button: Button = findViewById(R.id.button8)
        val button9button: Button = findViewById(R.id.button9)
        val multiplebutton : Button = findViewById(R.id.multiple)
        val minusbutton: Button = findViewById(R.id.minus)
        val plusbutton: Button = findViewById(R.id.plus)
        val dotbutton: Button = findViewById(R.id.dot)
        val equaltobutton: Button = findViewById(R.id.equalto)
        inputtextview = findViewById(R.id.input)
        outputtextview = findViewById(R.id.output)


        button1button.setOnClickListener {
            inputtextview.text = addToInputText("1")
        }

        button2button.setOnClickListener {
            inputtextview.text = addToInputText("2")
        }

        button3button.setOnClickListener {
            inputtextview.text = addToInputText(("3"))
        }

        button4button.setOnClickListener {
            inputtextview.text = addToInputText("4")
        }

        button5button.setOnClickListener {
            inputtextview.text = addToInputText("5")
        }

        button6button.setOnClickListener {
            inputtextview.text = addToInputText("6")
        }

        button7button.setOnClickListener {
            inputtextview.text = addToInputText("7")
        }

        button8button.setOnClickListener {
            inputtextview.text = addToInputText("8")
        }

        button9button.setOnClickListener {
            inputtextview.text = addToInputText("9")
        }

        fullclearbutton.setOnClickListener {
            inputtextview.text = ""
            outputtextview.text = ""
        }

        dividebutton.setOnClickListener {
            inputtextview.text = addToInputText("/")
        }

        minusbutton.setOnClickListener {
            inputtextview.text = addToInputText("-")
        }

        multiplebutton.setOnClickListener {
            inputtextview.text = addToInputText("*")
        }

        plusbutton.setOnClickListener {
            inputtextview.text = addToInputText("+")
        }

        dotbutton.setOnClickListener {
            inputtextview.text = addToInputText(".")
        }

        equaltobutton.setOnClickListener {
            showResult()

        }


        deletebutton.setOnClickListener {
            val removedLast = inputtextview.text.toString().dropLast(1)
            inputtextview.text = removedLast
        }




    }

    private fun getInputExpression(): String {
        return inputtextview.text.toString()
    }


    private fun addToInputText(buttonValue: String): String {
        return inputtextview.text.toString() + buttonValue
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                outputtextview.text = ""
                outputtextview.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                outputtextview.text = DecimalFormat("0.######").format(result).toString()
                outputtextview.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Log the exception
            e.printStackTrace()

            // Show Error Message
            outputtextview.text = "Error"
            outputtextview.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }



}

