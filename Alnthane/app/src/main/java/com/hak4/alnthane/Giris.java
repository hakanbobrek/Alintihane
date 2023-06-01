package com.hak4.alnthane;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Giris extends AppCompatActivity {

   EditText Grsemail,Grssifre;
   Button Grskaydol,Grsgiris;
   String emailtut;
   String sifretut;
   FirebaseAuth yetki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        yetki=FirebaseAuth.getInstance();
        Grsemail=(EditText) findViewById(R.id.Grs_mail);
        Grssifre=(EditText) findViewById(R.id.Grs_parola);
        Grskaydol=(Button) findViewById(R.id.Grs_kaydol);
        Grsgiris=(Button) findViewById(R.id.Grs_giris);

     Grsgiris.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if (Grsemail.getText().toString().equals("")||Grssifre.getText().toString().equals(""))
             {
                 AlertDialog.Builder builder = new AlertDialog.Builder(Giris.this);
                 builder.setTitle("Alıntıhanem");
                 builder.setMessage("GİRİŞ EKRANINDA BOŞLUK BIRAKMAYINIZ!!!");
                 builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                     }
                 });
                 builder.show();
             }
             else {
                 emailtut=Grsemail.getText().toString();
                 sifretut=Grssifre.getText().toString();
                 girisyap();
             }

         }
     });
        Grskaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Giris.this,Kaydol.class));
            }
        });
    }
    private void girisyap()
    {
        yetki.signInWithEmailAndPassword(emailtut,sifretut).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> girisgorevi) {
                if (girisgorevi.isSuccessful())
                {
                    startActivity(new Intent(Giris.this,Anasayfa.class));
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Giris.this);
                builder.setTitle("Alıntıhanem");
                builder.setMessage("HATALI BİLGİ GİRİŞİ");
                builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();

            }
        });
    }
}