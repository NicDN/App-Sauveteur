package com.example.myapplication.Configuration;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.myapplication.R;

public class DialogAjouterEmployee extends AppCompatDialogFragment {

    private EditText editTextNom;
    private Spinner spinnerHeuresTravail;
    private Context context_;

    private ConfigurationActivity configurationActivity;


    public DialogAjouterEmployee(Context context) {
        context_ = context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layou_dialog_ajout_employee, null);

        builder.setView(view).setTitle("Ajout d'un employée").setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nom=editTextNom.getText().toString();
                String heuresTravail=spinnerHeuresTravail.getSelectedItem().toString();

                ((ConfigurationActivity)getActivity()).updateRecyclerView(nom,heuresTravail);
                //configurationActivity.updateRecyclerView(nom, heuresTravail);

                //Implémenter l'ajout d'un employee dans un cardview
            }
        });

        initSpinner(view);

        editTextNom = view.findViewById(R.id.editText_nom);

        return builder.create();
    }

    public interface DialogListener{

    }

    public void initSpinner(View view) {
        spinnerHeuresTravail = view.findViewById(R.id.spinner_heures_travail);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context_, R.array.heures_travail, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHeuresTravail.setAdapter(adapter);
    }

}
