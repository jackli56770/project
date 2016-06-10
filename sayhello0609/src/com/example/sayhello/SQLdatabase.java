package com.example.sayhello;

import java.sql.*;

import android.database.SQLException;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

public  class SQLdatabase {
	
		//資料庫連線
        Connection con = null;  
	   public Connection ConnectionHelper(){
		   StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
	                .permitAll().build();
	        StrictMode.setThreadPolicy(policy);
            try {  
                Class.forName( "net.sourceforge.jtds.jdbc.Driver");  
                System.out.println("加载驅動程序ok"); 
               //con = DriverManager.getConnection("jdbc:jtds:sqlserver://120.126.146.91:1433/ntfd119, UserName, Password"); 
              con = DriverManager.getConnection("jdbc:jtds:sqlserver://120.126.146.91;"+ "databaseName=sayhello;charset=utf8;user=soda;password=soda123;");
                System.out.println("連接OK"); 
             //   con.close();
           //   testConnection();
            } catch (ClassNotFoundException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
                System.out.println("ClassNotFoundException:"+e.getMessage());  
            }catch (java.sql.SQLException e) {
           	 System.out.println("java.sql.SQLException:"+e.getMessage());  
				e.printStackTrace();
			} catch (SQLException e) {  
            	 System.out.println("sql:"+e.getMessage());  
                    e.printStackTrace();  
            }  catch (Exception e) {
           	 System.out.println("Exception:"+e.getMessage());  
				e.printStackTrace();
			}
			return con;  
              
          
        }

	// 查詢單一表格單ㄧ欄位
	   public String catchquestion(String table,String title,String valuenum) throws java.sql.SQLException { 
      	 	String SqlColumn="password,birthday,exposure";
      	 	String[] cArray = SqlColumn.split(",");
      	 	String content="";
      	 	
		   try {
               Statement stmt = con.createStatement();    
      //         ResultSet rs = stmt.executeQuery("SELECT * FROM number WHERE account = 'sayhello'"); //寫死的語法
               ResultSet rs = stmt.executeQuery("SELECT * FROM "+ table + " WHERE "+ title + " ='"+ valuenum + "'"); //寫活的語法
               
               rs.next();
               System.out.println("debug是"+rs.getRow()+rs.getString(cArray[0].toString())+rs.getString(cArray[1].toString())+rs.getString(cArray[2].toString()));
               
              content  = rs.getString(cArray[2].toString());
              System.out.println(content.toString());
              rs.close();    
              stmt.close();
              
   		   	  return(content);
   		   
		   } catch (SQLException e) {    
              System.out.println(e.getMessage().toString());    
		   } finally {    
              if (con != null)    
                  try {    
                      //con.close();    
                  } catch (SQLException e) {    
                  }             
		   }
		return content;
	   }
	   
	   
	   //新增
	   public void insert(String table,int SqlColumn,String value) throws java.sql.SQLException { 
		   String value_str="?";
		   for(int i=1;i<SqlColumn;i++)
		   {
			   value_str+=",?";
		   }
		   String sqlstmt=" insert into "+table+" values("+value_str+")";
		   String[] aArray = value.split(";");//一列一列資料
		   String[] vArray ;
		   PreparedStatement stmt = con.prepareStatement(sqlstmt); 	   
		   for(int i=0;i<aArray.length;i++)
		   { vArray= aArray[i].split(",");//每個欄位中的資料
			   for(int j=1;j<=SqlColumn;j++){
				   stmt.setString(j,vArray[j-1].toString()); 
			   }
		   stmt.executeUpdate();  
		   }

	   }
	   
	   //動態新增
	   public void dynamic_insert(String table,String SqlColumn,String value) throws java.sql.SQLException { 
	   		   String[] cArray = SqlColumn.split(",");
	   		   String value_str="?";
	   		   for(int i=1;i<cArray.length;i++)
	   		   {
	   			   value_str+=",?";
	   		   }
	   		   String sqlstmt=" insert into "+table+"("+SqlColumn+")"+" values("+value_str+")";
	   		   String[] aArray = value.split(";");
	   		   String[] vArray ;
	   		   PreparedStatement stmt = con.prepareStatement(sqlstmt); 
	   		   for(int i=0;i<aArray.length;i++)
	   		   { vArray= aArray[i].split(",");
	   			   for(int j=1;j<=cArray.length;j++){
	   				   stmt.setString(j,vArray[j-1].toString()); 
	   			   }
	   		   stmt.executeUpdate();  
	   		   }

	   	   }
	   
