package teamfood.menufoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Lista_Ingredientes : AppCompatActivity() {

    private lateinit var usuario: FirebaseAuth
    private lateinit var storage: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_ingredientes)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        var lista: ListView = findViewById(R.id.listIng)

        var adapter: ArrayAdapter<*>

        adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,getList())
        lista.adapter=adapter
    }

    fun getList(): ArrayList<String>{
        var listaux: ArrayList<String> = ArrayList()

        storage.collection("ingrediente")
            .whereEqualTo("email",usuario.currentUser?.email.toString())
            .get()
            .addOnSuccessListener {
                Toast.makeText(this, "Se cargaron los ingredientes", Toast.LENGTH_SHORT).show()
                it.forEach{
                    listaux.add(it.getString("ingredientes")!!)
                }
            }
            .addOnFailureListener{
                Toast.makeText(this, "No se agrego la receta", Toast.LENGTH_SHORT).show()
            }


        return listaux
    }
}