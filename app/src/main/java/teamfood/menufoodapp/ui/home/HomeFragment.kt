package teamfood.menufoodapp.ui.home

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.imageview.ShapeableImageView
import teamfood.menufoodapp.*
import java.lang.Exception
import java.net.URL


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var adapter: IngredientesAdapter? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val btnRecetasCompletas: Button = root.findViewById(R.id.btnRecetasCompletas)
        val btnRecetasSubidas: Button = root.findViewById(R.id.btnRecetasSubidas)
        val btnRecetasFavoritas: Button = root.findViewById(R.id.btnRecetasFavoritas)
        val btnAyuda: Button = root.findViewById(R.id.btnAyuda)
        val btnSubirReceta: Button = root.findViewById(R.id.btnSubirReceta)
        val nombre_usuario: TextView = root.findViewById(R.id.nombre_usuario)
        val img_usuario: ShapeableImageView = root.findViewById(R.id.imgPerfil)
        val ingredientes: GridView = root.findViewById(R.id.gridIngredientesFav)

        lookData()

        //Cargar ingredientes
        if (listaIngrediente.isNotEmpty()){
            var Listaingr = ArrayList<Int>()
            for (n in listaIngrediente){
                Listaingr.add(n.icon)
            }
            adapter = IngredientesAdapter(activity, Listaingr)
            ingredientes.adapter = adapter
        }

        try {
            val url: URL = URL(pic)
            val bitmap: Bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())

            img_usuario.setImageBitmap(bitmap)

        } catch (e: Exception){
            Toast.makeText(activity, "No se pudo cargar imagen", Toast.LENGTH_LONG).show()

            val url: URL = URL("https://media-exp1.licdn.com/dms/image/C5103AQGzZur0sCKtlQ/profile-displayphoto-shrink_200_200/0/1562701015334?e=1624492800&v=beta&t=27ZFrh83xZV2ef0jzGQ9FwRmRhIbtQ6EsNsMrqlLEcg")
            val bitmap: Bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())

            img_usuario.setImageBitmap(bitmap)
        }
        nombre_usuario.setText(name)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {

            btnRecetasCompletas.setOnClickListener {
                val intent: Intent = Intent(requireActivity(), Recetas::class.java)
                intent.putExtra("name", "RecetasCompletas")
                startActivity(intent)
            }

            btnRecetasSubidas.setOnClickListener {
                val intent: Intent = Intent(requireActivity(), Recetas::class.java)
                intent.putExtra("name", "RecetasSubidas")
                startActivity(intent)
            }

            btnRecetasFavoritas.setOnClickListener {
                val intent: Intent = Intent(requireActivity(), Recetas::class.java)
                intent.putExtra("name", "RecetasFavoritas")
                startActivity(intent)
            }

            btnAyuda.setOnClickListener {
                val intent: Intent = Intent(requireActivity(), Soporte::class.java)
                startActivity(intent)
            }

            btnSubirReceta.setOnClickListener {
                val intent: Intent = Intent(requireActivity(), RegistrarReceta::class.java)
                startActivity(intent)
            }

        })
        return root
    }


    fun lookData(){
        val aux1 = "https://media-exp1.licdn.com/dms/image/C5103AQGzZur0sCKtlQ/profile-displayphoto-shrink_200_200/0/1562701015334?e=1624492800&v=beta&t=27ZFrh83xZV2ef0jzGQ9FwRmRhIbtQ6EsNsMrqlLEcg"

        val sharedPref = activity?.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE) ?: return
        name = sharedPref.getString(NAME, "No Name")
        pic = sharedPref.getString(PIC, aux1)
    }

}