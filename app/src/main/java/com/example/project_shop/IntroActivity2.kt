package com.example.project_shop

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.LayoutInflaterCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_shop.databinding.ActivityIntro2Binding

class IntroActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityIntro2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inflar el binding correctamente utilizando 'layoutInflater'
        binding = ActivityIntro2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            startBtn.setOnClickListener {
                startActivity(Intent(this@IntroActivity2, MainActivity::class.java))
            }
        }

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
