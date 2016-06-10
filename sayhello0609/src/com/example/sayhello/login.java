package com.example.sayhello;


import com.example.sayhello.SQLdatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends Activity {
	private SQLdatabase dt= new SQLdatabase();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
dt.ConnectionHelper();
		
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		
		
		
		//註冊帳號 - 按鈕
		btn2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					Intent intent = new Intent(login.this, register.class);				
					startActivity(intent);				
				}
				
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	//判斷是否可以登入
		public void test(View v)throws java.sql.SQLException
		{
			
			EditText ed1=(EditText)findViewById(R.id.editText1);
			EditText ed2=(EditText)findViewById(R.id.editText2);
			String str1=getString(R.string.success);
			String str2=getString(R.string.fail);
			
			if ("".equals(ed1.getText().toString().trim()) || "".equals(ed2.getText().toString().trim()))  
			{
				Toast.makeText(this, "不可空白", Toast.LENGTH_SHORT).show();
			}
			else {
				String Valid_col=ed1.getText().toString()+","+ed2.getText().toString();
				boolean b = dt.login(Valid_col); //傳到SQLdatabase.java的函式
		
				if(b)
				{
					Toast.makeText(this, str1, Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(login.this, main.class);
					startActivity(intent);
				}	
				 
				else
					Toast.makeText(this, str2, Toast.LENGTH_SHORT).show();
			}
			
		}
}
