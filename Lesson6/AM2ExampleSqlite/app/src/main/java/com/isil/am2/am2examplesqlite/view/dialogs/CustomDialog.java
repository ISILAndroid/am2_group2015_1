package com.isil.am2.am2examplesqlite.view.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import com.isil.am2.am2examplesqlite.R;

/**
 * Created by emedinaa on 21/04/2015.
 */
public class CustomDialog {

    public static Dialog buildSimpleDialog(final Context
                                                   context,final OnCustomDialogListener listener, String title, String message,final Object object)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(context.getResources().getString(R.string.s_dialog_acepted), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        if (listener != null)
                            listener.onDialogAccepted(object);
                    }
                }).setNegativeButton(context.getResources().getString(R.string.s_dialog_cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        if (listener != null)
                            listener.onDialogCancel(object);
                    }
                });

        return  builder.create();
    }
}
