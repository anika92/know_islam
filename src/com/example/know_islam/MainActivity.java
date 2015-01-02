package com.example.know_islam;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import java.util.HashMap;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class MainActivity extends Activity {

	// List view
    private ListView lv;
    Context context;
     private ImageView im;
	 private TextView txtPrayerTimes;
    // Listview Adapter
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    // Search EditText
    EditText inputSearch;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
   
    
    	 
    
 
    @Override
    public void onCreate(Bundle bundle) {

    	final int RQS_1 = 1;
    	
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        
        context=this;
        txtPrayerTimes = (TextView) findViewById(R.id.txtPrayerTimes);
        
       
         
        // Listview Data
        String products[] = {"Islam", "Daily Zikr", "Kalima",  "Hadis",
                                "99 Names of Allah","Salat"
                               };
        int [] prgmImages={R.drawable.images};
       
        
         
        lv = (ListView) findViewById(R.id.list_view);
        im=(ImageView)findViewById(R.drawable.images);
      
        inputSearch = (EditText) findViewById(R.id.inputSearch);
         
        // Adding items to listview
        adapter = new ArrayAdapter(this, R.layout.list_item, R.id.product_name,products);
   
       
        lv.setAdapter(adapter);

               
        lv.setOnItemClickListener(new OnItemClickListener() {
        	  @Override
        	  public void onItemClick(AdapterView<?> parent, View view,
        	    int position, long id) {
        		  String products=(String)parent.getItemAtPosition(position); 
        		  if (position == 0) {
        			  
        		        Intent int0 = new Intent(getApplicationContext(), gnrl.class);
        		        startActivity(int0);
        		   
        		    }

        		    else if (position == 1) {
        		        Intent int1 = new Intent(getApplicationContext(), asf.class);
        		        startActivity(int1);
        		    }
        		    else if (position == 2) {
        		        Intent int2 = new Intent(getApplicationContext(), ThirdActivity.class);
        		        startActivity(int2);
        		    }

        		    else if (position == 3) {
        		        Intent int3 = new Intent(getApplicationContext(),
        		                FourthActivity.class);
        		        startActivity(int3);
        		    }
        		    else if (position == 4) {
        		        Intent int4 = new Intent(getApplicationContext(),
        		                names.class);
        		        startActivity(int4);
        		    }
        		    else if (position == 5) {
        		        Intent int5 = new Intent(getApplicationContext(),
        		                salat.class);
        		        startActivity(int5);
        		    }
        		    
        	  }
        	}); 
        
        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                MainActivity.this.adapter.getFilter().filter(cs);  
            }
             
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub
                 
            }
             
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub                         
            }
        });
       
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
        	 
        AlarmManager[] alarmManager=new AlarmManager[24];
        ArrayList<PendingIntent> intentArray = new ArrayList<PendingIntent>();
     
 
        for (int i = 0; i < offsets.length; i++) {
        	
            Intent intent = new Intent(context, MyAlarmService.class);
         
            PendingIntent pendingIntent = PendingIntent.getService(context,i, intent, 0);
            alarmManager[i] = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager[i].setRepeating(AlarmManager.RTC,System.currentTimeMillis(),offsets[i],pendingIntent);
            
            intentArray.add(pendingIntent);
      }

       
       
    }  
  
	public void getTime(View v) {
    	Intent int4 = new Intent(getApplicationContext(),
                pray.class);
        startActivity(int4);
        // Retrive lat, lng using location API
       
    }
	
}