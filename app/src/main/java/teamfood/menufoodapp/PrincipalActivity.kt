package teamfood.menufoodapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.OnCompleteListener



class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val bundle = intent.extras

        if (bundle != null){
            val name = bundle.getString("name")
            //val email = bundle.getString("email")
            val tv_nombre: TextView= findViewById(R.id.tv_nombre)
            tv_nombre.setText(name)
            //tv_email.setText(email)
        }
        val btn_cerrar: Button= findViewById(R.id.btn_cerrar)

        btn_cerrar.setOnClickListener{
            finish()
        }

    }

    override fun onBackPressed() {

    }

}