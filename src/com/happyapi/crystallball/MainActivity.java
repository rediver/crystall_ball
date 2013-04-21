package com.happyapi.crystallball;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private CrystalBall mCrystalBall = new CrystalBall();
	private TextView mAnswerLabel; 
	private Button mGetAnswerButton; // zdefiniowanie klasy pozwolilo nam na usuniecie zmiennej typu w lini 32
	private ImageView mCrystalBallImage; // podobnie jak u gory
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);  
		// można sprawdzić w gen/java.r/i tam sa klasy 
		
		
//		declare our View variables and assign them the Views from the layout file
		
		mAnswerLabel = (TextView) findViewById(R.id.textView1); 
		mGetAnswerButton = (Button) findViewById(R.id.button1);
		
		mGetAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				String answer = mCrystalBall.getAnAnswer();

//				update label with dynamic label	
				mAnswerLabel.setText(answer);
				
				animateCrystallBall(); // odpalenie aimacji podczas przycisniecia przysku 
				animateAnswear();  // odpalenie animacji napisu 
				playSound();
			}
		});	
	}
	
	private void animateCrystallBall() {
		mCrystalBallImage = (ImageView) findViewById(R.id.imageView1); // pobranie obrazka 
		mCrystalBallImage.setImageResource(R.drawable.ball_animation); // 
		AnimationDrawable ballAnimation = (AnimationDrawable) mCrystalBallImage.getDrawable();
		
        // sprawdzenie czy animacja sie otwarza 
		
		if (ballAnimation.isRunning()) {
			ballAnimation.stop();
		}
		
		ballAnimation.start(); // odpalenie animacji 
	};
	
	
	private void animateAnswear() { // inicjalizacja nowej metody 
		
		AlphaAnimation fadeInAnimation = new AlphaAnimation(0,1); // zainicjowany konstruktor i od do wartosci aplha animacji 
		fadeInAnimation.setDuration(1500);  // czas animacji 
		fadeInAnimation.setFillAfter(true); // wartosc boolean 
		
		mAnswerLabel.setAnimation(fadeInAnimation);  // dodawanie animacji do texView 
		
	};
	
	private void playSound() {
		MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);    // pierwszy parameyr contex jako ze jestrsmy w mian acstivity przyjmuje 33watrosc this
		player.start();		// zaincjalizowanie dziwku 
		player.setOnCompletionListener(new OnCompletionListener() {   // wykrywanie kiedy ma byc odegrany dzwiek 
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
			}
		});
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
