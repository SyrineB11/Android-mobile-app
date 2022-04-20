package com.example.aggricus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class who_is_aggricus extends AppCompatActivity {
     TextView textView;
     EditText To,sujet,mess;
     Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tel;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_who_is_aggricus);
        Button btn=findViewById(R.id.batoun);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(who_is_aggricus.this,moreinfos.class);
                startActivity(intent);
            }
        });
        Toolbar toolbar = findViewById(R.id.tt);
        setSupportActionBar(toolbar);

        tel=findViewById(R.id.anaaa);
        textView=findViewById(R.id.ana);
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(who_is_aggricus.this,MAILGO.class);
            startActivity(intent);


        });
        tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_DIAL);
                emailIntent.setData(Uri.parse("tel: 23 121 302"));

                startActivity(emailIntent);

            }
        });

        TextView tv = findViewById(R.id.numbbbbbbbb);
        Animation anim = new AlphaAnimation(0.0f,1.0f);
        anim.setDuration(500);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        tv.startAnimation(anim);





    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.examplemenu, menu);
        return  true;
    }}