package com.example.aggricus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class moreinfos extends AppCompatActivity {
    TextView tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView textView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreinfos);
        textView=findViewById(R.id.ana);
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(moreinfos.this,MAILGO.class);
            startActivity(intent);

        });
        tel=findViewById(R.id.anaaa);
        tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_DIAL);
                emailIntent.setData(Uri.parse("tel: 23 121 302"));

                startActivity(emailIntent);

            }
        });
    }


}