package com.example.iflyvoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by asus-pc on 2016/11/3.
 */
public class second extends Activity {
      private Button button5;
      private Button button6;
      private Button button7;
       private Button button8;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getTitle();
        button5=(Button)findViewById(R.id.biyinbtn);
        button6=(Button)findViewById(R.id.button6);
        button7=(Button)findViewById(R.id.button7);
        button8=(Button)findViewById(R.id.button8);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(second.this,four.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","5");
                intent.putExtras(bundle);
                second.this.startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(second.this,four.class);
                Bundle bundle =  new Bundle();
                bundle.putString("name","6");
                intent.putExtras(bundle);
                second.this.startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(second.this,four.class);
                Bundle bundle =  new Bundle();
                bundle.putString("name","7");
                intent.putExtras(bundle);
                second.this.startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(second.this,four.class);
                Bundle bundle =  new Bundle();
                bundle.putString("name","8");
                intent.putExtras(bundle);
                second.this.startActivity(intent);
            }
        });

    }

}
