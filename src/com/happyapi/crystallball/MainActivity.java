package com.happyapi.crystallball;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private CrystalBall mCrystalBall = new CrystalBall();
	private TextView answerLabel; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);  
		// można sprawdzić w gen/java.r/i tam sa klasy 
		
		
//		declare our View variables and assign them the Views from the layout file
		
		answerLabel = (TextView) findViewById(R.id.textView1); 
		Button getAnswerButton = (Button) findViewById(R.id.button1);
		
		getAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				String answer = mCrystalBall.getAnAnswer();

//				update label with dynamic label	
				answerLabel.setText(answer);
				
				animateCrystallBall(); // odpalenie aimacji podczas przycisniecia przysku 
			}
		});	
	}
	
	private void animateCrystallBall() {
		ImageView crystalBallImage = (ImageView) findViewById(R.id.imageView1); // pobranie obrazka 
		crystalBallImage.setImageResource(R.drawable.ball_animation); // 
		AnimationDrawable ballAnimation = (AnimationDrawable) crystalBallImage.getDrawable();
		
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
		
		
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
