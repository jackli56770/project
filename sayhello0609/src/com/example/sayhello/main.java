package com.example.sayhello;

//import com.example.shulbs.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class main extends Activity {
	private SQLdatabase dt= new SQLdatabase();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
dt.ConnectionHelper();
		
		Button btn1 = (Button) findViewById(R.id.button1);
		
		//³]©w - «ö¶s
				btn1.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
							Intent intent = new Intent(main.this, set.class);				
							startActivity(intent);				
						}
						
					});
		
	}
	
	
	
}

