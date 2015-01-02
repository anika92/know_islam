package com.example.know_islam;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;




  

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
  
 public class pray extends MainActivity {

	 private TextView txtPrayerTimes;
	
	
	    @Override
		public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_time);
	        txtPrayerTimes = (TextView) findViewById(R.id.txtPrayerTimes);
	        // Retrive lat, lng using location API
	        double latitude = 23.7;
	        double longitude = 90.3833;
	        double timezone = (Calendar.getInstance().getTimeZone()
	                .getOffset(Calendar.getInstance().getTimeInMillis()))
	                / (1000 * 60 * 60);
	        PrayTime prayers = new PrayTime();
	 
	        prayers.setTimeFormat(prayers.Time12);
	        prayers.setCalcMethod(prayers.Makkah);
	        prayers.setAsrJuristic(prayers.Shafii);
	        prayers.setAdjustHighLats(prayers.AngleBased);
	        int[] offsets = { 0, 0, 0, 0, 0, 0, 0 }; // {Fajr,Sunrise,Dhuhr,Asr,Sunset,Maghrib,Isha}
	        prayers.tune(offsets);
	 
	        Date now = new Date();
	       

	          

	        Calendar cal = Calendar.getInstance();
	        cal.setTime(now);
	 
	        ArrayList prayerTimes = prayers.getPrayerTimes(cal, latitude,
	                longitude, timezone);
	        ArrayList prayerNames = prayers.getTimeNames();
	 
	        for (int i = 0; i < prayerTimes.size(); i++) {
	            txtPrayerTimes.append("\n" + prayerNames.get(i) + " - "
	                    + prayerTimes.get(i));
	      }
	        
 
	    }
	    
	    

	    	 

	    
     }
  
	
 