package com.example.happybirthdayba;

import com.example.happybirthday.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity<startActivity> extends Activity {

	RelativeLayout mh;
	MediaPlayer song;
	ImageView imgvgiadinh;
	
	
	public void AnhXa(){
	mh = (RelativeLayout)findViewById(R.id.manHinh);
	imgvgiadinh = (ImageView)findViewById(R.id.imageViewgiadinh);
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AnhXa();
        
        mh.setBackgroundResource(R.drawable.happy1);
        
        song = MediaPlayer.create(getApplicationContext(),R.raw.happybirthday);
        song.start();
        
        Animation f = AnimationUtils.loadAnimation(this, R.anim.fade);
        f.reset();
        imgvgiadinh.clearAnimation();
        imgvgiadinh.startAnimation(f);
        
        imgvgiadinh.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				song.stop();
				Intent mhMusic = new Intent(getApplicationContext(), Music.class);
				startActivity(mhMusic);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
