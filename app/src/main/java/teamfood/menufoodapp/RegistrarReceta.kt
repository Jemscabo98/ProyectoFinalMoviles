package teamfood.menufoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.Serializable

class RegistrarReceta : AppCompatActivity() {
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


        btnRegistrar.setOnClickListener {
            var intent = Intent(this, Recetas::class.java)


            val args: Bundle = Bundle()
            args.putSerializable("ARRAYLIST", randomIng())
            intent.putExtra("name", "RecetasSubidas")
            intent.putExtra("BUNDLE", args)
            intent.putExtra("nombre", nombreReceta.text.toString())
            intent.putExtra("imagen", randomNum())
            intent.putExtra("pasos", pasos.text.toString())
            intent.putExtra("dificultad", dificultLevel.rating)

            startActivity(intent)
        }




    }

    fun randomNum(): Int {
        var array: ArrayList<Int> = ArrayList<Int>()
        array.add(R.drawable.completadas_1)
        array.add(R.drawable.completadas_2)
        array.add(R.drawable.completadas_3)
        array.add(R.drawable.completadas_4)
        array.add(R.drawable.completadas_5)
        array.add(R.drawable.completadas_6)

        return array.random()
    }

    fun randomIng(): ArrayList<Int> {
        var array: ArrayList<Int> = ArrayList<Int>()
        array.add(R.drawable.icon_mango_hdpi)
        array.add(R.drawable.icon_brocoli_ldpi)
        array.add(R.drawable.icon_zanahoria_ldpi)
        array.add(R.drawable.icon_espinaca_ldpi)
        array.add(R.drawable.icon_sal_ldpi)
        array.add(R.drawable.icon_queso_ldpi)

        return array
    }

}