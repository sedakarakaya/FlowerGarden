package com.sedakarakaya.flowergarden

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Cicekler_detay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cicekler_detay)

        val txtDetayAdi = findViewById<TextView>(R.id.detayAdi)
        val txtDetayAciklama = findViewById<TextView>(R.id.detayAciklama)
        val imgDetayResim = findViewById<ImageView>(R.id.detayResim)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val adi = bundle.getString("constAdi")
            val aciklama = bundle.getString("constAciklama")
            val resim = bundle.getInt("constResim")

            txtDetayAdi.text = adi
            txtDetayAciklama.text = aciklama
            imgDetayResim.setImageResource(resim)
        }
    }
}