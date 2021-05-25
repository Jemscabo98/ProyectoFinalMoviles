package teamfood.menufoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Mexicana: AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mexicana)

        val btnPlatillos = findViewById(R.id.btnPlatillos) as ImageView
        val btnTacos = findViewById(R.id.btnTacos) as ImageView
        val btnCaldos = findViewById(R.id.btnCaldos) as ImageView
        val btnGorditas = findViewById(R.id.btnGorditas) as ImageView
        val btnTamales = findViewById(R.id.btnTamales) as ImageView

        btnPlatillos.setOnClickListener{
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnTacos.setOnClickListener{
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnCaldos.setOnClickListener{
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnGorditas.setOnClickListener{
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnTamales.setOnClickListener{
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }
    }
}