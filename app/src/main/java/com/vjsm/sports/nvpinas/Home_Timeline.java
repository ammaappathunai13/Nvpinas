package com.vjsm.sports.nvpinas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Home_Timeline extends Fragment {

    private EditText writesome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.home,container,false);

        writesome=(EditText)v.findViewById(R.id.uploaddec);

        writesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s=new Intent(getActivity(),Timeline_Upload.class);
                startActivity(s);
            }
        });


        return v;
    }
}
