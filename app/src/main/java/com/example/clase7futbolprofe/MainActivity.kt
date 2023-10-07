package com.example.clase7futbolprofe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){

    private lateinit var rvEquipos: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvEquipos = findViewById(R.id.rv_equipos)
        rvEquipos.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        rvEquipos.adapter = adapter
        adapter.submitList(getListadoEquipos())

        adapter.onItemClickListener = {
            navegarDetalle(it)
        }
    }

    private fun navegarDetalle(equipo: Equipo) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("equipo", equipo)
        startActivity(intent)
    }

    private fun getListadoEquipos(): MutableList<Equipo>? {
        return mutableListOf(
            Equipo(1,
                "Boca",
                6,
                Pais.ARGENTINA,
                "https://upload.wikimedia.org/wikipedia/commons/7/7d/BocaJuniors.png"
            ),
            Equipo(2,
                "River",
                4,
                Pais.ARGENTINA,
                "https://upload.wikimedia.org/wikipedia/commons/3/3f/Logo_River_Plate.png"
            ),
            Equipo(3,
                "Palmeiras",
                3,
                Pais.BRASIL,
                "https://logodownload.org/wp-content/uploads/2015/05/palmeiras-logo-0.png"
            ),
            Equipo(4,
                "Atletico Nacional",
                2,
                Pais.COLOMBIA,
                "https://upload.wikimedia.org/wikipedia/commons/2/29/Atletico-nacional-vector-logo_11186.jpg"
            ),
            Equipo(5,
                "Atletico Mineiro",
                1,
                Pais.BRASIL,
                "https://upload.wikimedia.org/wikipedia/commons/9/90/1990_Clube_Atl%C3%A9tico_Mineiro_crest.jpg"
            ),
            Equipo(6,
                "Independiente",
                7,
                Pais.ARGENTINA,
                "https://logodownload.org/wp-content/uploads/2018/07/clube-independiente-logo-escudo.png"
            ),
            Equipo(7,
                "Nacional",
                3,
                Pais.URUGUAY,
                "https://as00.epimg.net/img/comunes/fotos/fichas/equipos/large/47.png"
            ),
            Equipo(8,
                "Olimpia",
                3,
                Pais.PARAGUAY,
                "https://upload.wikimedia.org/wikipedia/commons/e/e5/Olimpia_wiki.jpg"
            )
        )
    }
}