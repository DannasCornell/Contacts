package mx.unam.tic.docencia.contactsunam

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class WarningDialog : DialogFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable=false
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = activity?.let { AlertDialog.Builder(it) }
        builder?.setMessage("Ha ocurrido un error")?.setTitle("Aviso")
        builder?.setPositiveButton("OK"
        ) { p0, p1 -> p0?.dismiss() } //convertido a lambda
        builder?.setCancelable(false)

        return builder!!.create()
        //return super.onCreateDialog(savedInstanceState)
    }

 /*  Sin conversión a Lambda
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = activity?.let { AlertDialog.Builder(it) }
        builder?.setMessage("Ha ocurrido un error")?.setTitle("Aviso")
            builder?.setPositiveButton("OK", object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    p0?.dismiss()
                }
            })
        return builder!!.create()
    }*/
}