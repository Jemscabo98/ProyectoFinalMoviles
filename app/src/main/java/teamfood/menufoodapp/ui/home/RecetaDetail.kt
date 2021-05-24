package teamfood.menufoodapp.ui.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.imageview.ShapeableImageView
import teamfood.menufoodapp.MainActivity
import teamfood.menufoodapp.R

class RecetaDetail : AppCompatActivity() {
    var adapter: IngredientesAdapter? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receta_detail)

        var name: TextView = findViewById(R.id.txtNombreReceta)
        var imagen: ShapeableImageView = findViewById(R.id.imgReceta)
        var dificultad: RatingBar = findViewById(R.id.dificultLevelReceta)
        var ingredientes: GridView = findViewById(R.id.gridIngredientes)
        var pasos: TextView = findViewById(R.id.pasosReceta)
        var btnRegreso: Button = findViewById(R.id.btnVolver2)

        btnRegreso.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Asigna valores
        val bundle = intent.extras

        if (bundle != null){
            name.setText(bundle.getString("nombre"))
            imagen.setImageResource(bundle.getDouble("imagen").toInt())
            dificultad.setRating(bundle.getDouble("dificultad").toFloat())
            pasos.setText(bundle.getString("pasos"))

            var args = bundle.getBundle("BUNDLE")
            if (args != null)
            {
                var arrayInt = args.getSerializable("ARRAYLIST") as ArrayList<Int>

                adapter = IngredientesAdapter(this, arrayInt)
                ingredientes.adapter = adapter

            }

        }
    }
}

class IngredientesAdapter: BaseAdapter {
    var ingredientes = ArrayList<Int>()
    var context: Context? = null

    constructor(context: Context?, ingredientes: ArrayList<Int>){
        this.ingredientes = ingredientes
        this.context = context
    }

    override fun getCount(): Int {
        return ingredientes.size
    }

    override fun getItem(position: Int): Any {
        return ingredientes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var ingrediente = ingredientes[position]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflater.inflate(R.layout.cell_ingrediente, null)

        var img: ImageView = vista.findViewById(R.id.ingrediente)

        img.setImageResource(ingrediente)
        return vista
    }

}