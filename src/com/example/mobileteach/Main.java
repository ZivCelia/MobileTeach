package com.example.mobileteach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		Button btn=(Button)findViewById(R.id.btn);

	       btn.setOnClickListener(new OnClickListener() {

	              

	               @Override

	               public void onClick(View v) {

	                       sqlCon();                          

	               }

	        });   

	    }

	 

	    private void mSetText(String str){

	     TextView txt=(TextView)findViewById(R.id.txt);

	     txt.setText(str);

	    }

	   

	    private void sqlCon(){

	    try {

	        Class.forName("com.mysql.jdbc.Driver");  

	        } catch(Exception e) {

	               e.printStackTrace();

	        }

	        try {

	               //jdbc:mysql://AndroidĬ�ϵ�������IP 10.0.2.2��������Ե�IP

	           String url="jdbc:mysql://192.168.191.1:3306/test?user=Ziv&password=123456&useUnicode=true&characterEncoding=UTF-8";//�������ݿ����

	           Connection conn= (Connection) DriverManager.getConnection(url); //�������ݿ�

	           Statement stmt=(Statement)conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

	           String sql="select * from user";//��ѯmanager�����

	           ResultSet rs=stmt.executeQuery(sql);//ִ�в�ѯ

	            StringBuilder str=new StringBuilder();

	           while(rs.next()){

	            str.append(rs.getString(1)+"\n");  

	            }

	            mSetText(str.toString());

	           rs.close();   

	           stmt.close();

	           conn.close();     

	        } catch(Exception e) {

	               e.printStackTrace();

	        }

	}

	



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/**
	 * �����ؼ�֮��ĵ���
	 */
	//���õĴ���
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (((keyCode == KeyEvent.KEYCODE_BACK) ||
(keyCode == KeyEvent.KEYCODE_HOME))
&& event.getRepeatCount() == 0) {
               dialog_Exit(Main.this);
        }
        return false;
       
        //end onKeyDown
 }

 public static void dialog_Exit(Context context) {
  AlertDialog.Builder builder = new Builder(context);
  builder.setMessage("ȷ��Ҫ�˳���?");
  builder.setTitle("��ʾ");
  builder.setIcon(android.R.drawable.ic_dialog_alert);
  builder.setPositiveButton("ȷ��",
          new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
                  android.os.Process.killProcess(android.os.Process
                          .myPid());
              }
          });
 
  builder.setNegativeButton("ȡ��",
          new android.content.DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
              }
          });
 
  builder.create().show();
}
}