package com.utad.ejemplogestures;

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class EjemploGesturesActivity extends Activity implements OnGesturePerformedListener{
    private GestureLibrary libreria;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ejemplo_gestures);
		libreria = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if (!libreria.load()) {
           finish();
        }
        GestureOverlayView gesturesView = (GestureOverlayView)                                                                     
           findViewById(R.id.gestureOverlayView1);
        gesturesView.addOnGesturePerformedListener(this);
		
	}

	@Override
	public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

	     ArrayList<Prediction> predictions = libreria.recognize(gesture);

	     for (Prediction prediction : predictions){

	    	 if (prediction.score > 1.0) {
	    		 Toast.makeText(this, prediction.name + " " + prediction.score, Toast.LENGTH_SHORT).show();
	         }
	     }
	}
}
