package com.example.ck.android.demo;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

import com.example.ck.android.demo.restaurant.RestaurantManager;

public class MainActivity extends Activity{

	private TextView textview1;
	private View view1;
	private String[] options = new String[] { "百年锅贴", "老娘舅", "快乐厨房", "西溪食堂",
			"华必和", "清真面食", "花溪米粉" };
	
	private ArrayList restList; 

	/* Here we store the current values of acceleration, one for each axis */
	private float xAccel;
	private float yAccel;
	private float zAccel;

	/* And here the previous ones */
	private float xPreviousAccel;
	private float yPreviousAccel;
	private float zPreviousAccel;

	/* Used to suppress the first shaking */
	private boolean firstUpdate = true;

	/* What acceleration difference would we assume as a rapid movement? */
	private final float shakeThreshold = 1.5f;

	/* Has a shaking motion been started (one direction) */
	private boolean shakeInitiated = false;

	/* The connection to the hardware */
	private SensorManager mySensorManager;

	/* The SensorEventListener lets us wire up to the real hardware events */
	private final SensorEventListener mySensorEventListener = new SensorEventListener() {

		public void onSensorChanged(SensorEvent se) {
			updateAccelParameters(se.values[0], se.values[1], se.values[2]);
			if ((!shakeInitiated) && isAccelerationChanged()) {
				shakeInitiated = true;
			} else if ((shakeInitiated) && isAccelerationChanged()) {
				executeShakeAction();
			} else if ((shakeInitiated) && (!isAccelerationChanged())) {
				shakeInitiated = false;
			}

		}

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			/* can be ignored in this example */
		}
	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		RestaurantManager restMgr = new RestaurantManager();
		restList= restMgr.initiateRestaurent();

		/*setContentView(R.layout.activity_main);
		(textview1 = (TextView)this.findViewById(R.id.textView1);
		view1 = (View)this.findViewById(R.id.view1);
		resList = new ArrayList();*/
		
		mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE); 
		mySensorManager.registerListener(mySensorEventListener,
				mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
		
		view1.setOnLongClickListener(new OnLongClickListener(){

			@Override
			public boolean onLongClick(View arg0) {
				
				restList.add(textview1.getText());      
				Log.d("MainActivity", "The size of ArrayList is: " + restList.size()); 
				return true;
			}});
		
		view1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				for(Iterator<String> iter = restList.iterator(); iter.hasNext();) {
					Log.i("MainActivity", "Value: " + iter.next()); 
				}
				
			}});
	}

	

	private void initRestList() {
		// TODO Auto-generated method stub
		
	}



	private void updateAccelParameters(float xNewAccel, float yNewAccel,
			float zNewAccel) {
		/*
		 * we have to suppress the first change of acceleration, it results from
		 * first values being initialized with 0
		 */
		if (firstUpdate) {
			xPreviousAccel = xNewAccel;
			yPreviousAccel = yNewAccel;
			zPreviousAccel = zNewAccel;
			firstUpdate = false;
		} else {
			xPreviousAccel = xAccel;
			yPreviousAccel = yAccel;
			zPreviousAccel = zAccel;
		}
		xAccel = xNewAccel;
		yAccel = yNewAccel;
		zAccel = zNewAccel;
		
	}

	private boolean isAccelerationChanged() {
		float deltaX = Math.abs(xPreviousAccel - xAccel);
		float deltaY = Math.abs(yPreviousAccel - yAccel);
		float deltaZ = Math.abs(zPreviousAccel - zAccel);
		return (deltaX > shakeThreshold && deltaY > shakeThreshold)
				|| (deltaX > shakeThreshold && deltaZ > shakeThreshold)
				|| (deltaY > shakeThreshold && deltaZ > shakeThreshold);
	}

	private void executeShakeAction() {
		int random = (int) (Math.random() * 6);
		Log.d("MainActivty", "Random number is: "+random);
		textview1.setText(options[random]);
	}





}
