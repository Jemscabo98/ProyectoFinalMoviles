package teamfood.menufoodapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Explorar : AppCompatActivity() {
    private var adaptador: AdaptadorIng?=null
    var ingredientes = ArrayList<Ingrediente>()

    fun onCreate(inflater: LayoutInflater,
                          container: ViewGroup?,
                          savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explorar)

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        val message = intent.getStringExtra("elegido")
        llenar(message.toString())


        adaptador = AdaptadorIng(root.context,ingredientes)
        val gridView: GridView = root.findViewById(R.id.gridview_explorar)
        gridView.adapter=adaptador
    }

    private class AdaptadorIng: BaseAdapter {
        var Ingredientess=ArrayList<Ingrediente>()
        var contexto: Context? = null

        constructor(context: Context, Ingredientess: ArrayList<Ingrediente>){
            this.contexto=context
            this.Ingredientess=Ingredientess
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var ingrediente = Ingredientess[position]
            var inflator = LayoutInflater.from(contexto)
            var vista = inflator.inflate(R.layout.activity_explorar,null)

            var icon_ing: ImageView = vista.findViewById(R.id.icon_ing)
            var txt_ing: TextView = vista.findViewById(R.id.txt_ing)

            icon_ing.setImageResource(ingrediente.icon)
            txt_ing.setText(ingrediente.text)

            return vista
        }

        override fun getItem(position: Int): Any {
            return Ingredientess[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return Ingredientess.size
        }
    }

    fun llenar(eleccion: String){
        if(eleccion=="carne"){
            fillCarne()
        }
    }

    fun fillCarne(){
        ingredientes.add(Ingrediente(R.drawable.icon_pierna_xxxhdpi, "Piernil"))
        ingredientes.add(Ingrediente(R.drawable.icon_jamon_xxxhdpi, "Jamon"))
        ingredientes.add(Ingrediente(R.drawable.icon_pollo_xxxhdpi, "Pollo"))
        ingredientes.add(Ingrediente(R.drawable.icon_carne_xxxhdpi, "Res"))
        ingredientes.add(Ingrediente(R.drawable.icon_pescado_xxxhdpi, "Pescado"))
    }

    fun fillFrutas(){
        ingredientes.add(Ingrediente(R.drawable.icon_pierna_xxxhdpi, "Piernil"))
        ingredientes.add(Ingrediente(R.drawable.icon_jamon_xxxhdpi, "Jamon"))
        ingredientes.add(Ingrediente(R.drawable.icon_pollo_xxxhdpi, "Pollo"))
        ingredientes.add(Ingrediente(R.drawable.icon_carne_xxxhdpi, "Res"))
        ingredientes.add(Ingrediente(R.drawable.icon_pescado_xxxhdpi, "Pescado"))
    }
}