package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.ButtonBarLayout
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var  result : TextView
    lateinit var  exp : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val one     = findViewById<Button>(R.id.btn_one)
        val two     = findViewById<Button>(R.id.btn_two)
        val three   = findViewById<Button>(R.id.btn_three)
        val four    = findViewById<Button>(R.id.btn_four)
        val five    = findViewById<Button>(R.id.btn_five)
        val six     = findViewById<Button>(R.id.btn_six)
        val seven   = findViewById<Button>(R.id.btn_seven)
        val eight   = findViewById<Button>(R.id.btn_eight)
        val nine    = findViewById<Button>(R.id.btn_nine)

        val zero    = findViewById<Button>(R.id.btn_zero)
        val dot     = findViewById<Button>(R.id.btn_dot)
        val back    = findViewById<ImageButton>(R.id.btn_back)
        val equal   = findViewById<Button>(R.id.btn_equal)
        val br_st   = findViewById<Button>(R.id.btnbrst)
        val br_end  = findViewById<Button>(R.id.btnbrend)
        val clear   = findViewById<Button>(R.id.btn_c)

        val plus    = findViewById<Button>(R.id.btn_plus)
        val minus   = findViewById<Button>(R.id.btn_minus)
        val multiply= findViewById<Button>(R.id.btn_multiply)
        val devide  = findViewById<Button>(R.id.btn_devide)

        exp     = findViewById<TextView>(R.id.tv_exp)
        result  = findViewById<TextView>(R.id.tv_result)

        one.setOnClickListener { appendOnExpression("1",true) }
        two.setOnClickListener { appendOnExpression("2",true) }
        three.setOnClickListener { appendOnExpression("3",true) }
        four.setOnClickListener { appendOnExpression("4",true) }
        five.setOnClickListener { appendOnExpression("5",true) }
        six.setOnClickListener { appendOnExpression("6",true) }
        seven.setOnClickListener { appendOnExpression("7",true) }
        eight.setOnClickListener { appendOnExpression("8",true) }
        nine.setOnClickListener { appendOnExpression("9",true) }
        zero.setOnClickListener { appendOnExpression("0",true) }
        dot.setOnClickListener { appendOnExpression(".",true) }


        plus.setOnClickListener { appendOnExpression("+",false) }
        minus.setOnClickListener { appendOnExpression("-",false) }
        multiply.setOnClickListener { appendOnExpression("*",false) }
        devide.setOnClickListener { appendOnExpression("/",false) }
        br_st.setOnClickListener { appendOnExpression("(",false) }
        br_end.setOnClickListener { appendOnExpression(")",false) }

        clear.setOnClickListener {
            exp.text = ""
            result.text = ""
        }

        back.setOnClickListener {
            val string = exp.text.toString()
            if (string.isNotEmpty())
            {
                exp.text = string.substring(0,string.length-1)
            }
            result.text =""
        }

        equal.setOnClickListener {
            try {
                val expr = ExpressionBuilder(exp.text.toString()).build()
                val resultt = expr.evaluate()
                val longResult = resultt.toLong()
                if (resultt == longResult.toDouble())
                {
                    result.text = longResult.toString()
                }
                else{
                    result.text = longResult.toString()
                }
            }catch (e:java.lang.Exception)
            {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }





    }

    fun appendOnExpression(string: String,calClear:Boolean)
    {
        if (result.text.isNotEmpty())
        {
            exp.text = ""
        }
        if (calClear)
        {
            result.text = ""
            exp.append(string)
        }else
        {
            exp.append(result.text)
            exp.append(string)
            result.text = ""
        }
    }


}