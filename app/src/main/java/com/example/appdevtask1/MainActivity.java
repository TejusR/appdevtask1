package com.example.appdevtask1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText age, max_guess;
    Button submit;
    Button stat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        age=(EditText) findViewById(R.id.editText);
        max_guess=(EditText) findViewById(R.id.editText3);
        submit=(Button) findViewById(R.id.button);
        stat=(Button) findViewById(R.id.button4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num=Integer.parseInt(age.getText().toString());
                Intent myintent=new Intent(MainActivity.this,Main2Activity.class);
                myintent.putExtra("number",num);
                myintent.putExtra("tries",Integer.parseInt(max_guess.getText().toString()));
                startActivity(myintent);
            }
        });
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data=new Intent(MainActivity.this,Main4Activity.class);
                startActivity(data);
            }
        });
    }

}


