package mx.unam.tic.docencia.contactsunam


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cybertch.fragmentsexample.adapters.ContactAdapter
import com.cybertch.fragmentsexample.model.Contact
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_register.*

//MainFragment

class MainFragment : Fragment() {

    private lateinit var contactAdapter: ContactAdapter
    //private val contact: Contact = Contact()

    private var isTablet = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isTablet = resources.getBoolean(R.bool.isTablet)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        contactsRecyclerView.layoutManager = linearLayoutManager
        contactsRecyclerView.setHasFixedSize(true)
        val contacts = arrayListOf<Contact>(
            Contact(1, "Jaive", "Torres Pineda", "64363783727"),
            Contact(2, "Juana", "Cubana Mexicana", "45355345345435"),
            Contact(3, "Juanito", "Sanchez Loaiza", "4535534567345435"),
            Contact(4, "Juanito4", "Sanchez Loaiza", "4535534567345435"),
            Contact(5, "Juanito5", "Sanchez Loaiza", "4535534567345435"),
            Contact(6, "Juanito6", "Sanchez Loaiza", "4535534567345435"),
            Contact(7, "Juanito7", "Sanchez Loaiza", "4535534567345435"),
            Contact(8, "Juanito8", "Sanchez Loaiza", "4535534567345435"),
            Contact(9, "Juanito9", "Sanchez Loaiza", "4535534567345435"),
            Contact(10, "Juanito10", "Sanchez Loaiza", "4535534567345435")
        )
        contactAdapter = ContactAdapter(contacts, context)
        contactAdapter.setOnItemContactSelected {
            if (isTablet) {
                activity?.supportFragmentManager!!
                    .beginTransaction()
                    .replace(R.id.containerDetail, DetailFragment.newInstance(it))
                    .commit()
            } else {
                /*
                contact.name = nameTextInputLayout.editText?.text.toString()
                contact.lastname = lastNameTextInputLayout.editText?.text.toString()*/

                val detailIntent = Intent(activity, DetailActivity::class.java)
                detailIntent.putExtra("contactParam", it )
                startActivity(detailIntent)
            }
        }
        contactsRecyclerView.adapter = contactAdapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== RESUL_SAVE_CONTACT){
         //   if(resultCode== Activity.RESULT_OK){
         //   if(requestCode== RESUL_SAVE_CONTACT){
            val contact=data?.getSerializableExtra("contact") as Contact
            contactAdapter.addContact(contact,2)
         //   }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
