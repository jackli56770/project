package com.example.excuseme;

//import com.example.shulbs.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class main extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		Button btn3 = (Button) findViewById(R.id.button3);
		Button btn4 = (Button) findViewById(R.id.button4);
		Button btn5 = (Button) findViewById(R.id.button5);
		
		btn1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					Intent intent = new Intent(main.this, askquestion.class);				
					startActivity(intent);				
				}
				
			});
		
		btn2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					Intent intent = new Intent(main.this, setting.class);				
					startActivity(intent);				
				}
				
			});
		
		btn3.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					Intent intent = new Intent(main.this, about.class);				
					startActivity(intent);				
				}
				
			});
		
		btn4.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				}
				
			});
		btn5.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(main.this, question.class);				
				startActivity(intent);			
				}
				
			});
		
	}
	
	
	
	
}

