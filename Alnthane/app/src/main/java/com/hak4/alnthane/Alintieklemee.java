package com.hak4.alnthane;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;

public class Alintieklemee extends AppCompatActivity {
    DrawerLayout cekmece;
    private EditText myazar , mkitap , malinti;
    private Button btnlistele, btnalintiekle ;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("ALINTILAR");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alintieklemee);
        cekmece=findViewById(R.id.menu_arkaplan);
        myazar = findViewById(R.id.myazar);
        mkitap = findViewById(R.id.mkitap);
        malinti = findViewById(R.id.malinti);
        btnalintiekle = findViewById(R.id.btnalintiekle);
        btnlistele = findViewById(R.id.btnlistele);
        btnalintiekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yazar = myazar.getText().toString();
                String kitap = mkitap.getText().toString();
                String alinti = malinti.getText().toString();

                HashMap<String , String> userMap = new HashMap<>();

                userMap.put("yazar" , yazar);
                userMap.put("kitapismi" , kitap);
                userMap.put("alinti" , alinti);

                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Alintieklemee.this, "KAYIT BAŞARILI", Toast.LENGTH_SHORT).show();
                        malinti.setText("");
                    }
                });
            }
        });
        btnlistele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alintieklemee.this , Alintilar.class));
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

        Intent anasayfa=new Intent(Alintieklemee.this,Anasayfa.class);
        startActivity(anasayfa);
    }
    public void alintiyatiklama(View view)
    {
        Intent alintilar=new Intent(Alintieklemee.this,Alintilar.class);
        startActivity(alintilar);
    }
    public void kitaparama(View view)
    {
        Intent kitaparar=new Intent(Alintieklemee.this,Kitaparama.class);
        startActivity(kitaparar);
    }
    public void alintiekleme(View view)
    {
       recreate();
    }
    public void hakkimizda(View view)
    {
        Intent hakkimizda=new Intent(Alintieklemee.this,Hakkimizda.class);
        startActivity(hakkimizda);
    }
    public void cıkıstiklama(View view)
    {
        AlertDialog.Builder uyarıpenceresi= new AlertDialog.Builder(Alintieklemee.this);
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