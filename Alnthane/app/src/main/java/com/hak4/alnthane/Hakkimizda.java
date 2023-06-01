package com.hak4.alnthane;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Hakkimizda extends AppCompatActivity {
ImageView imageView;
Button adres;
    DrawerLayout cekmece;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkimizda);
        imageView=(ImageView) findViewById(R.id.imageView);
        adres=(Button) findViewById(R.id.adres);
        cekmece=findViewById(R.id.menu_arkaplan);
        adres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hakkimizda.this,Adres.class));
            }
        });
    }
    public void  Menuyetiklama(View view)
    {
        cekmeceyiac(cekmece);

    }

    public static void  cekmeceyiac(DrawerLayout cekmece) {
        cekmece.openDrawer(GravityCompat.START);
    }
    public void logoyatıklama(View view)
    {
        cekmeceyikapa(cekmece);
    }

    public static void cekmeceyikapa(DrawerLayout cekmece) {
        if (cekmece.isDrawerOpen(GravityCompat.START))
        {
            cekmece.closeDrawer(GravityCompat.START);
        }
    }
    public void anasayfatiklama(View view)
    {

        Intent alintilar=new Intent(Hakkimizda.this,Anasayfa.class);
        startActivity(alintilar);
    }
    public void alintiyatiklama(View view)
    {
        Intent alintilar=new Intent(Hakkimizda.this,Alintilar.class);
        startActivity(alintilar);
    }
    public void kitaparama(View view)
    {
        Intent kitaparar=new Intent(Hakkimizda.this,Kitaparama.class);
        startActivity(kitaparar);
    }
    public void alintiekleme(View view)
    {
        Intent alintiekleme=new Intent(Hakkimizda.this, Alintieklemee.class);
        startActivity(alintiekleme);
    }
    public void hakkimizda(View view)
    {
        recreate();
    }
    public void cıkıstiklama(View view)
    {
        AlertDialog.Builder uyarıpenceresi= new AlertDialog.Builder(Hakkimizda.this);
        uyarıpenceresi.setTitle("ÇIKIŞ");
        uyarıpenceresi.setMessage("ÇIKIŞ YAPILSIN MI");
        uyarıpenceresi.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();;
                System.exit(0);
            }
        });
        uyarıpenceresi.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        uyarıpenceresi.show();
    }

    @Override
    protected void onPause() {
        cekmeceyikapa(cekmece);
        super.onPause();
    }
}