	   //查詢
	   public String select(String select_str,String SqlColumn_str) throws java.sql.SQLException { 
	           	 String[] aArray = SqlColumn_str.split(",");  
	           String get_str="";
	           	 boolean a=false;
	               try {      
	                   Statement stmt = con.createStatement();    
	                   ResultSet rs = stmt.executeQuery(select_str);
	                   while (rs.next()) {//<CODE>ResultSet</CODE>最初指向第一行     
	              for(int i=0;i<aArray.length;i++)
	              {
	       			   if(aArray.length==1)
	       			   {
	       				   get_str+=rs.getString(aArray[i]);
	       			   }else if (i<aArray.length-1)
	       			   {
	       				   get_str+=rs.getString(aArray[i])+",";
	       			   }
	       			   else if (i==aArray.length-1)
	       			   {
	       				   get_str+=rs.getString(aArray[i]);
	       			   }
	              }
	              get_str+=";";
	                   }  	
	                   rs.close();    
	                   stmt.close();    
	               } catch (SQLException e) {    
	                   System.out.println(e.getMessage().toString());    
	               } finally {    
	                   if (con != null)    
	                       try {    
	                           //con.close();    
	                       } catch (SQLException e) {    
	                       } 
	                  
	               }
	   		return get_str;
	           }

	   	   
	 //修改
	   public void update(String table,String SqlColumn,String value,String where_value) throws java.sql.SQLException { 
	   		   String[] cArray = SqlColumn.split(","); 
	   		   String[] aArray = value.split(",");
	   		  // String value_str="?";
	   		   String set_value="";
	   		  
	   			   
	   		   for(int i=0;i<cArray.length;i++)
	   		   {
	   			   if(cArray.length==1)
	   			   {
	   				   set_value+=cArray[i]+"="+aArray[i];
	   			   }else if (i<cArray.length-1)
	   			   {
	   				   set_value+=cArray[i]+"="+aArray[i]+",";
	   			   }
	   			   else if (i==cArray.length-1)
	   			   {
	   				   set_value+=cArray[i]+"="+aArray[i];
	   			   }
	   		   
	   		   }
	   		   String sqlstmt="update "+table+" set "+set_value+ " where "+where_value;
	   		  // sqlstmt="update number set name='會員update' where account='dytest'";
	   		   System.out.println(sqlstmt);	
	   		   PreparedStatement stmt = con.prepareStatement(sqlstmt);  
	   		   stmt.executeUpdate();  
	   		 /*  for(int i=0;i<aArray.length;i++)
	   		   { vArray= aArray[i].split(",");
	   			   for(int j=1;j<=cArray.length;j++){
	   				   stmt.setString(j,vArray[j-1].toString()); 
	   			   }
	   		   }*/

	   	   }
       
	   //比對帳號/密碼
        public boolean login(String Valid_col) throws java.sql.SQLException { 
        	 String SqlColumn="account,password";
        	 String[] cArray = SqlColumn.split(",");
        	 String[] vArray = Valid_col.split(",");  
        	 boolean a=false;
            try {      
                Statement stmt = con.createStatement();    
                ResultSet rs = stmt.executeQuery("SELECT * FROM number");
                while (rs.next()) {//<CODE>ResultSet</CODE>最初指向第一行     
                   if(rs.getString(cArray[0].toString()).compareTo(vArray[0].toString())==0 && rs.getString(cArray[1].toString()).compareTo(vArray[1].toString())==0)
                		{//rs.getString(cArray[0].toString())==vArray[0].toString()
                		   a=true;
                		   rs.close();    
                           stmt.close(); 
                           return a;
                		} 
                }  	
                rs.close();    
                stmt.close();    
            } catch (SQLException e) {    
                System.out.println(e.getMessage().toString());    
            } finally {    
                if (con != null)    
                    try {    
                        //con.close();    
                    } catch (SQLException e) {    
                    } 
               
            }
        
		return a;
        }
    

}
