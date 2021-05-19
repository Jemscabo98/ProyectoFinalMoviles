package teamfood.menufoodapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_carne.*
import teamfood.menufoodapp.teamfood.menufoodapp.Preferencias

private lateinit var preferencias: SharedPreferences

class Carne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carne)

        preferencias= getSharedPreferences("ing", Context.MODE_PRIVATE)

        btnPiernil.setOnClickListener(){
            preferencias.edit().putBoolean(Preferencias.PIERNIL,true).apply()
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnJamon.setOnClickListener(){
            preferencias.edit().putBoolean(Preferencias.JAMON,true).apply()
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnPollo.setOnClickListener(){
            preferencias.edit().putBoolean(Preferencias.POLLO,true).apply()
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnRes.setOnClickListener(){
            preferencias.edit().putBoolean(Preferencias.RES,true).apply()
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnPescado.setOnClickListener(){
            preferencias.edit().putBoolean(Preferencias.PESCADO,true).apply()
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }
    }
}