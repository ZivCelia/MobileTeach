package com.example.mobileteach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register);
		EditText tel_edit2 = (EditText)findViewById(R.id.tel_edit2);
		EditText psw_edit2 = (EditText)findViewById(R.id.tel_edit2);
		CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
		Button register = (Button)findViewById(R.id.register);
		TextView registered2 = (TextView)findViewById(R.id.registered2);
		registered2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Register.this,Registered.class);
				startActivity(intent);
				
			}
		});
	}

}
