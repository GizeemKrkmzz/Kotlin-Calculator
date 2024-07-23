package com.example.calculatorr

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorr.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonClear.setOnClickListener{
            clearButtonListener()
        }

        binding.buttonBracket.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "(")
        }
        binding.buttonBracketR.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = ")")
        }
        binding.buttonDivision.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "÷")
        }
        binding.button7.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "7")
        }
        binding.button8.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "8")
        }
        binding.button9.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "9")
        }
        binding.buttonMultiply.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "×")
        }
        binding.button4.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "4")
        }
        binding.button5.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "5")
        }
        binding.button6.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "6")
        }
        binding.buttonSubtraction.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "-")
        }
        binding.button1.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "1")
        }
        binding.button2.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "2")
        }
        binding.button3.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "3")
        }
        binding.buttonAddition.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "+")
        }
        binding.buttonCroxx.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            clearOnText()
        }
        binding.button0.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = "0")
        }
        binding.buttonDot.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            addToInputText(buttonValue = ".")
        }
        binding.buttonEquals.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button clicked!", Toast.LENGTH_SHORT).show()
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String) {
        binding.input.text = binding.input.text.toString() + "" + buttonValue
    }

    private fun getInputExpression(): String {
        var expression = binding.input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    fun clearOnText() {
        binding.output.text = " "
        binding.input.text = " "
    }

    fun sil(sayi: String): String {
        if (sayi.isEmpty()) {
            return "0"
        }

        val sonBasamak = sayi.last()
        if (sonBasamak == '.') {
            return sayi.substring(0, sayi.length - 2)
        } else {
            return if (sayi.length == 1) {
                "0"
            } else {
                sayi.substring(0, sayi.length - 1)
            }
        }
    }


    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                binding.output.text = ""
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                binding.output.text = DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            binding.output.text = ""
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

    fun clearButtonListener() {
        val expression=binding.input.text.toString()
        if(expression.isNotEmpty()){
            binding.input.text=expression.substring(0,expression.length - 1)
        }

    }
}







