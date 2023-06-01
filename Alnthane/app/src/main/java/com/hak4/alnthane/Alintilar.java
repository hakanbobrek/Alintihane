package com.hak4.alnthane;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

public class Alintilar extends AppCompatActivity {
    DrawerLayout cekmece;
    private RecyclerView recyclerView;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("ALINTILAR");
    private MyAdapter adapter;
    private ArrayList<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alintilar);
        cekmece=findViewById(R.id.menu_arkaplan);
        recyclerView = findViewById(R.id.RecyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new MyAdapter(this ,list );

        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Model model = dataSnapshot.getValue(Model.class);
                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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

        Intent anasayfa=new Intent(Alintilar.this,Anasayfa.class);
        startActivity(anasayfa);
    }
    public void alintiyatiklama(View view)
    {
       recreate();
    }
    public void kitaparama(View view)
    {
        Intent kitaparar=new Intent(Alintilar.this,Kitaparama.class);
        startActivity(kitaparar);
    }
    public void alintiekleme(View view)
    {
        Intent alintiekleme=new Intent(Alintilar.this,Alintieklemee.class);
        startActivity(alintiekleme);
    }
    public void hakkimizda(View view)
    {
        Intent hakkimizda=new Intent(Alintilar.this,Hakkimizda.class);
        startActivity(hakkimizda);
    }
    public void cıkıstiklama(View view)
    {
        AlertDialog.Builder uyarıpenceresi= new AlertDialog.Builder(Alintilar.this);
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