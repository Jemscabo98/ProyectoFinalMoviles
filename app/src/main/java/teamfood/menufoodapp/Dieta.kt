package teamfood.menufoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class Dieta : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dietas)

        val btnVegano = findViewById(R.id.btnVegano) as ImageView
        val btnVegetariano = findViewById(R.id.btnVegetariano) as ImageView

        btnVegano.setOnClickListener{
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnVegetariano.setOnClickListener{
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }
    }
}