package com.vjsm.sports.nvpinas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Home_Bottom_Fragment extends Fragment {
    String language,logouts;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private AlertDialog.Builder builder;
    private TextView mTextMessage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_home__bottom__fragment,container,false);


        builder=new AlertDialog.Builder(getContext());
        builder.setTitle("Do You want Logout ?");

        if (getArguments()!=null){
            Bundle b=this.getArguments();

            logouts=b.getString("logout");
        }
        if (logouts!=null) {

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    sharedPreferences = getActivity().getSharedPreferences("com.vjsm.sports.nvpinas", Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.clear().commit();
                    Intent sss = new Intent(getContext(), Login_Page.class);
                    startActivity(sss);
                    ActivityCompat.finishAffinity(getActivity());


                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else{

        }



            BottomNavigationView navigation = (BottomNavigationView) v.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Fragment fragment=new Home_Timeline();
        loadFragment(fragment);

        return v;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
           getActivity(). getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.con, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Fragment fragment=new Home_Timeline();
                    loadFragment(fragment);
                    return true;
                case R.id.nvpvideo:
                    Fragment fragment1=new NVP_vid();
                    loadFragment(fragment1);
                    return true;
                case R.id.weeklyvideo:
                    Fragment fragment2=new Weekly_vid();
                    loadFragment(fragment2);
                    return true;
            }
            return false;
        }
    };

}
