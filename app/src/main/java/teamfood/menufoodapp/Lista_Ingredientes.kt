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

    companion object{
        var listaux: ArrayList<String> = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_ingredientes)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        var lista: ListView = findViewById(R.id.listIng)

        var adapter: ArrayAdapter<*>

        adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,getList())
        lista.adapter=adapter
        adapter.notifyDataSetChanged()
    }

    fun getList(): ArrayList<String>{

        listaux.add("relleno")
        listaux.add("relleno2")

        storage.collection("ingrediente")
            .whereEqualTo("email",usuario.currentUser?.email.toString())
            .get()
            .addOnSuccessListener {
                Toast.makeText(this, "Se cargaron los ingredientes", Toast.LENGTH_SHORT).show()
                it.forEach{
                    Toast.makeText(this, "Se cargó "+it.getString("ingredientes")!!, Toast.LENGTH_SHORT).show()
                    var aux=it.getString("ingredientes")!!
                    listaux.add(aux)
                }
            }
            .addOnFailureListener{
                Toast.makeText(this, "No se agrego la receta", Toast.LENGTH_SHORT).show()
            }

        Thread.sleep(3000)
        return listaux
    }
}