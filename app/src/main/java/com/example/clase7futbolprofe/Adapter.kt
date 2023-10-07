package com.example.clase7futbolprofe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) : ListAdapter<Equipo, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Equipo) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombre: TextView = view.findViewById(R.id.tv_nombre)
        private val total: TextView = view.findViewById(R.id.tv_total)
        private val pais: TextView = view.findViewById(R.id.tv_pais)
        private val logo: ImageView = view.findViewById(R.id.iv_logo)
        private val bandera: ImageView = view.findViewById(R.id.iv_bandera)

        fun bind (equipo: Equipo) {

        nombre.text = equipo.nombre
        total.text = equipo.total.toString()
        pais.text = equipo.pais.toString()

            val imagen = when (equipo.pais) {
                Pais.ARGENTINA -> R.drawable.arg
                Pais.BRASIL -> R.drawable.br
                Pais.COLOMBIA -> R.drawable.col
                Pais.URUGUAY -> R.drawable.uru
                else -> {
                    R.drawable.par
                }
            }

            bandera.setImageResource(imagen)
            Glide.with(context).load(equipo.logo).into(logo)

            view.setOnClickListener {
                onItemClickListener(equipo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val equipo = getItem(position)
        holder.bind(equipo)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Equipo>() {
        override fun areItemsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return oldItem == newItem
        }
    }
}
