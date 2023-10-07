package com.example.clase7futbolprofe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var tvnombreDetail: TextView
    private lateinit var tvTotal: TextView
    private lateinit var ivLogo: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val equipo = intent.getParcelableExtra<Equipo>("equipo")

        tvnombreDetail = findViewById(R.id.tv_nombre_detail)
        tvTotal = findViewById(R.id.tv_total_detail)
        ivLogo = findViewById(R.id.iv_logo_detail)

        tvnombreDetail.text = equipo?.nombre
        tvTotal.text = equipo?.total.toString()

        Glide.with(this).load(equipo?.logo).into(ivLogo)
    }
}