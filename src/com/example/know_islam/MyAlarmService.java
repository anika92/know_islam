package com.example.know_islam;




import java.util.Calendar;



import android.R.drawable;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
                            
 
public class MyAlarmService extends Service
{
      
  

private NotificationManager mManager;
 
    
 
    @Override
    public void onCreate()
    {
    	super.onCreate();
	    mManager = (NotificationManager) this.getApplicationContext().getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);
	    Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

	    int icon=R.drawable.icon4;
	
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext())
	            .setSmallIcon(icon)
	            .setContentTitle("namaj")
	            .setContentText("namaj")
	            .setSound(R.raw.song1 ); //This sets the sound to play

	    //Display notification
	    mManager.notify(0, mBuilder.build());
	     
    }

    @Override
    public IBinder onBind(Intent arg0)
    {
       // TODO Auto-generated method stub
        return null;
    }

	
}