package teamfood.menufoodapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.activity_principal.*



class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val bundle = intent.extras

        if (bundle != null){
            val name = bundle.getString("name")
            //val email = bundle.getString("email")
            tv_nombre.setText(name)
            //tv_email.setText(email)
        }

        btn_cerrar.setOnClickListener{
            finish()
        }

    }

    override fun onBackPressed() {

    }

}