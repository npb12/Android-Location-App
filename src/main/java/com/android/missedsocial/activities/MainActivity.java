package com.android.missedsocial.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.android.missedsocial.R;
import com.android.missedsocial.views.MainView;
import com.android.missedsocial.views.ViewListener;

public class MainActivity extends Activity{

    public static final String MESSAGE_REGISTER = "";
    public static final String MESSAGE_LOGIN = "";
    //public static final String MESSAGE_JSON = "1234";
    //public static final String LINODE_Address = "http://23.239.3.97";



    private MainView mainActivityView;
    private ViewListener viewListener;

    private Button Button1, Button2, Button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityView = (MainView) View
                .inflate(this, R.layout.activity_main, null);
        mainActivityView.setViewListener(viewListener);
        setContentView(mainActivityView);

        Button1 = (Button) findViewById(R.id.buttons);
        Button2 = (Button) findViewById(R.id.buttons2);
	    Button3 = (Button) findViewById(R.id.buttons3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(com.android.missedsocial.activities.MainActivity.this, com.android.missedsocial.activities.RegisterActivity.class);
        startActivity(intent);
    }

    public void sendMessage2(View view)
    {
        Intent intent = new Intent(com.android.missedsocial.activities.MainActivity.this, com.android.missedsocial.activities.LoginActivity.class);
        startActivity(intent);
    }

	public void sendMessage3(View view) 
	{
        Intent intent = new Intent(com.android.missedsocial.activities.MainActivity.this, com.android.missedsocial.activities.GpsTrackerActivity.class);
        startActivity(intent);
	}
	
	
/*
	public static String POST(String url,String json){
	    InputStream inputStream = null;
	    String result = "";
	    try{            
	        HttpClient httpClient = new DefaultHttpClient();
	        HttpPost httpPost = new HttpPost(url);

	        //String json = obj.toString();
	        StringEntity se = new StringEntity(json);
	        httpPost.setEntity(se);

	        httpPost.setHeader("Accept", "application/json");
	        httpPost.setHeader("Content-type","application/json");

	        HttpResponse httpResponse = httpClient.execute((HttpUriRequest)httpPost);
	        inputStream = httpResponse.getEntity().getContent();

	        if(inputStream!=null){
	            result = convertInputStreamToString(inputStream);
	            
	        }else{
	            result = "Did not work!";
	        }
	    }catch(Exception e){

	    }

	    return result;
	}
	
	
    public static String convertInputStreamToString( InputStream inputStream ){
    	 
        String strText = "";
        if( inputStream != null ){
            StringWriter sw = new StringWriter();
            char[] bufText = new char[1024];
            BufferedReader reader = null;
            try{
                reader = new BufferedReader( new InputStreamReader( inputStream ,"UTF-8" ) );
                int charRead = 0;
 
                while((charRead = reader.read( bufText )) != -1) {
                    sw.write(bufText, 0, charRead);
                }
                strText = sw.toString();
            }catch(Exception es){
                es.printStackTrace();
            }finally{
 
                try{
                    reader.close();
                }catch( IOException es ){
 
                }
                try{
                    inputStream.close();
                }catch( IOException es ){
 
                }
                try{
                    sw.close();
                }catch( IOException es ){
 
                }
 
            }
 
        }
        return strText;
 
    }
    
*/
}
	



