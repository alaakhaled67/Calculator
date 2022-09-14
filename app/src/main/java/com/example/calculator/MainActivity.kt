package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var value1=""
    var value2=""
    var operator=""
    var result:Double=0.0
    var doubled=true
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    fun clicked(view:View) {
        if (doubled)
            binding.result.text=""
        doubled=false
        when(view)
        {
            binding.bt0->value1+="0"
            binding.bt1->value1+="1"
            binding.bt2->value1+="2"
            binding.bt3->value1+="3"
            binding.bt4->value1+="4"
            binding.bt5->value1+="5"
            binding.bt6->value1+="6"
            binding.bt7->value1+="7"
            binding.bt8->value1+="8"
            binding.bt9->value1+="9"
            binding.dot->value1+="."
            binding.bt->value1="-"+value1
        }
        binding.result.text=value1
    }
    fun setOperator(view: View)
    {
        when (view.id) {
            R.id.mod -> operator = "%"
            R.id.divide -> operator = "/"
            R.id.multi -> operator = "*"
            R.id.minus -> operator = "-"
            R.id.plus -> operator = "+"
        }
        binding.result.text=(value1+operator)
            value2 = value1
            value1=""
        doubled=true
    }
    fun result(view: View)
    {
        when(operator) {
            "+" -> binding.result.text = (value2.toDouble() + value1.toDouble()).toString()
            "-" -> binding.result.text = (value2.toDouble() - value1.toDouble()).toString()
            "*" -> binding.result.text = (value2.toDouble() * value1.toDouble()).toString()
            "/" -> binding.result.text = (value2.toDouble() / value1.toDouble()).toString()
            "%" -> binding.result.text = (value2.toDouble() % value1.toDouble()).toString()
        }
        doubled=true
        value1=binding.result.text.toString()
        value2=""
    }
    fun clear(view: View)
    {
        value1=""
        value2=""
        operator=""
        binding.result.text="0"
        doubled=true
    }
}