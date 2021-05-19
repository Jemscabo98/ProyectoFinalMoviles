package teamfood.menufoodapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_ver_ingredientes.*
import teamfood.menufoodapp.teamfood.menufoodapp.Item
import teamfood.menufoodapp.teamfood.menufoodapp.Preferencias
import java.util.ArrayList

class VerIngredientes : AppCompatActivity() {
    private lateinit var adaptador: AdaptadorLista
    lateinit var lvItems: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_ingredientes)
        var preferencias = getSharedPreferences("ing", Context.MODE_PRIVATE)

        lvItems = findViewById(R.id.listIng)
        adaptador =  AdaptadorLista(this,getList(preferencias))
        lvItems.adapter=adaptador
    }

    fun getList(preferencias: SharedPreferences): ArrayList<Item>{
        var list: ArrayList<Item> = ArrayList()

        list=addCarne(list,preferencias)

        return list
    }

    fun addCarne(list:ArrayList<Item>, preferencias: SharedPreferences): ArrayList<Item>{
        var prefPiernil: Boolean = preferencias.getBoolean(Preferencias.PIERNIL,false)
        var prefJamon: Boolean = preferencias.getBoolean(Preferencias.JAMON,false)
        var prefPollo: Boolean = preferencias.getBoolean(Preferencias.POLLO,false)
        var prefRes: Boolean = preferencias.getBoolean(Preferencias.RES,false)
        var prefPescado: Boolean = preferencias.getBoolean(Preferencias.PESCADO,false)

        if(prefPiernil==true) {
            list.add(Item(R.drawable.icon_pierna_xhdpi, "Piernil"))
        }

        if(prefJamon==true) {
            list.add(Item(R.drawable.icon_jamon_xhdpi, "Jamon"))
        }

        if(prefPollo==true) {
            list.add(Item(R.drawable.icon_pollo_xhdpi, "Pescado"))
        }

        if(prefRes==true) {
            list.add(Item(R.drawable.icon_carne_xhdpi, "Res"))
        }

        if(prefPescado==true) {
            list.add(Item(R.drawable.icon_pescado_xhdpi, "Pescado"))
        }

        return list
    }

    fun addEspecias(list:ArrayList<Item>,preferencias: SharedPreferences): ArrayList<Item>{
        var prefPiernil: Boolean = preferencias.getBoolean(Preferencias.PIERNIL,false)
        var prefJamon: Boolean = preferencias.getBoolean(Preferencias.JAMON,false)
        var prefPollo: Boolean = preferencias.getBoolean(Preferencias.POLLO,false)
        var prefRes: Boolean = preferencias.getBoolean(Preferencias.RES,false)
        var prefPescado: Boolean = preferencias.getBoolean(Preferencias.PESCADO,false)

        if(prefPiernil==true) {
            list.add(Item(R.drawable.icon_pierna_xhdpi, "Piernil"))
        }

        if(prefJamon==true) {
            list.add(Item(R.drawable.icon_jamon_xhdpi, "Jamon"))
        }

        if(prefPollo==true) {
            list.add(Item(R.drawable.icon_pollo_xhdpi, "Pescado"))
        }

        if(prefRes==true) {
            list.add(Item(R.drawable.icon_carne_xhdpi, "Res"))
        }

        if(prefPescado==true) {
            list.add(Item(R.drawable.icon_pescado_xhdpi, "Pescado"))
        }

        return list
    }

    fun addVegetales(list:ArrayList<Item>,preferencias: SharedPreferences): ArrayList<Item>{
        var prefPiernil: Boolean = preferencias.getBoolean(Preferencias.PIERNIL,false)
        var prefJamon: Boolean = preferencias.getBoolean(Preferencias.JAMON,false)
        var prefPollo: Boolean = preferencias.getBoolean(Preferencias.POLLO,false)
        var prefRes: Boolean = preferencias.getBoolean(Preferencias.RES,false)
        var prefPescado: Boolean = preferencias.getBoolean(Preferencias.PESCADO,false)

        if(prefPiernil==true) {
            list.add(Item(R.drawable.icon_pierna_xhdpi, "Piernil"))
        }

        if(prefJamon==true) {
            list.add(Item(R.drawable.icon_jamon_xhdpi, "Jamon"))
        }

        if(prefPollo==true) {
            list.add(Item(R.drawable.icon_pollo_xhdpi, "Pescado"))
        }

        if(prefRes==true) {
            list.add(Item(R.drawable.icon_carne_xhdpi, "Res"))
        }

        if(prefPescado==true) {
            list.add(Item(R.drawable.icon_pescado_xhdpi, "Pescado"))
        }

        return list
    }

}

