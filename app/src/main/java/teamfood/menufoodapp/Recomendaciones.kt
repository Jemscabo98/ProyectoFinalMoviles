package teamfood.menufoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recomendaciones.*

class Recomendaciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendaciones)

        btnVerIng.setOnClickListener(){
            val intent: Intent = Intent(this, Lista_Ingredientes::class.java)
            startActivity(intent)
        }
    }
}