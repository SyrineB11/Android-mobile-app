package com.example.aggricus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Connection extends AppCompatActivity {
    Button login ;
    EditText mail,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        TextView textview =findViewById(R.id.bella);

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Connection.this,MainActivity3.class);
                startActivity(intent);

            }
    }); login=findViewById(R.id.but);
        mail=findViewById(R.id.texta);
        pass=findViewById(R.id.textaa);
        login.setOnClickListener(v -> {
                    if (TextUtils.isEmpty(mail.getText().toString()) || TextUtils.isEmpty(pass.getText().toString()))
                    {
                        Toast.makeText(Connection.this,"Champs vides , veuillez les remplir !", Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                        Toast.makeText(Connection.this,"Vous etes Connectez maintenant , Bienvenu utilisateur :"+mail.getText(),Toast.LENGTH_LONG).show();

                                startActivity(new Intent(Connection.this,verify.class));




                    }
                }


        );

    }}
