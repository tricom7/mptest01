package com.example.mptest01;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.content.Context;



public class MainActivity extends Activity implements OnClickListener {
	 /** Called when the activity is first created. */
	 MediaPlayer m;
	 Context c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnPlay = (Button)findViewById(R.id.buttonPlay);
	    Button btnStop = (Button)findViewById(R.id.buttonStop);
	 
	    //Register button click listener
	    btnPlay.setOnClickListener(this);
	    btnStop.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
    //Register button click event
    public void onClick(View v){
        int id = v.getId();
        if(id == R.id.buttonPlay){
            play();
        }else if(id == R.id.buttonStop){
        stop();
        }else{
        //do nothing
        }
    }

    
    //Play music
    public void play(){
        c = getApplicationContext();
        try {
            stop();
            m = MediaPlayer.create(c, R.raw.a);
            m.setLooping(true);
            m.start();
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    //Stop music play
    public void stop()
    {
        try {
            if(m != null)
            {
                m.stop();
                m.release();
                m = null;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

}
