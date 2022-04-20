package com.example.aggricus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MAILGO extends AppCompatActivity {
    EditText To,sujet,mess;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailgo);



    }



    public void clicker(View view) {
        mess=findViewById(R.id.laaa);
        To=findViewById(R.id.laa);
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:?subject=" + mess.getText().toString()+ "&to=" + "Contact@aggricus.com"+"&Body="+To.getText().toString()));


        startActivity(emailIntent);
    }
}

