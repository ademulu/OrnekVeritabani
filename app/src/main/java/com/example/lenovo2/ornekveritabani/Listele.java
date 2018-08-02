package com.example.lenovo2.ornekveritabani;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Listele extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);

        tv=(TextView)findViewById(R.id.tvListe);

        try{
            Veritabani db=new Veritabani(getApplicationContext());

            List<String> bilgiList=new ArrayList<String>();

            bilgiList=db.KayitListele();

            StringBuilder sb=new StringBuilder();

            for (String st:bilgiList){
                sb.append(st+"\n");
            }

            tv.setText(sb);
        }catch (Exception e){
            Toast.makeText(this, "Listelemede hata var !"+e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }




    }

}
