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
//	        //�إߤ@��ArrayAdapter����A�é�m�U�Կ�檺���e
//	        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,new String[]{"�k","�k"});
//	        //�]�w�U�Կ�檺�˦�
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
	
	//�P�_
		public void test(View v)throws java.sql.SQLException
		{
			
			EditText ed1=(EditText)findViewById(R.id.editText1);  //�b��
			EditText ed2=(EditText)findViewById(R.id.editText2);  //�K�X
			EditText ed3=(EditText)findViewById(R.id.editText3);  //�ϥΪ̼ʺ�
			EditText ed4=(EditText)findViewById(R.id.editText4);  //�ʧO
			EditText ed5=(EditText)findViewById(R.id.editText5);  //�ͤ�
			
			String stringed1=ed1.getText().toString();
			String stringed2=ed2.getText().toString();
			String stringed3=ed3.getText().toString();
			String stringed4=ed4.getText().toString();
			String stringed5=ed5.getText().toString();
			
			String stringA = "�k";
			String sex = "";
			
			if(stringed4.equals(stringA)){
			    System.out.println("�ڿ�J�k��");
			     sex = Integer.toString(1); //�ʧO���k
			}else
			{
			    System.out.println("�ڿ�J�k��");
			     sex = Integer.toString(0); //�ʧO���k
			}
			
			
			String aaa = Integer.toString(1); //1 = �|���v�� (1���|��)
			String bbb = Integer.toString(0); //0 = ���S�v��(�Ҧ��H)		
			
			if ("".equals(ed1.getText().toString().trim()) || "".equals(ed2.getText().toString().trim()) || "".equals(ed3.getText().toString().trim()) || "".equals(ed4.getText().toString().trim()))  
			{
				Toast.makeText(this, "���i�ť�", Toast.LENGTH_SHORT).show();
			}
			else {
			
				String value=stringed1+","+stringed2+","+stringed3+","+sex+","+stringed5+","+aaa+","+bbb;

				dt.dynamic_insert("number","account,password,name,gender,birthday,authority,exposure",value);			
				
				Toast.makeText(this, "���U���\", Toast.LENGTH_SHORT).show();
				
				register.this.finish();		//�^�W��
			}
		}
}