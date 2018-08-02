package com.example.lenovo2.ornekveritabani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ad;
    private EditText soyad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ad=(EditText)findViewById(R.id.etAd);
        soyad=(EditText)findViewById(R.id.etSoyad);
    }


    public void Dokun(View v){
        switch(v.getId()){


            case R.id.btnKayit:
                String ad_bilgi=ad.getText().toString();
                String soyad_bilgi=soyad.getText().toString();

                try{

                    Veritabani db=new Veritabani(getApplicationContext());

                    long id=db.KayitEkle(ad_bilgi,soyad_bilgi);

                    if(id==-1){
                        Toast.makeText(this, "Kayıt işlemi başarısız !", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Kayıt işlemi başarılı :)", Toast.LENGTH_SHORT).show();
                        ad.setText("");
                        soyad.setText("");
                    }

                }catch (Exception e){
                    Toast.makeText(this, "Hata oluştu:\n"+e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnListele:
                Intent intent=new Intent(getApplicationContext(),Listele.class);
                startActivity(intent);

        }
    }
}
