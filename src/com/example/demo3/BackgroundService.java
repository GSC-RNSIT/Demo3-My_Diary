package com.example.demo3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class BackgroundService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags,int startId){
		Toast.makeText(this, "Demo background service", Toast.LENGTH_LONG).show();
		return START_STICKY;
	}

}
