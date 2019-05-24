package com.example.appdevtask1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Button r;
    TextView dis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        r=(Button) findViewById(R.id.button3);
        dis=(TextView) findViewById(R.id.textView2);
        Integer res1=getIntent().getIntExtra("res",0);
        if(res1==0)
            dis.setText("better luck next time");
        else dis.setText("good job");
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restart=new Intent(getBaseContext(),MainActivity.class);
                startActivity(restart);
            }
        });
    }
}
