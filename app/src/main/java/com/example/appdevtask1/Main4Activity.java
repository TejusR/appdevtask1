package com.example.appdevtask1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
TextView s1,f1;
Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        s1=(TextView) findViewById(R.id.textView8);
        f1=(TextView) findViewById(R.id.textView10);
        home=(Button) findViewById(R.id.button5);
        SharedPreferences statistics=getSharedPreferences("stats",MODE_PRIVATE);
        Integer s=statistics.getInt("success",0);
        Integer f=statistics.getInt("fail",0);
        s1.setText(Integer.toString(s));
        f1.setText(Integer.toString(f));
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hm=new Intent(Main4Activity.this,MainActivity.class);
                startActivity(hm);
            }
        });
    }
}
