package teamfood.menufoodapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import teamfood.menufoodapp.R
import teamfood.menufoodapp.Recetas
import teamfood.menufoodapp.RegistrarReceta
import teamfood.menufoodapp.Soporte

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val btnRecetasCompletas: Button = root.findViewById(R.id.btnRecetasCompletas)
        val btnRecetasSubidas: Button = root.findViewById(R.id.btnRecetasSubidas)
        val btnRecetasFavoritas: Button = root.findViewById(R.id.btnRecetasFavoritas)
        val btnAyuda: Button = root.findViewById(R.id.btnAyuda)
        val btnSubirReceta: Button = root.findViewById(R.id.btnSubirReceta)
        val nombre_usuario: TextView = root.findViewById(R.id.nombre_usuario)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {

            btnRecetasCompletas.setOnClickListener {
                val intent: Intent = Intent(requireActivity(), Recetas::class.java)
                startActivity(intent)
            }

            btnRecetasSubidas.setOnClickListener {
                val intent: Intent = Intent(requireActivity(), Recetas::class.java)
                startActivity(intent)
            }

            btnRecetasFavoritas.setOnClickListener {
                val intent: Intent = Intent(requireActivity(), Recetas::class.java)
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
}