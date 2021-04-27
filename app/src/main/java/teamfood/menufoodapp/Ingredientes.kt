package teamfood.menufoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Ingredientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredientes)
        val ingCarne: ImageView = R.id.ingCarne as ImageView

        ingCarne.setOnClickListener(){
            val intent: Intent = Intent(this, Explorar::class.java).apply {
                putExtra("elegido","carne")
            }
            startActivity(intent)
        }
    }
}