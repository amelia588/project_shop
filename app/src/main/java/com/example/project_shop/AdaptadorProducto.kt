package com.example.project_shop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorProducto(
    var context: Context,
    var tvCantProductos: TextView,
    var listaCarro: Button,
    var listaProductos: ArrayList<Producto>,
    var carroCompras: ArrayList<Producto>
) : RecyclerView.Adapter<AdaptadorProducto.ViewHolder>() {

    // ViewHolder para manejar las vistas de cada ítem del RecyclerView
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNomProducto: TextView = itemView.findViewById(R.id.tvNomProducto)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
        val cbCarro: CheckBox = itemView.findViewById(R.id.cbCarro)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecio)
    }

    // Inflar el layout del ítem y devolver el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_productos, parent, false)
        return ViewHolder(view)
    }

    // Vincular los datos con las vistas
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = listaProductos[position]
        holder.tvNomProducto.text = producto.nomProducto
        holder.tvDescripcion.text = producto.descripcion
        holder.tvPrecio.text = producto.precio.toString()

        // Manejo del CheckBox para agregar o quitar del carrito
        holder.cbCarro.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tvCantProductos.text = "${tvCantProductos.text.toString().toInt() + 1}"
                carroCompras.add(producto)
            } else {
                tvCantProductos.text = "${tvCantProductos.text.toString().toInt() - 1}"
                carroCompras.remove(producto)
            }
        }

        // Configurar el botón para ver el carrito de compras
        listaCarro.setOnClickListener {
            val intent = Intent(context, CarroComprasActivity::class.java)
            intent.putParcelableArrayListExtra("carro_compras", carroCompras)
            context.startActivity(intent)
        }
    }

    // Retornar el número de ítems en la lista de productos
    override fun getItemCount(): Int {
        return listaProductos.size
    }
}
