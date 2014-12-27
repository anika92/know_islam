package com.example.know_islam;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class asf extends MainActivity {

	@Override
	public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.webviewpage);
	            WebView wbView = (WebView) findViewById(R.id.WebView);
	            wbView.getSettings().setJavaScriptEnabled(true); 
	            wbView.setWebViewClient(new WebViewClient());
	            wbView.loadUrl("file:///android_asset/zikr.html");
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
