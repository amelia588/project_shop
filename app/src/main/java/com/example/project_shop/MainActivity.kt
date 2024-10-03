package com.example.project_shop

import android.graphics.ColorSpace.Adaptation
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.project_shop.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    private lateinit var adapter:AdaptadorProducto

    var listaProductos = ArrayList<Producto>()
    var carroCompras = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        // Ajuste del padding para las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar Firebase Analytics
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración de Firebase completada")
        analytics.logEvent("InitScreen", bundle)

        // Inicializar ViewPager2 y DotsIndicator
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dotsIndicator)

        // Conectar DotsIndicator con ViewPager2
        dotsIndicator.setViewPager2(viewPager)
    }
}
