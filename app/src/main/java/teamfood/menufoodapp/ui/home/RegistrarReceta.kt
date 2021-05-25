package teamfood.menufoodapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import teamfood.menufoodapp.MainActivity
import teamfood.menufoodapp.R

class RegistrarReceta : AppCompatActivity() {
    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth
    var adapter: IngredientesAdapter? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_receta)

        val imagenReceta: ImageView = findViewById(R.id.imagenReceta)
        val nombreReceta: EditText = findViewById(R.id.nombreReceta)
        val dificultLevel: RatingBar = findViewById(R.id.dificultLevel)
        val btnIngredientes: Button = findViewById(R.id.btnIngredientes)
        val ingredientes: GridView = findViewById(R.id.gridRegistro)
        val pasos: EditText = findViewById(R.id.pasosRecetas)
        val btnRegistrar: Button = findViewById(R.id.btnRegistrarReceta)
        val btnCancelar: Button = findViewById(R.id.btnCancelar)
        val spinner: Spinner = findViewById(R.id.spinner)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()
        var Listaingr = ArrayList<Int>()

        val bundle = intent.extras
        if (bundle != null){
            nombreReceta.setText(bundle.getString("nombre"))
            imagenReceta.setImageResource(bundle.getInt("imagen"))
            dificultLevel.rating = bundle.getFloat("dificultad")
            pasos.setText(bundle.getString("pasos"))
        }


        //Cargar ingredientes
        if (listaIngrediente.isNotEmpty()){
            for (n in listaIngrediente){
                Listaingr.add(n.icon)
            }
            adapter = IngredientesAdapter(this, Listaingr)
            ingredientes.adapter = adapter
        }

        //Conecciones al spinner
        val lista: ArrayList<String> = SpinnerLista()
        val adp = ArrayAdapter(this, R.layout.spinner_list, lista)
        spinner.setAdapter(adp)
        var imagen: Int = randomNum()
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var elemento: String = spinner.adapter.getItem(position).toString()

                if (elemento.equals("Ensalada 1")){
                    imagenReceta.setImageResource(R.drawable.subidas_5)
                    imagen = R.drawable.subidas_5
                }

                if (elemento.equals("Ensalada 2")){
                    imagenReceta.setImageResource(R.drawable.subidas_6)
                    imagen = R.drawable.subidas_6
                }

                if (elemento.equals("Comida 1")){
                    imagenReceta.setImageResource(R.drawable.subidas_2)
                    imagen = R.drawable.subidas_2
                }

                if (elemento.equals("Comida 2")){
                    imagenReceta.setImageResource(R.drawable.subidas_3)
                    imagen = R.drawable.subidas_3
                }

                if (elemento.equals("Postre 1")){
                    imagenReceta.setImageResource(R.drawable.subidas_1)
                    imagen = R.drawable.subidas_1
                }

                if (elemento.equals("Postre 2")){
                    imagenReceta.setImageResource(R.drawable.subidas_4)
                    imagen = R.drawable.subidas_4
                }

                if (elemento.equals("Imagen Receta")){
                    imagen = randomNum()
                    imagenReceta.setImageResource(imagen)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {   }
        }

        //Registrar receta
        btnRegistrar.setOnClickListener {
            var intent = Intent(this, Recetas::class.java)
            intent.putExtra("name", "RecetasSubidas")

            val actividad = hashMapOf(
                    "email" to usuario.currentUser?.email.toString(),
                    "nombre" to nombreReceta.text.toString(),
                    "imagen" to imagen,
                    "dificultad" to dificultLevel.rating,
                    "ingredientes" to Listaingr,
                    "pasos" to pasos.text.toString(),
                    "clasificacion" to "RecetasSubidas")

            storage.collection("receta")
                    .add(actividad)
                    .addOnSuccessListener {
                        //Toast.makeText(this, "Se agrego la receta", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener{
                        Toast.makeText(this, "No se agrego la receta", Toast.LENGTH_SHORT).show()
                    }

            startActivity(intent)
        }

        //Cancelar receta
        btnCancelar.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        // Nos manda a escoger los ingredientes
        btnIngredientes.setOnClickListener {
            var intent = Intent(this, SeleccionarIngredientes::class.java)
            listaIngrediente.clear()
            intent.putExtra("nombre", nombreReceta.text.toString())
            intent.putExtra("imagen", imagen)
            intent.putExtra("dificultad", dificultLevel.rating)
            intent.putExtra("pasos", pasos.text.toString())
            startActivity(intent)
        }
    }

    fun SpinnerLista(): ArrayList<String>{
        val lista :ArrayList<String> = ArrayList<String>()
        lista.add("Imagen Receta")
        lista.add("Ensalada 1")
        lista.add("Ensalada 2")
        lista.add("Comida 1")
        lista.add("Comida 2")
        lista.add("Postre 1")
        lista.add("Postre 2")

        return lista
    }

    fun randomNum(): Int {
        var array: ArrayList<Int> = ArrayList<Int>()
        array.add(R.drawable.subidas_1)
        array.add(R.drawable.subidas_2)
        array.add(R.drawable.subidas_3)
        array.add(R.drawable.subidas_4)
        array.add(R.drawable.subidas_5)
        array.add(R.drawable.subidas_6)

        return array.random()
    }

}