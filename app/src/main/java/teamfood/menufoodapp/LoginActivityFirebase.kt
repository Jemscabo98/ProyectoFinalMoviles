package teamfood.menufoodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivityFirebase : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_firebase)

        auth = Firebase.auth

        val btn_registrarse: Button = findViewById(R.id.btn_registrarse)
        val btn_contra: TextView = findViewById(R.id.tv_olvidasteContra)
        val btn_ingresar: Button = findViewById(R.id.btn_ingresar)

        btn_registrarse.setOnClickListener{
            val intent: Intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        btn_contra.setOnClickListener{
            val intent: Intent = Intent(this, ContrasenaActivity::class.java)
            startActivity(intent)
        }

        btn_ingresar.setOnClickListener{
            valida_ingreso()
        }
    }

    private fun valida_ingreso(){
        val et_correo: EditText = findViewById(R.id.et_correo)
        val et_contra: EditText = findViewById(R.id.et_contra)

        var correo: String = et_correo.text.toString()
        var contra: String = et_contra.text.toString()

        if(!correo.isNullOrBlank() && !contra.isNullOrBlank()){
            ingresaFirebase(correo,contra)
        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }

    }

    private fun ingresaFirebase(email: String, password: String){
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                //Log.d(TAG, "signInWithEmail:success")
                val user = auth.currentUser
                //updateUI(user)
                guardarNombre(email)
                val intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                // If sign in fails, display a message to the user.
                //Log.w(TAG, "signInWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
                //updateUI(null)
            }
        }
    }

    private fun guardarNombre(email: String){

        var aux = email

        if(email.contains('@')) {
            val index: Int = email.indexOf('@')
            aux = email.substring(0, index)
        }
        aux = aux.substring(0,1).toUpperCase() + aux.substring(1)

        val sharedPref =  this.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString(NAME, aux)
            commit()
        }
    }

}