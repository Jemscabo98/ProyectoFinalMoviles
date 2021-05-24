package teamfood.menufoodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.io.Serializable

class Recetas : AppCompatActivity() {
    var adapter: RecetaAdapter? =null
    var recetas = ArrayList<Receta>()

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recetas_grid)

        var gridRecetas: GridView = findViewById(R.id.gridRecetas)
        var btnRegreso: ImageView = findViewById(R.id.imgCategoria)

        btnRegreso.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        recetas = ArrayList<Receta>()
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        val bundle = intent.extras
        if (bundle!=null)
            filltask(gridRecetas, bundle)

        if (!recetas.isEmpty()){

            adapter = RecetaAdapter(this, recetas)
            gridRecetas.adapter = adapter
        }
    }

    fun filltask(gridRecetas: GridView, bundle: Bundle){
        var RecetasCompletas: ArrayList<Receta> = ArrayList()
        var RecetasSubidas: ArrayList<Receta> = ArrayList()
        var RecetasFavoritas: ArrayList<Receta> = ArrayList()

        storage.collection("receta")
            .whereEqualTo("email", usuario.currentUser?.email.toString())
            .get()
            .addOnSuccessListener {
                it.forEach{
                    var list: List<Double> = it.get("ingredientes") as List<Double>
                    var ing: ArrayList<Double> = ArrayList(list)

                    if (it.getString("clasificacion") == "RecetasCompletas"){
                        RecetasCompletas.add(
                            Receta(it.getString("nombre"),
                            it.getDouble("imagen"),
                            it.getDouble("dificultad"),
                            ing,
                            it.getString("pasos"),
                            it.getString("clasificacion")))
                    }

                    if (it.getString("clasificacion") == "RecetasSubidas"){
                        RecetasSubidas.add(
                            Receta(it.getString("nombre"),
                                it.getDouble("imagen"),
                                it.getDouble("dificultad"),
                                ing,
                                it.getString("pasos"),
                                it.getString("clasificacion")))
                    }

                    if (it.getString("clasificacion") == "RecetasFavoritas"){
                        RecetasFavoritas.add(
                            Receta(it.getString("nombre"),
                                it.getDouble("imagen"),
                                it.getDouble("dificultad"),
                                ing,
                                it.getString("pasos"),
                                it.getString("clasificacion")))
                    }
                }

                if (bundle.getString("name") == "RecetasCompletas"){
                    val txt: TextView = findViewById(R.id.txtCategoriaReceta)
                    txt.setText("Recetas Completas")
                    recetas = RecetasCompletas
                    adapter = RecetaAdapter(this, recetas)
                    gridRecetas.adapter = adapter
                }

                if (bundle.getString("name") == "RecetasSubidas"){
                    val txt: TextView = findViewById(R.id.txtCategoriaReceta)
                    txt.setText("Recetas Subidas")
                    recetas = RecetasSubidas
                    adapter = RecetaAdapter(this, recetas)
                    gridRecetas.adapter = adapter
                }

                if (bundle.getString("name") == "RecetasFavoritas"){
                    val txt: TextView = findViewById(R.id.txtCategoriaReceta)
                    txt.setText("Recetas Favoritas")
                    recetas = RecetasFavoritas
                    adapter = RecetaAdapter(this, recetas)
                    gridRecetas.adapter = adapter
                }
            }
            .addOnFailureListener{
                Toast.makeText(this, "Error: intente de nuevo", Toast.LENGTH_SHORT).show()
            }
    }
}

class RecetaAdapter: BaseAdapter{
    var recetas = ArrayList<Receta>()
    var context: Context? = null

    constructor(context: Context?, recetas: ArrayList<Receta>){
        this.recetas = recetas
        this.context = context
    }

    override fun getCount(): Int {
        return recetas.size
    }

    override fun getItem(position: Int): Any {
        return recetas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
    var receta = recetas[position]
    var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var vista = inflater.inflate(R.layout.cell_receta, null)

    var img: ImageView = vista.findViewById(R.id.imgPresentacion)
    var name: TextView = vista.findViewById(R.id.txtPresentacion)

    img.setImageResource(receta.imagen?.toInt()!!)
    name.setText(receta.nombre)

        img.setOnClickListener{
            var intent = Intent(context, RecetaDetail::class.java)
            intent.putExtra("nombre", receta.nombre)
            intent.putExtra("imagen", receta.imagen)
            intent.putExtra("dificultad", receta.dificultad)
            intent.putExtra("pasos", receta.pasos)
            intent.putExtra("clasificacion", receta.clasificacion)

            val args: Bundle = Bundle()
            args.putSerializable("ARRAYLIST", receta.ingredientes)
            intent.putExtra("BUNDLE", args)

            context!!.startActivity(intent)
        }
        return vista
    }

}