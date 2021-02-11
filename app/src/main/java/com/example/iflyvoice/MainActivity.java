package com.example.iflyvoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;


public class MainActivity extends Activity {

	private Button button;
	private Button button2;
	private Button button3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SpeechUtility.createUtility(this, SpeechConstant.APPID + "=58122932");

		setContentView(R.layout.activity_main);
		button = (Button)findViewById(R.id.zitestbutton);
		button2 = (Button)findViewById(R.id.citestbtn);
		button3 = (Button)findViewById(R.id.button3);

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(MainActivity.this,second.class);
				MainActivity.this.startActivity(intent);

			}
		});

		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(MainActivity.this,third.class);
				MainActivity.this.startActivity(intent);


			}
		});


		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,developer.class);
				MainActivity.this.startActivity(intent);
			}
		});



	}
}
