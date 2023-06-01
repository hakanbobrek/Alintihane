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

public class Kaydol extends AppCompatActivity {
    EditText KytEmail,KytParola,KytParolaTekrar;
    Button KytGiris,KytKayit;
    TextView KytMesaj;
    String EmailTut;
    String SifreTut;
    FirebaseAuth Yetki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);
        Yetki=FirebaseAuth.getInstance();
       KytEmail =(EditText)findViewById(R.id.kyt_email);
        KytParola=(EditText) findViewById(R.id.kyt_parola);
        KytParolaTekrar=(EditText) findViewById(R.id.kyt_parolatekrar);
        KytKayit=(Button) findViewById(R.id.kyt_kayit);
        KytGiris=(Button) findViewById(R.id.Kyt_giris);
        KytMesaj=(TextView) findViewById(R.id.kyt_mesaj);

        KytKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (KytEmail.getText().toString().equals("")||KytParola.getText().toString().equals("")||KytParolaTekrar.getText().toString().equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Kaydol.this);
                    builder.setTitle("Alıntıhanem");
                    builder.setMessage("KAYIT EKRANINDA BOŞLUK BIRAKMAYINIZ!!!");
                    builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.show();
                }
                else {
                    if (KytParola.getText().toString().equals(KytParolaTekrar.getText().toString()))
                    {EmailTut=KytEmail.getText().toString();
                        SifreTut=KytParola.getText().toString();
                        kaydol();
                    }
                    else{
                        KytMesaj.setText("ŞİFRELER AYNI DEĞİL");
                        AlertDialog.Builder builder = new AlertDialog.Builder(Kaydol.this);
                        builder.setTitle("Alıntıhanem");
                        builder.setMessage("ŞİFRELER AYNI DEĞİL!!!");
                        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        builder.show();
                    }
                }

            }
        });
        KytGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Kaydol.this,Giris.class));
            }
        });
    }
    private void kaydol()
    {
        Yetki.createUserWithEmailAndPassword(EmailTut,SifreTut).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> kaydetmegorevi) {
                if (kaydetmegorevi.isSuccessful())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Kaydol.this);
                    builder.setTitle("Alıntıhanem");
                    builder.setMessage("KAYIT BAŞARILI!!!");
                    builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.show();
                    KytMesaj.setText("KAYIT BAŞARILI");

                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Kaydol.this);
                builder.setTitle("Alıntıhanem");
                builder.setMessage("KAYIT BAŞARISIZ!!!");
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