package com.example.sayhello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.sayhello.R;

//import com.example.shulbs.R;

import com.example.sayhello.SQLdatabase;
import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
//import tw.shu.im.MainActivity;

public class set extends Activity {
	private SQLdatabase dt= new SQLdatabase();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set);
		
		Connection con = null;  
		dt.ConnectionHelper();
		
		TextView ed3=(TextView)findViewById(R.id.textView3); //帳號
		String valuenum=ed3.getText().toString();
		
		String content = "";
		
		try {
			content = dt.catchquestion("number","account",valuenum); 
			
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String strresult = content;
		
		TextView text = (TextView) findViewById(R.id.textView2); //暴露權限		
		text.setText(strresult);
		Toast.makeText(this, "抓取暴露權限成功", Toast.LENGTH_SHORT).show();
		
	}
	
	//更改權限
			public void test(View v)throws java.sql.SQLException
			{

				TextView ed3=(TextView)findViewById(R.id.textView3); //帳號
				String valuenum=ed3.getText().toString();
				Spinner sp1 = (Spinner)findViewById(R.id.spinner1);
		
					Toast.makeText(this, "更改權限成功", Toast.LENGTH_SHORT).show();
				
					String [] list = getResources().getStringArray(R.array.expose);
					int index = sp1.getSelectedItemPosition();
					
					String temp = list[index];
					
					dt.update("number","exposure",temp,"account='"+valuenum+"'");
					
					//Toast.makeText(this, list[index], Toast.LENGTH_SHORT).show(); //顯示選到幾號
								
					set.this.finish();		//回上頁
					
			}
	
	
}

