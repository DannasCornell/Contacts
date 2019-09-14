package mx.unam.tic.docencia.contactsunam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().
                add(R.id.containerRegister,
                RegisterFragment.newInstance()
            )
                .commit()
        }
    }
}
