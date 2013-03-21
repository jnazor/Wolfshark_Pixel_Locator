package com.jolienazor.pixel_locator;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
//import android.content.Intent;
import android.util.Log;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
//import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnLongClickListener{

//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_main, menu);
//		return true;
//	}
	
	MyImageView mainView;
	

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		

		mainView = new MyImageView(this);
		
		mainView.setOnLongClickListener(this);
		mainView.setOnTouchListener(new View.OnTouchListener(){
			
			@Override
			public boolean onTouch(View v, MotionEvent event){

				int action = event.getAction();
				int deltaX = 0;
				int startX = 0;
				int deltaY = 0;
				int startY = 0;
				

				Log.d("TOUCH","STARTED A TOUCH");
				
				switch(action){
					case MotionEvent.ACTION_UP:
						mainView.offsetX += mainView.mapX;
						mainView.offsetY += mainView.mapY;
						mainView.mapX = 0;
						mainView.mapY = 0;
						return true;
						//break;
					case MotionEvent.ACTION_DOWN:
						startX = (int)event.getX();
						startY = (int)event.getY();
						
						mainView.startX = startX;
						mainView.startY = startY;
						return true;
						//break;
					case MotionEvent.ACTION_POINTER_DOWN:
					{
						
						
						
						
					}
					case MotionEvent.ACTION_MOVE:
					{

						int valueX = (int)event.getX();
						int valueY = (int)event.getY();
						
						deltaX = valueX - mainView.startX;
						deltaY = valueY - mainView.startY;
						
						mainView.mapX = deltaX;
						mainView.mapY = deltaY;
						
						mainView.moved = true;

						
						mainView.postInvalidate();
						return true;
						//break;

					
						
					}
					default:
						return false;
				}
				//return true;
			}
		});
		setContentView(mainView);
	}
	
	
	
	@Override
	public boolean onLongClick(View v)
	{
		AlertDialog.Builder myAlert = new AlertDialog.Builder(MainActivity.this);
		myAlert.setTitle("Click Me");
		String[] mine = {"Click Me"};
		ScrollView myScrollV = new ScrollView(getApplicationContext());
		TextView myTextV = new TextView(getApplicationContext());
		myTextV.setTextSize(8.0f);
		myScrollV.addView(myTextV);
		myAlert.setView(myScrollV);
		myAlert.setItems(mine, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Dialog myDialog = new CoordDialog(MainActivity.this, mainView);;
				myDialog.show();
			}
		});
		
		myAlert.create().show();			
		return true;
	}
	
//	public boolean onTouch(View v, MotionEvent event)
//	{
//		return false;
//	}
	
	
	
//	public void onNewPath(View v)
//	{ }
	
//	public boolean onCreateOptionsMenu(Menu menu) {
//    	MenuInflater inflater = getMenuInflater();
//    	inflater.inflate(R.menu.mapmenu, menu);
//    	return true;
//    }
	
//	public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//        	case R.id.back:
//    		Intent back = new Intent (this, LocateInputActivity.class);
//    		startActivity(back);
//    		break;
//    		default:
//    			return super.onOptionsItemSelected(item);
//        }
//    	return onOptionsItemSelected(item);
//   }

}
