package teamfood.menufoodapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import teamfood.menufoodapp.*
import teamfood.menufoodapp.ui.home.RegistrarReceta

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val nombre_usuario: TextView = root.findViewById(R.id.text_dashboard)
        val btnPizzaClasica: com.google.android.material.imageview.ShapeableImageView = root.findViewById(R.id.imgPizzaClasica)
        val btnChiken: com.google.android.material.imageview.ShapeableImageView = root.findViewById(R.id.imgChiken)
        val btnCake: com.google.android.material.imageview.ShapeableImageView = root.findViewById(R.id.imgCake)
        val btnEnsalada: ImageView = root.findViewById(R.id.imgEnsalada)
        val btnPasta: ImageView = root.findViewById(R.id.imgPasta)
        val btnRegistrarReceta: ImageView = root.findViewById(R.id.registrarReceta)
        val btnDeChef: ImageView = root.findViewById(R.id.imgDeChef)

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {

            btnPizzaClasica.setOnClickListener{
                val intent: Intent = Intent(requireActivity(), Pizzaclasica::class.java)
                startActivity(intent)
            }

            btnChiken.setOnClickListener{
                val intent: Intent = Intent(requireActivity(), BrochetaPollo::class.java)
                startActivity(intent)
            }

            btnCake.setOnClickListener{
                val intent: Intent = Intent(requireActivity(), Cake::class.java)
                startActivity(intent)
            }

            btnEnsalada.setOnClickListener{
                val intent: Intent = Intent(requireActivity(), Ensalada::class.java)
                startActivity(intent)
            }

            btnPasta.setOnClickListener{
                val intent: Intent = Intent(requireActivity(), Ensalada::class.java)
                startActivity(intent)
            }

            btnRegistrarReceta.setOnClickListener{
                val intent: Intent = Intent(requireActivity(), RegistrarReceta::class.java)
                startActivity(intent)
            }

            btnDeChef.setOnClickListener{
                val intent: Intent = Intent(requireActivity(), Recomendaciones::class.java)
                startActivity(intent)
            }

        })

        return root
    }
}