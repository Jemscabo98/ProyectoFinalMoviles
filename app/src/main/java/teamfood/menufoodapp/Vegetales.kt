package teamfood.menufoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class Vegetales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vegetales)

        var storage = FirebaseFirestore.getInstance()
        var usuario = FirebaseAuth.getInstance()

        val btnZanahoria = findViewById(R.id.btnZanahoria) as ImageView
        val btnCebolla = findViewById(R.id.btnCebolla) as ImageView
        val btnRabano = findViewById(R.id.btnRabano) as ImageView
        val btnApio = findViewById(R.id.btnApio) as ImageView
        val btnAjo = findViewById(R.id.btnAjo) as ImageView
        val btnBrocoli = findViewById(R.id.btnBrocoli) as ImageView


        btnZanahoria.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Zanahoria")

            storage.collection("ingrediente")
                .add(actividad)
                .addOnSuccessListener {
                    //Toast.makeText(this, "Se agrego el ingrediente", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this, "No se agrego la receta", Toast.LENGTH_SHORT).show()
                }

            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnCebolla.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Cebolla")

            storage.collection("ingrediente")
                .add(actividad)
                .addOnSuccessListener {
                    Toast.makeText(this, "Se agrego el ingrediente", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this, "No se agrego la receta", Toast.LENGTH_SHORT).show()
                }

            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnRabano.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Rabano")

            storage.collection("ingrediente")
                .add(actividad)
                .addOnSuccessListener {
                    //Toast.makeText(this, "Se agrego el ingrediente", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this, "No se agrego la receta", Toast.LENGTH_SHORT).show()
                }

            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnApio.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Apio")

            storage.collection("ingrediente")
                .add(actividad)
                .addOnSuccessListener {
                    //Toast.makeText(this, "Se agrego el ingrediente", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this, "No se agrego la receta", Toast.LENGTH_SHORT).show()
                }

            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnAjo.setOnClickListener(){
            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Ajo")

            storage.collection("ingrediente")
                .add(actividad)
                .addOnSuccessListener {
                    //Toast.makeText(this, "Se agrego el ingrediente", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this, "No se agrego la receta", Toast.LENGTH_SHORT).show()
                }
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnBrocoli.setOnClickListener(){
            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Brocoli")

            storage.collection("ingrediente")
                .add(actividad)
                .addOnSuccessListener {
                    //Toast.makeText(this, "Se agrego el ingrediente", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this, "No se agrego la receta", Toast.LENGTH_SHORT).show()
                }
            val intent: Intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }
    }

}