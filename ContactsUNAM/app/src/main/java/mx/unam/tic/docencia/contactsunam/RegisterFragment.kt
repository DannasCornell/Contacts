package mx.unam.tic.docencia.contactsunam


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import com.cybertch.fragmentsexample.model.Contact
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           /* param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)*/
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextInputLayout.editText?.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { //despues de que el texto ha cambiado
                if(!p0.isNullOrEmpty() && (p0!!.length>5)){
                    nameTextInputLayout.isErrorEnabled=false
                }
                else{
                    nameTextInputLayout.isErrorEnabled=true
                    nameTextInputLayout.error="No es correcto el nombre"
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { //antes de que el texto ha cambiado
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { //el texto ha cambiado
            }
        })

        lastNameTextInputLayout.editText?.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { //despues de que el texto ha cambiado
                if(!p0.isNullOrEmpty() && (p0!!.length>5)){
                    lastNameTextInputLayout.isErrorEnabled=false
                }
                else{
                    lastNameTextInputLayout.isErrorEnabled=true
                    lastNameTextInputLayout.error="No es correcto el apellido"
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { //antes de que el texto ha cambiado
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { //el texto ha cambiado
            }
        })
        numberPhoneTextInputLayout.editText?.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { //despues de que el texto ha cambiado
                if(!p0.isNullOrEmpty() && !(p0.length==11) && p0!!.isDigitsOnly()){
                    numberPhoneTextInputLayout.isErrorEnabled=false
                }
                else{
                    numberPhoneTextInputLayout.isErrorEnabled=true
                    numberPhoneTextInputLayout.error="El teléfono tiene que ser de 10 dígitos"
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { //antes de que el texto ha cambiado
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { //el texto ha cambiado
            }
        })

            saveButton.setOnClickListener {
                if(nameTextInputLayout.isErrorEnabled
                    || lastNameTextInputLayout.isErrorEnabled
                    || numberPhoneTextInputLayout.isErrorEnabled){
                    val warningDialog=WarningDialog()
                    warningDialog.show(activity!!.supportFragmentManager, "Warning")
                }else{
                    val contact= Contact(1,nameTextInputLayout.editText?.text.toString(),
                        lastNameTextInputLayout.editText?.text.toString(),
                        numberPhoneTextInputLayout.editText?.text.toString())
                    val intent= Intent()
                    intent.putExtra("contact", contact)
                    activity?.setResult(RESUL_SAVE_CONTACT, intent)
                    activity?.finish()
                }
            }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            RegisterFragment()
    }
}
