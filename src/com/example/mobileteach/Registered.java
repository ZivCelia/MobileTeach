package com.example.mobileteach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class Registered extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.registered);
		Button registered1 = (Button)findViewById(R.id.registered1);
		registered1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 点击立即注册后产生的事件
				
			}
		});
		}
	@Override
	public void onBackPressed(){
		Intent intent = new Intent(Registered.this,Register.class);
		startActivity(intent);
	}
	

}
