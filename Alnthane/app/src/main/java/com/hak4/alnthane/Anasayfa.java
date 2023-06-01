package com.hak4.alnthane;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Anasayfa extends AppCompatActivity {
    DrawerLayout cekmece;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cekmece=findViewById(R.id.menu_arkaplan);
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
        recreate();
    }
    public void alintiyatiklama(View view)
    {
        Intent alintilar=new Intent(Anasayfa.this,Alintilar.class);
        startActivity(alintilar);
    }
    public void kitaparama(View view)
    {
        Intent kitaparar=new Intent(Anasayfa.this,Kitaparama.class);
        startActivity(kitaparar);
    }
    public void alintiekleme(View view)
    {
        Intent alintiekleme=new Intent(Anasayfa.this, Alintieklemee.class);
        startActivity(alintiekleme);
    }
    public void hakkimizda(View view)
    {
        Intent hakkimizda=new Intent(Anasayfa.this,Hakkimizda.class);
        startActivity(hakkimizda);
    }
    public void cıkıstiklama(View view)
    {
        AlertDialog.Builder uyarıpenceresi= new AlertDialog.Builder(Anasayfa.this);
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