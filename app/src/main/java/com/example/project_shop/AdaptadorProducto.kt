package com.example.project_shop

import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.core.Context

class AdaptadorProducto (
    var context: Context,
    var tvCantProductos: TextView,
    var listaCarro: Button,
    var listaProductos: ArrayList<Producto>
    var carroCompras:ArrayList<Producto>
):RecyclerView.Adapter<AdaptadorProducto.ViewHolder>(), Parcelable {
    class ViewHolder {

    }

    constructor(parcel: Parcel) : this(
        TODO("context"),
        TODO("tvCantProductos"),
        TODO("listaCarro"),
        TODO("listaProductos"),
        TODO("carroCompras")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AdaptadorProducto> {
        override fun createFromParcel(parcel: Parcel): AdaptadorProducto {
            return AdaptadorProducto(parcel)
        }

        override fun newArray(size: Int): Array<AdaptadorProducto?> {
            return arrayOfNulls(size)
        }
    }
}