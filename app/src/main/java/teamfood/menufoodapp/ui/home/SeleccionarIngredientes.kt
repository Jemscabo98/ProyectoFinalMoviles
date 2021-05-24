package teamfood.menufoodapp.ui.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import teamfood.menufoodapp.R
import teamfood.menufoodapp.teamfood.menufoodapp.ui.home.ListaIngredientes

var listaIngrediente = ArrayList<ListaIngredientes>()

class SeleccionarIngredientes : AppCompatActivity() {
    var adapter: ListaIngrAdapter? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccionar_ingredientes)

        var gridIngredientes: GridView = findViewById(R.id.gridIngrRecetas)
        var btnRegreso: Button = findViewById(R.id.btnRegreso)

        var aux = llenarLista()

        adapter = ListaIngrAdapter(this, aux)
        gridIngredientes.adapter = adapter

        val bundle = intent.extras

        var name: String? = ""
        var imagen: Int = 0
        var dificultad: Float = 0.0f
        var pasos: String? = ""

        if (bundle != null){
            name = bundle.getString("nombre")
            imagen = bundle.getInt("imagen")
            dificultad = bundle.getFloat("dificultad")
            pasos = bundle.getString("pasos")
        }

        btnRegreso.setOnClickListener {
            val intent: Intent = Intent(this, RegistrarReceta::class.java)
            intent.putExtra("nombre", name)
            intent.putExtra("imagen", imagen)
            intent.putExtra("dificultad", dificultad)
            intent.putExtra("pasos", pasos)
            startActivity(intent)
        }

    }

    fun llenarLista(): ArrayList<ListaIngredientes>{
        var ingrediente = ArrayList<ListaIngredientes>()

        ingrediente.add(ListaIngredientes(R.drawable.icon_aguacate_xxxhdpi, "Aguacate", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_ajo_xxxhdpi, "Ajo", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_apio_xxxhdpi, "Apio", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_banana_xxxhdpi, "Banana", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_brocoli_xxxhdpi, "Brocoli", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_canela_xxxhdpi, "Canela", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_carne_xxxhdpi, "Carne", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_cebolla_xxxhdpi, "Cebolla", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_chile_xxxhdpi, "Chile", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_crema_xxxhdpi, "Crema", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_harina_xxxhdpi, "Harina", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_huevos_xxxhdpi, "Huevos", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_jamon_xxxhdpi, "Jamon", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_leche_xxxhdpi, "Leche", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_levadura_xxxhdpi, "Levadura", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_limon_xxxhdpi, "Limon", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_mango_xxxhdpi, "Mango", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_manzana_xxxhdpi, "Manzana", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_naranja_xxxhdpi, "Naranja", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_pan_xxxhdpi, "Pan", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_pescado_xxxhdpi, "Pescado", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_pierna_xxxhdpi, "Pierna", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_pimienta_xxxhdpi, "Pimienta", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_pina_xxxhdpi, "Piña", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_pollo_xxxhdpi, "Pollo", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_queso_xxxhdpi, "Queso", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_rabano_xxxhdpi, "Rabano", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_sal_xxxhdpi, "Sal", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_tomate_xxxhdpi, "Tomate", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_uva_xxxhdpi, "Uva", false))
        ingrediente.add(ListaIngredientes(R.drawable.icon_zanahoria_xxxhdpi, "Zanahoria", false))

        return ingrediente
    }
}

class ListaIngrAdapter: BaseAdapter {
    var ingredientes = ArrayList<ListaIngredientes>()
    var context: Context? = null

    constructor(context: Context?, ingredientes: ArrayList<ListaIngredientes>){
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
        var ingredientes = ingredientes[position]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflater.inflate(R.layout.ingrediente_lista_cell, null)

        var img: ImageView = vista.findViewById(R.id.imgIngr)
        var name: TextView = vista.findViewById(R.id.txtIngr)
        var booleano: Switch = vista.findViewById(R.id.btnOnOff)

        img.setImageResource(ingredientes.icon)
        name.setText(ingredientes.text)
        booleano.setChecked(ingredientes.booleano)

        booleano.setOnClickListener{
            if (booleano.isChecked) {
                ingredientes.booleano = booleano.isChecked
                listaIngrediente.add(ingredientes)
            }
        }
        return vista
    }

}