package com.example.teste2

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.teste2.databinding.ActivityResultado2Binding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultado2Binding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultado2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val imc = intent.getParcelableExtra("value",IMC::class.java)

        if (imc != null) {
            binding.titleDensidadeCorporal.text = imc.nome.toString()
            binding.textViewHeaderDensidadeCorporal.text = imc.calcular()
            binding.textViewResultadoDensidadeCorporal.text = String.format("Seu IMC: %.2f", imc.imc)
            binding.textViewPeso.text = String.format("Seu Peso: %.1f", imc.peso)
            binding.textViewAltura.text = String.format("Sua Altura: %.1f", imc.altura)
        }

        binding.btnFecharResultados.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}