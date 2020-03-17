package com.example.myapplication.Rotations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class FragmentRotation extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final  View view;
        Bundle bundle=getArguments();
        int heure=bundle.getInt("Heure");

        view=inflater.inflate(R.layout.layout_rotations_fragment,container,false);
        TextView txtViewHeure=(TextView) view.findViewById(R.id.txtViewHeure);
        txtViewHeure.setText(Integer.toString(heure));

        return view;
       // return super.onCreateView(inflater, container, savedInstanceState);
    }
}
