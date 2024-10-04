package com.example.project_shop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_shop.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdaptadorProducto

    var listaProductos = ArrayList<Producto>()
    var carroCompras = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar el binding correctamente
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ajuste del padding para las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar Firebase Analytics
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración de Firebase completada")
        analytics.logEvent("InitScreen", bundle)

        // Llamar a la función para agregar productos
        agregarProductos()

        // Configurar el RecyclerView
        setupRecyclerView()
    }

    // Configuración del RecyclerView
    fun setupRecyclerView() {
        // Configuración del layout manager para el RecyclerView
        binding.rvListaProductos.layoutManager = LinearLayoutManager(this)

        // Inicialización del adaptador
        adapter = AdaptadorProducto(
            context = this,
            tvCantProductos = binding.tvCantProductos,
            listaCarro = binding.btnVerCarro,
            listaProductos = listaProductos,
            carroCompras = carroCompras
        )

        // Asignar el adaptador al RecyclerView
        binding.rvListaProductos.adapter = adapter
    }

    fun agregarProductos() {
        listaProductos.add(
            Producto(
                idProducto = "1",
                nomProducto = "Producto 1",
                descripcion = "Descripción del producto 1",
                precio = 50.0
            )
        )
        listaProductos.add(
            Producto(
                idProducto = "2",
                nomProducto = "Producto 2",
                descripcion = "Descripción del producto 2",
                precio = 75.0
            )
        )
        listaProductos.add(
            Producto(
                idProducto = "3",
                nomProducto = "Producto 3",
                descripcion = "Descripción del producto 3",
                precio = 100.0
            )
        )
        listaProductos.add(
            Producto(
                idProducto = "4",
                nomProducto = "Producto 4",
                descripcion = "Descripción del producto 4",
                precio = 25.0
            )
        )
        listaProductos.add(
            Producto(
                idProducto = "5",
                nomProducto = "Producto 5",
                descripcion = "Descripción del producto 5",
                precio = 150.0
            )
        )
    }

}

