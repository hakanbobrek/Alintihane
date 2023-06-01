package com.hak4.alnthane;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kitaparama extends AppCompatActivity {
    DrawerLayout cekmece;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitaparama);
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

        Intent anasayfa=new Intent(Kitaparama.this,Anasayfa.class);
        startActivity(anasayfa);
    }
    public void alintiyatiklama(View view)
    {

        Intent alintir=new Intent(Kitaparama.this,Alintilar.class);
        startActivity(alintir);
    }
    public void kitaparama(View view)
    {
        recreate();
    }
    public void alintiekleme(View view)
    {
        Intent alintiekleme=new Intent(Kitaparama.this,Alintieklemee.class);
        startActivity(alintiekleme);
    }
    public void hakkimizda(View view)
    {
        Intent hakkimizda=new Intent(Kitaparama.this,Hakkimizda.class);
        startActivity(hakkimizda);
    }
    public void cıkıstiklama(View view)
    {
        AlertDialog.Builder uyarıpenceresi= new AlertDialog.Builder(Kitaparama.this);
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