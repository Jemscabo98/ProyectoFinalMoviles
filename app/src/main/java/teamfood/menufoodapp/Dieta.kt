package teamfood.menufoodapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dietas.*
import kotlinx.android.synthetic.main.activity_mexicana.*

class Dieta : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dietas)

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