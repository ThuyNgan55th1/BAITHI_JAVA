package com.example.happybirthdayba;

import java.util.ArrayList;

import com.example.happybirthday.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Music<View> extends Activity {

	TextView txtLoinhan;
	ListView lvBaiHat;
	RelativeLayout mh;
	MediaPlayer song;
	
	ArrayList<String> mangTenBH, mangLoiNhan;
	ArrayList<Integer> mangMp3;
	protected int position;
	
	public void AnhXa(){
		txtLoinhan = (TextView)findViewById(R.id.textViewLoinhan);
		lvBaiHat = (ListView)findViewById(R.id.listViewbaihat);
		mh = (RelativeLayout)findViewById(R.id.manHinh);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music);
		
		AnhXa();
		
		mh.setBackgroundResource(R.drawable.father);
		
		song = MediaPlayer.create(getApplicationContext(), R.raw.cha);
		song.start();
		
		txtLoinhan.setText("Chúc mừng sinh nhật cha tình yêu to bự của gia đình chúng ta!!!");
		TaoAnimation();
		TaoMang();
		
		ArrayAdapter adapter = new ArrayAdapter(
				getApplicationContext(), android.R.layout.simple_list_item_1, mangTenBH
				);
		lvBaiHat.setAdapter(adapter);
		
		lvBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick( AdapterView<?> parent, View view, int position, long id){
				// TODO Auto-generated method stub
				song.stop();
				song = MediaPlayer.create(getApplicationContext(), mangMp3.get(position));
				song.start();
				
				txtLoinhan.setText(mangLoiNhan.get(position));
			}

			@Override
			public void onItemClick(AdapterView<?> parent,
					android.view.View arg1, int position, long id) {
				// TODO Auto-generated method stub
				song.stop();
				song = MediaPlayer.create(getApplicationContext(), mangMp3.get(position));
				song.start();
				
				txtLoinhan.setText(mangLoiNhan.get(position));
				TaoAnimation();
			}
		});
//	 txtLoinhan.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				song.stop();
//				// TODO Auto-generated method stub
//			Intent mhMain = new Intent(getApplicationContext(), MainActivity.class);
//			startActivity(mhMain);
//			}
//	 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.music, menu);
		return true;
	}

	public void TaoAnimation(){
		Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
		zoom.reset();
		txtLoinhan.clearAnimation();
		txtLoinhan.startAnimation(zoom);
	}
	public void TaoMang(){
		mangTenBH = new ArrayList<String>();
		mangLoiNhan = new ArrayList<String>();
		mangMp3 = new ArrayList<Integer>();
		
		mangMp3.add(R.raw.nguoicha);
		mangTenBH.add("Người Cha");
		mangLoiNhan.add("Cả cuộc đời vất vả vì con....con cầu chúc cho cha thật nhiều sức khỏe!");
		
		mangMp3.add(R.raw.anhmatcuacha);
		mangTenBH.add("Ánh mắt của cha");
		mangLoiNhan.add("Cầu mong cha sức khỏe đong đầy để bên con thật dài và thật lâu...yêu cha!!!");
		
		mangMp3.add(R.raw.bakeconnghe);
		mangTenBH.add("Ba kể con nghe - Nguyễn Hải Phong");
		mangLoiNhan.add("Những câu chuyện đời ba kể con nghe chặng đường dài ba đi qua là hành trang cho con mãi về sau...nhọc nhằn ơi đừng vươn trên đôi vai gầy ấy nữa....");
		
		mangMp3.add(R.raw.chayeu);
		mangTenBH.add("Cha yêu - Thùy Chi");
		mangLoiNhan.add("Ngày mai kia dù có sóng to gió lớn con biết rằng vẫn có vòng tay ba đón con mỗi khi yếu lòng...con yêu ba!!!");
	}
}
