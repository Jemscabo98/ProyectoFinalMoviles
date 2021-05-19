package teamfood.menufoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Ingredientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredientes)
        val ingCarne: ImageView = findViewById(R.id.ingCarne) as ImageView
        val ingVerd: ImageView = findViewById(R.id.ingVerd) as ImageView
        val ingEsp: ImageView = findViewById(R.id.ingEsp) as ImageView

        ingCarne.setOnClickListener(){
            val intent: Intent = Intent(this, Carne::class.java)
            startActivity(intent)
        }

        ingVerd.setOnClickListener(){
            val intent: Intent = Intent(this, Vegetales::class.java)
            startActivity(intent)
        }

        ingEsp.setOnClickListener(){
            val intent: Intent = Intent(this, Especias::class.java)
            startActivity(intent)
        }
    }
}