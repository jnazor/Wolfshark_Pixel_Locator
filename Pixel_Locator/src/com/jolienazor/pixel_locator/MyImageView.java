package com.jolienazor.pixel_locator;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.view.View;

public class MyImageView extends View {
	
	Paint imgPaint;
	Bitmap mapGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.campus_map);
	Path thePath;
	Paint pathPaint;

	int mapX = 0;
	int mapY = 0;
	
	int testx = 0;
	int testy = 0;
	
	public int offsetX = 0;
	public int offsetY = 0;

	int startX;
	int startY;
	
	int x_cord;
	int y_cord;
	
	boolean moved = false;
	
	Path circle;  //for testing
	Paint cPaint;  //for testing
	
	
	public MyImageView(Context context)
	{
		super(context);
		this.setBackgroundColor(Color.WHITE);
		
		imgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		thePath = new Path();
		
		pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		pathPaint.setColor(Color.BLACK);
		pathPaint.setStrokeWidth(3);
		pathPaint.setStyle(Paint.Style.STROKE);
		
		//TESTING
		circle = new Path();
		cPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{

		
		canvas.drawBitmap(mapGraphic, mapX + offsetX, mapY + offsetY, imgPaint);
		
		//thePath.reset();
		circle.reset();
		
//		thePath.moveTo(250+offsetX+mapX, 250+offsetY+mapY);
//		thePath.lineTo(200+offsetX+mapX, 200+offsetY+mapY);
//		thePath.lineTo(600+offsetX+mapX, 200+offsetY+mapY);
//		thePath.lineTo(300+offsetX+mapX, 1200+offsetY+mapY);
//		canvas.drawPath(thePath, pathPaint);
		
		circle.addCircle(x_cord+offsetX+mapX, y_cord+offsetY+mapY, 15, Direction.CW);		
        cPaint.setColor(Color.BLUE);
        cPaint.setStyle(Paint.Style.FILL);
        cPaint.setStrokeWidth(3);
		
        canvas.drawPath(circle, cPaint);	
	}
	
	public void moveMap(int inputX, int inputY)
	{


	}
	
	public int getMapX()
	{
		return mapX;
	}
	
	public int getMapY()
	{
		return mapY;
	}
	
	public void setX(int numX)
	{
		if(numX >= 0)
			x_cord = numX;
		else
			x_cord = 0;
	}
	
	public void setY(int numY)
	{
		if(numY >= 0)
			y_cord = numY;
		else
			y_cord = 0;
	}

}
