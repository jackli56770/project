package com.example.sayhello;

import com.example.sayhello.SQLdatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.sayhello.register;
import com.example.sayhello.R;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class register extends Activity {
	private SQLdatabase dt= new SQLdatabase();
	
	Button bt1;
	Spinner sp2;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		dt.ConnectionHelper();
		
		
//		 Spinner spinner = (Spinner) findViewById(R.id.Spinner2);
//	        //建立一個ArrayAdapter物件，並放置下拉選單的內容
//	        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,new String[]{"男","女"});
//	        //設定下拉選單的樣式
//	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//	        spinner.setAdapter(adapter);
		
		
	}
	
//		View.OnClickListener listener = new OnClickListener() {
		
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			String [] list = getResources().getStringArray(R.array.sex);
//			int index = sp2.getSelectedItemPosition();
//			Toast.makeText(register.this, list[index], Toast.LENGTH_SHORT).show();
//		}
//	};
	
	//判斷
		public void test(View v)throws java.sql.SQLException
		{
			
			EditText ed1=(EditText)findViewById(R.id.editText1);  //帳號
			EditText ed2=(EditText)findViewById(R.id.editText2);  //密碼
			EditText ed3=(EditText)findViewById(R.id.editText3);  //使用者暱稱
			EditText ed4=(EditText)findViewById(R.id.editText4);  //性別
			EditText ed5=(EditText)findViewById(R.id.editText5);  //生日
			
			String stringed1=ed1.getText().toString();
			String stringed2=ed2.getText().toString();
			String stringed3=ed3.getText().toString();
			String stringed4=ed4.getText().toString();
			String stringed5=ed5.getText().toString();
			
			String stringA = "男";
			String sex = "";
			
			if(stringed4.equals(stringA)){
			    System.out.println("我輸入男生");
			     sex = Integer.toString(1); //性別為男
			}else
			{
			    System.out.println("我輸入女生");
			     sex = Integer.toString(0); //性別為女
			}
			
			
			String aaa = Integer.toString(1); //1 = 會員權限 (1為會員)
			String bbb = Integer.toString(0); //0 = 暴露權限(所有人)		
			
			if ("".equals(ed1.getText().toString().trim()) || "".equals(ed2.getText().toString().trim()) || "".equals(ed3.getText().toString().trim()) || "".equals(ed4.getText().toString().trim()))  
			{
				Toast.makeText(this, "不可空白", Toast.LENGTH_SHORT).show();
			}
			else {
			
				String value=stringed1+","+stringed2+","+stringed3+","+sex+","+stringed5+","+aaa+","+bbb;

				dt.dynamic_insert("number","account,password,name,gender,birthday,authority,exposure",value);			
				
				Toast.makeText(this, "註冊成功", Toast.LENGTH_SHORT).show();
				
				register.this.finish();		//回上頁
			}
		}
}