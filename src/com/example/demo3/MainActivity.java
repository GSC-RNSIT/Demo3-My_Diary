package com.example.demo3;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener {
	
	private Button btn;
	private EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn=(Button) findViewById(R.id.button1);
        txt=(EditText) findViewById(R.id.editText1);
        
        btn.setOnClickListener(this);
    }

			@Override
			public void onClick(View v) {
				String str=txt.getText().toString();
				Intent intent=new Intent();
				PendingIntent pIntent=PendingIntent.getActivity(this, 0, intent, 0);
				Notification noti=new Notification.Builder(this)
				.setTicker("Demo : "+str)
				.setContentTitle("Demo")
				.setContentText(str)
				.setSmallIcon(R.drawable.ic_launcher)
				.setContentIntent(pIntent).getNotification();
				noti.flags=Notification.FLAG_AUTO_CANCEL;
				NotificationManager notiManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				notiManager.notify(0,noti);
				
				startService(new Intent(getBaseContext(),BackgroundService.class));
				
			}
        	
 }

