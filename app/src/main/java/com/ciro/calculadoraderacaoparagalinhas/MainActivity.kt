package com.ciro.calculadoraderacaoparagalinhas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val totalRacao = findViewById<EditText>(R.id.totalRacaoEDT)
        val resultado = findViewById<TextView>(R.id.quantidadesTXT)

        //Ração para aves de crescimento ( 31 a 60 dias)
        val listaDeIgredientes = listOf<Ingrediente>(
            Ingrediente("Milho Moido (kg): ",0.550F),
            Ingrediente("Farelo de Soja (kg): ",0.340F),
            Ingrediente("Farelo de Trigo (kg): ",0.070F),
            Ingrediente("Óleo de Soja (ml): ",0.0160F),
            Ingrediente("Calcário Calcítrico (kg): ",0.010F),
            Ingrediente("Fosfato Bicálcico (kg): ",0.010F),
            Ingrediente("Sal Comum (kg): ",0.0030F),
            Ingrediente("Premix Vitamínico e Mineral (kg): ",0.0010F),
        )

        totalRacao.doAfterTextChanged {
            if(totalRacao.text.isNotEmpty() ) {
                resultado.setText("Total da ração em (kg): "+totalRacao.text.toString().toFloat()+System.getProperty ("line.separator")+System.getProperty ("line.separator"))
                listaDeIgredientes.forEach{
                    var qtdDoIgrediente: String = ""

                    if( (it.quantidade * totalRacao.text.toString().toFloat()) < 0.1 )
                        qtdDoIgrediente = "%.4f".format(it.quantidade * totalRacao.text.toString().toFloat())
                    else if( (it.quantidade * totalRacao.text.toString().toFloat()) >= 0.1)
                        qtdDoIgrediente = "%.2f".format(it.quantidade * totalRacao.text.toString().toFloat())


                    resultado.setText(resultado.text.toString()+it.nome+qtdDoIgrediente+System.getProperty ("line.separator"))
                }
            }
        }

    }
}