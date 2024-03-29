package mx.unam.tic.docencia.contactsunam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cybertch.fragmentsexample.adapters.ContactAdapter
import com.cybertch.fragmentsexample.model.Contact
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val contact = intent.extras?.get("contactParam") as Contact
        Log.d("test", "Hola")

        nameTextView?.text = contact.name
        lastnameTextView?.text =contact.lastname
        id_textView?.text= contact.id.toString()

        button_delete.setOnClickListener { view ->
            val deleteIntent=Intent(this, MainActivity::class.java)
            deleteIntent.putExtra("contactParam", contact.id )
            startActivity(deleteIntent)
        }
    }



}
