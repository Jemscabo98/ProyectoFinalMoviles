package teamfood.menufoodapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_dashboard.*
import teamfood.menufoodapp.Pizzaclasica
import teamfood.menufoodapp.R
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

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {

            btnPizzaClasica.setOnClickListener{
                val intent: Intent = Intent(requireActivity(), Pizzaclasica::class.java)
                startActivity(intent)
            }

            registrarReceta.setOnClickListener{
                val intent: Intent = Intent(requireActivity(), RegistrarReceta::class.java)
                startActivity(intent)
            }

        })

        return root
    }
}