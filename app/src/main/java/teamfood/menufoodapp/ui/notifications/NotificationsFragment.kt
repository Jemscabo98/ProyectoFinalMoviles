package teamfood.menufoodapp.ui.notifications

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

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_explorar)
        val imgIng: ImageView = root.findViewById(R.id.imgIngredientes)
        val imgDiet: ImageView = root.findViewById(R.id.imgDietas)
        val imgMex: ImageView = root.findViewById(R.id.imgMexicana)
        val imgApr: ImageView = root.findViewById(R.id.imgAprende)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        imgIng.setOnClickListener(){
            val intent: Intent = Intent(requireActivity(), Ingredientes::class.java).apply{}
            startActivity(intent)
        }

        imgDiet.setOnClickListener(){
            val intent: Intent = Intent(requireActivity(), Dieta::class.java).apply{}
            startActivity(intent)
        }

        imgMex.setOnClickListener(){
            val intent: Intent = Intent(requireActivity(), Mexicana::class.java).apply{}
            startActivity(intent)
        }

        imgApr.setOnClickListener(){
            val intent: Intent = Intent(requireActivity(), Aprende::class.java).apply{}
            startActivity(intent)
        }


        return root
    }
}