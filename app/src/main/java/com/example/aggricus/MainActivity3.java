package com.example.aggricus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Button login;
    EditText mail,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textview =findViewById(R.id.boo);
        textview.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity3.this,Connection.class);
            startActivity(intent);


        });


    login=findViewById(R.id.but);
    mail=findViewById(R.id.texta);
    pass=findViewById(R.id.textaa);
        login.setOnClickListener(v -> {
        if (TextUtils.isEmpty(mail.getText().toString()) || TextUtils.isEmpty(pass.getText().toString()))
        {
            Toast.makeText(MainActivity3.this,"Champs vides , veuillez les remplir !", Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(MainActivity3.this,"Vous etes Connectez maintenant , Bienvenu utilisateur :"+mail.getText(),Toast.LENGTH_LONG).show();

            startActivity(new Intent(MainActivity3.this,verify.class));
        }
    }


        );

}






}