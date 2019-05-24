package com.example.appdevtask1;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
 Integer x=0;
 EditText a;
 Button b;
 TextView result;
 Integer diff,s,f;
 View bg;
 SharedPreferences st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a=(EditText) findViewById(R.id.editText2);
        result=(TextView) findViewById(R.id.textView);
        bg=(View) findViewById(R.id.screen);
        b=(Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer n1=getIntent().getIntExtra("number",0);
                Integer x2=getIntent().getIntExtra("tries",0);
                Integer a1=Integer.parseInt(a.getText().toString());
                st=getSharedPreferences("stats",MODE_PRIVATE);
                SharedPreferences.Editor myeditor=st.edit();
                Intent final1=new Intent(getBaseContext(),Main3Activity.class);
                if(a1==n1) {
                    result.setText("correct");
                    s=st.getInt("success",0);
                    f=st.getInt("fail",0);
                    if(s==0&&f==0)
                    {
                        myeditor.putInt("success",1);
                        myeditor.putInt("fail",0);
                        myeditor.commit();
                    }
                    else
                    {
                        myeditor.putInt("success",s+1);
                        myeditor.commit();
                    }
                    final1.putExtra("res",1);
                    startActivity(final1);
                }
                else if(a1>n1) {
                    result.setText("higher");
                    diff=a1-n1;
                }
                else {
                    result.setText("lower");
                    diff=n1-a1;
                }
                x++;
                bg.setBackgroundColor(Color.rgb(diff*255/100,255-diff*255/100,0));
                if(x==x2) {
                    s=st.getInt("success",0);
                    f=st.getInt("fail",0);
                    if(s==0&&f==0)
                    {
                        myeditor.putInt("success",0);
                        myeditor.putInt("fail",1);
                        myeditor.commit();
                    }
                    else {
                        myeditor.putInt("fail", f + 1);
                        myeditor.commit();
                    }
                    final1.putExtra("res",0);
                    startActivity(final1);
                }
            }
        });
    }
}
