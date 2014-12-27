package com.example.know_islam;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class salat extends MainActivity {
	@Override
	public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.webviewpage);
	            WebView wbView = (WebView) findViewById(R.id.WebView);
	            wbView.getSettings().setJavaScriptEnabled(true); 
	            wbView.loadUrl("file:///android_asset/salat.html");
	            WebSettings settings = wbView.getSettings();
	            settings.setUseWideViewPort(true);
	   }
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==android.R.id.home){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

}
