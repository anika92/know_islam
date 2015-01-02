package com.example.know_islam;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import android.app.Service;
public class AlarmReceiver extends BroadcastReceiver
{
      
	
	public void onReceive(Context context, Intent intent)
    {
       Intent service1 = new Intent(context, MyAlarmService.class);
       context.startService(service1);
        
    }

	
}
