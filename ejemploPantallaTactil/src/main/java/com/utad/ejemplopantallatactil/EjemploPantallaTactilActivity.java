package com.utad.ejemplopantallatactil;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class EjemploPantallaTactilActivity extends Activity implements OnTouchListener {
	private TextView entrada, salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_pantalla_tactil);
        
        entrada = (TextView)findViewById(R.id.textView1);
        entrada.setOnTouchListener(this);
        
        salida = (TextView)findViewById(R.id.textView2);
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		/*
		 * action=0 -> MotionEvent.ACTION_DOWN
		 * action=1 -> MotionEvent.ACTION_UP
		 * action=2 -> MotionEvent.ACTION_MOVE
		 */
		salida.append(event.toString() + "\n");
		
		/*
		 *  Return false significa que no nos hemos hecho cargo de la pulsaci�n.
		 *  El sistema seguir� pasando este evento a otras vistas.
		 *  En este caso, el LinearLayout que contiene la vista.
		 *  Lo cambiamos a true para el sistema no siga propagando este evento
		 */
		return true;
	}


}
