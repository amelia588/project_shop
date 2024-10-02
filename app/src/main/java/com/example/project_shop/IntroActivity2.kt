package com.example.project_shop

import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IntroActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intro2)

        // Aplicar padding para las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Manejo del texto con formato HTML
        val textView: TextView = findViewById(R.id.textView3)
        val formattedText = Html.fromHtml(
            "Welcome to <font color='#39c7a5'>Digital Store</font><br> a <font color='#39c7a5'>Gateway</font> to the Latest Tech",
            Html.FROM_HTML_MODE_LEGACY
        )
        textView.text = formattedText
    }
}
