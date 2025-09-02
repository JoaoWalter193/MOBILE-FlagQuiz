package com.example.flagquiz

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaQuiz : AppCompatActivity() {

    val flags = listOf(
        R.drawable.flag_cairo,
        R.drawable.flag_india,
        R.drawable.flag_japao,
        R.drawable.flag_nepal,
        R.drawable.flag_brasil,
        R.drawable.flag_bangladesh,
        R.drawable.flag_colombia,
        R.drawable.flag_equador,
        R.drawable.flag_jamaica,
        R.drawable.flag_franca,
        R.drawable.flag_polonia,
        R.drawable.flag_vaticano
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




    }
}