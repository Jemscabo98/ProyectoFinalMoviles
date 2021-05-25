package teamfood.menufoodapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore



private lateinit var storage: FirebaseFirestore
private lateinit var usuario: FirebaseAuth

class Carne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carne)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        val btnPiernil = findViewById(R.id.btnPiernil) as ImageView
        val btnJamon = findViewById(R.id.btnJamon) as ImageView
        val btnPollo = findViewById(R.id.btnPollo) as ImageView
        val btnRes = findViewById(R.id.btnRes) as ImageView
        val btnPescado = findViewById(R.id.btnPescado) as ImageView


        btnPiernil.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Piernil")

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

        btnJamon.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Jamon")

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

        btnPollo.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Pollo")

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

        btnRes.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Carne")

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

        btnPescado.setOnClickListener(){
            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Pescado")

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