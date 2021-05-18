package teamfood.menufoodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.io.Serializable

class Recetas : AppCompatActivity() {
    var adapter: RecetaAdapter? =null
    var recetas = ArrayList<Receta>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recetas_grid)

        var gridRecetas: GridView = findViewById(R.id.gridRecetas)
        var btnRegreso: Button = findViewById(R.id.btnVolver)

        btnRegreso.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val bundle = intent.extras
        if(bundle != null){
            if (bundle.getString("name") == "RecetasCompletas"){
                cargarRecetasCompletas()
                adapter = RecetaAdapter(this, recetas)
                gridRecetas.adapter = adapter
            }

            if (bundle.getString("name") == "RecetasSubidas"){
                cargarRecetasSubidas()

                var nombre = bundle.getString("nombre")
                var ingredientes = bundle.getFloat("dificultad")
                var imagen = bundle.getInt("imagen")
                var pasos = bundle.getString("pasos")

                var args = bundle.getBundle("BUNDLE")
                if (args != null) {
                    var aux = args.getSerializable("ARRAYLIST") as ArrayList<Int>

                    if (nombre != null && pasos!= null) {
                        var receta: Receta = Receta(
                            nombre,
                            imagen,
                            ingredientes,
                            aux,
                            pasos)

                        recetas.add(receta)
                    }else{
                        var receta: Receta = Receta(
                            "nombre",
                            imagen,
                            ingredientes,
                            aux,
                            "pasos")

                        recetas.add(receta)
                    }
                }

                adapter = RecetaAdapter(this, recetas)
                gridRecetas.adapter = adapter
            }

            if (bundle.getString("name") == "RecetasFavoritas"){
                cargarRecetasFavoritas()
                adapter = RecetaAdapter(this, recetas)
                gridRecetas.adapter = adapter
            }
        }
    }

    fun cargarRecetasCompletas(){
        var pizza = ArrayList<Int>()
        pizza.add(R.drawable.icon_queso_ldpi)
        pizza.add(R.drawable.icon_sal_ldpi)
        pizza.add(R.drawable.icon_pan_ldpi)
        recetas.add(Receta("Pizza", R.drawable.completadas_5, 4.5f, pizza,
                "1. ¡Manos a la masa!\n " +
                        "Mezcla la harina con la levadura, la sal y el aceite\n" +
                        "Añade agua poco a poco hasta que obtengas una consistencia suave y todos los ingredientes estén bien incorporados\n" +
                        "Haz una bola con la masa que preparaste y colócala dentro de un recipiente que previamente hayas enharinado\n" +
                        "Espera 45 minutos a que la mezcla que hiciste aumente su tamaño al doble\n\n" +
                        "2. Sin salsa no hay sabor\n" +
                        "Sofríe ajo en una olla o sartén a temperatura baja para lograr que se dore por fuera, pero que suelte todo su sabor\n" +
                        "Añade la salsa de tomate, aceite, comino, orégano, sal y azúcar\n" +
                        "Deja que se cocine de 10 a 15 minutos\n" +
                        "Retira y déjalo enfriar"))

        var ensalada = ArrayList<Int>()
        ensalada.add(R.drawable.icon_zanahoria_ldpi)
        ensalada.add(R.drawable.icon_aguacate_ldpi)
        ensalada.add(R.drawable.icon_espinaca_ldpi)
        ensalada.add(R.drawable.icon_brocoli_ldpi)
        recetas.add(Receta("Ensalada", R.drawable.completadas_6, 2.0f, ensalada,
                "1. Elegir una base con una variedad de hojas verdes y otros vegetales.\n" +
                        "2. Agregar dos porciones de proteínas ya sea de origen animal o vegetal.\n" +
                        "3. Endulzar con media taza de fruta.\n" +
                        "4. Agregar una cucharada de frutos secos o cereales.\n" +
                        "5. Una cucharada de algun tipo de queso.\n" +
                        "6. Una cucharada de un aderezo."))
    }

    fun cargarRecetasSubidas(){
        var ensalada = ArrayList<Int>()
        ensalada.add(R.drawable.icon_zanahoria_ldpi)
        ensalada.add(R.drawable.icon_aguacate_ldpi)
        ensalada.add(R.drawable.icon_espinaca_ldpi)
        ensalada.add(R.drawable.icon_brocoli_ldpi)
        recetas.add(Receta("Ensalada", R.drawable.subidas_5, 2.0f, ensalada,
                "1. Elegir una base con una variedad de hojas verdes y otros vegetales.\n" +
                        "2. Agregar dos porciones de proteínas ya sea de origen animal o vegetal.\n" +
                        "3. Endulzar con media taza de fruta.\n" +
                        "4. Agregar una cucharada de frutos secos o cereales.\n" +
                        "5. Una cucharada de algun tipo de queso.\n" +
                        "6. Una cucharada de un aderezo."))
    }

    fun cargarRecetasFavoritas(){
        var pizza = ArrayList<Int>()
        pizza.add(R.drawable.icon_queso_ldpi)
        pizza.add(R.drawable.icon_sal_ldpi)
        pizza.add(R.drawable.icon_pan_ldpi)
        recetas.add(Receta("Pizza", R.drawable.favoritas_2, 4.5f, pizza,
                "1. ¡Manos a la masa!\n " +
                        "Mezcla la harina con la levadura, la sal y el aceite\n" +
                        "Añade agua poco a poco hasta que obtengas una consistencia suave y todos los ingredientes estén bien incorporados\n" +
                        "Haz una bola con la masa que preparaste y colócala dentro de un recipiente que previamente hayas enharinado\n" +
                        "Espera 45 minutos a que la mezcla que hiciste aumente su tamaño al doble\n\n" +
                        "2. Sin salsa no hay sabor\n" +
                        "Sofríe ajo en una olla o sartén a temperatura baja para lograr que se dore por fuera, pero que suelte todo su sabor\n" +
                        "Añade la salsa de tomate, aceite, comino, orégano, sal y azúcar\n" +
                        "Deja que se cocine de 10 a 15 minutos\n" +
                        "Retira y déjalo enfriar"))
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

    img.setImageResource(receta.imagen)
    name.setText(receta.nombre)

        img.setOnClickListener{
            var intent = Intent(context, RecetaDetail::class.java)
            intent.putExtra("nombre", receta.nombre)
            intent.putExtra("imagen", receta.imagen)
            intent.putExtra("dificultad", receta.dificultad)
            intent.putExtra("pasos", receta.pasos)

            val args: Bundle = Bundle()
            args.putSerializable("ARRAYLIST", receta.ingredientes)
            intent.putExtra("BUNDLE", args)

            context!!.startActivity(intent)
        }
        return vista
    }

}