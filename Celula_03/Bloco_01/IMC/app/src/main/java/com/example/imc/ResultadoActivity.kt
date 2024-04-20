package com.example.imc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_resultado2.textViewAltura
import kotlinx.android.synthetic.main.activity_resultado2.textViewHeaderDensidadeCorporal
import kotlinx.android.synthetic.main.activity_resultado2.textViewPeso
import kotlinx.android.synthetic.main.activity_resultado2.textViewResultadoDensidadeCorporal
import kotlinx.android.synthetic.main.activity_resultado2.titleDensidadeCorporal

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado2)

        val imc = intent.getParcelableExtra<IMC>("value")
        if (imc != null) {
            titleDensidadeCorporal.text = imc.getNome() ?: ""
            textViewHeaderDensidadeCorporal.text = imc.calcular()
            textViewPeso.text = imc.getPeso().toString()
            textViewAltura.text = imc.getAltura().toString()



            // Formata o resultado do IMC para exibir duas casas decimais
            val imcFormatado = "%.2f".format(imc.imc)
            textViewResultadoDensidadeCorporal.text = imcFormatado
        } else {
            // Se o objeto IMC for nulo, exibe uma mensagem de erro
            textViewResultadoDensidadeCorporal.text = "IMC não encontrado."
        }
    }
}
