package com.example.iflyvoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by asus-pc on 2016/11/3.
 */
public class third extends Activity {

    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_test);
        button9=(Button)findViewById(R.id.button9);
        button10=(Button)findViewById(R.id.button10);
        button11=(Button)findViewById(R.id.button11);
        button12=(Button)findViewById(R.id.button12);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(third.this,four.class);
                Bundle bundle =  new Bundle();
                bundle.putString("name","9");
                intent.putExtras(bundle);
                third.this.startActivity(intent);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(third.this,four.class);
                Bundle bundle =  new Bundle();
                bundle.putString("name","10");
                intent.putExtras(bundle);
                third.this.startActivity(intent);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(third.this,four.class);
                Bundle bundle =  new Bundle();
                bundle.putString("name","11");
                intent.putExtras(bundle);
                third.this.startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(third.this,four.class);
                Bundle bundle =  new Bundle();
                bundle.putString("name","12");
                intent.putExtras(bundle);
                third.this.startActivity(intent);
            }
        });



    }
}
