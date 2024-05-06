package com.example.combustivelapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import android.widget.EditText;
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val etValorGasolina = findViewById(R.id.etValorGasolina) as EditText;
    private val etValorEtanol = findViewById(R.id.etValorEtanol) as EditText;
    private val etRes = findViewById(R.id.tvRes) as TextView;
    private val btnCalc=findViewById(R.id.button) as Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnCalc.setOnClickListener { calc() }
    }


    fun calc(){
        val gasolina = etValorGasolina.text.toString().toFloatOrNull() ?: 0.0f
        val etanol = etValorEtanol.text.toString().toFloatOrNull() ?: 0.0f
        val etanolcalc= etanol*0.7;
        val vantajoso: Boolean;
        if(etanolcalc<gasolina){
            vantajoso=true;
        }else{
            vantajoso=false;
        }
        setResultado(vantajoso);
    }

    private fun setResultado(vantajoso: Boolean) {
        if (vantajoso) {
            etRes.text = "Vantajoso"
        } else {
            etRes.text = "Não vantajoso"
        }
    }

}