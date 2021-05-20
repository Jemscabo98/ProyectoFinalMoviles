package teamfood.menufoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_carne.*
import kotlinx.android.synthetic.main.activity_especias.*

class Especias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especias)

        var storage = FirebaseFirestore.getInstance()
        var usuario = FirebaseAuth.getInstance()


        btnPimienta.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Pimienta")

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

        btnCanela.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Canela")

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

        btnSal.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Sal")

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

        btnHarina.setOnClickListener(){

            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Harina")

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

        btnLevadura.setOnClickListener(){
            val actividad = hashMapOf(
                "email" to usuario.currentUser?.email.toString(),
                "ingredientes" to "Levadura")

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
}