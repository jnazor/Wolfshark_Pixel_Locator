package com.jolienazor.pixel_locator;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CoordDialog extends Dialog {

	private MainActivity myMain;
	private MyImageView myImgVw;
	int coord_x;
	int coord_y;
	
	private EditText x_text;
	private EditText y_text;
	
	public CoordDialog(Context context, View view)
	{
		super(context);
		myMain = (MainActivity) context;
		myImgVw = (MyImageView) view;
		coord_x = 0;
		coord_y = 0;		
	}
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setTitle("Enter Coordinates");
		setContentView(R.layout.activity_main);
		x_text = (EditText) findViewById(R.id.x_coord);
		y_text = (EditText) findViewById(R.id.y_coord);
		
		x_text.setText(coord_x);
		y_text.setText(coord_y);
	}
	
	public void onOK(View v)
	{
		coord_x = Integer.parseInt(x_text.getText().toString());
		coord_y = Integer.parseInt(y_text.getText().toString());
		myImgVw.setX(coord_x);
		myImgVw.setY(coord_y);
		
		dismiss();
		
	}
}
