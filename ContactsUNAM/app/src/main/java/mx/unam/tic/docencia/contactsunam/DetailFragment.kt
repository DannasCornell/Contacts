package mx.unam.tic.docencia.contactsunam


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.cybertch.fragmentsexample.adapters.ContactAdapter
import com.cybertch.fragmentsexample.model.Contact
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.item_contact.*

//DetailFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_CONTACT_PARAM = "contactParam"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var contact: Contact? = null
    private lateinit var contactAdapter: ContactAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            contact = it.getSerializable(ARG_CONTACT_PARAM) as Contact
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextView.text=contact?.name
        lastnameTextView.text=contact?.lastname
    }

    fun remove(){
        contact?.id?.let { contactAdapter.removeContact(it) }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param contact Contact object model.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(contact: Contact) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CONTACT_PARAM,contact)
                }
            }
    }
}