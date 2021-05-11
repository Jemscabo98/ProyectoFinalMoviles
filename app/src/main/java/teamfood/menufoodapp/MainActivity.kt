package teamfood.menufoodapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_principal.*
import teamfood.menufoodapp.ui.home.HomeFragment

//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Barra de navegación
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.navigation_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Mandar los datos de Google a HomeFragment para el perfil
        var bundle = intent.extras

        if (bundle != null){
            //Consigues los atributos mandados
            val name = "Algo"
                //bundle.getString("name")
            val picture = bundle.getString("picture")

            Toast.makeText(this,name + picture,Toast.LENGTH_LONG ).show()

            //Los guardas en otro Bundle para mandar
            var enviar: Bundle = Bundle()
            enviar.putString("name", name)
            enviar.putString("picture", picture)

            //Creas los argumentos del fragmento
            var fragClass = HomeFragment()
            fragClass.arguments = enviar

            val transaction: FragmentTransaction  = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, fragClass)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else{
            Toast.makeText(this,"No se pasaron los datos",Toast.LENGTH_LONG ).show()
        }

    }
}
