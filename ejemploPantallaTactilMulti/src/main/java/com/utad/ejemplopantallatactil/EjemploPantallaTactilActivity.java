package com.utad.ejemplopantallatactil;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class EjemploPantallaTactilActivity extends Activity implements OnTouchListener {
	private TextView entrada, salida;
	private String acciones[] = {"ACTION_DOWN", "ACTION_UP", "ACTION_MOVE", "ACTION_CANCEL",
			"ACTION_OUTSIDE", "ACTION_POINTER_DOWN", "ACTION_POINTER_UP"};

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
		 *  Averiguamos la acci�n.
		 *  En la variable accion se codifica simultaneamente el c�digo de la acci�n
		 *  (8 bits menos significativos) e �ndice de puntero que la ocasiona
		 *  (siguientes 8 bits)
		 */
		int accion = event.getAction();
		// Para obtener la informaci�n
		int codigoAccion = accion & MotionEvent.ACTION_MASK;
		int iPuntero = (accion & MotionEvent.ACTION_POINTER_INDEX_MASK) 
				>> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
		
		//Mostramos el codigo de la acci�n
		salida.append(acciones[codigoAccion]);
		
		/*
		 * En un bucle mostramos informaci�n de todos los punteros activos 
		 */
		for (int i = 0; i < event.getPointerCount(); i++) {
			salida.append(" puntero:" + event.getPointerId(i) +
					" x:" + event.getX(i) + " y:" + event.getY(i));
		}
		
		salida.append("\n");
		/*
		 *  Return false significa que no nos hemos hecho cargo de la pulsaci�n.
		 *  El sistema seguir� pasando este evento a otras vistas.
		 *  En este caso, el LinearLayout que contiene la vista.
		 *  Lo cambiamos a true para el sistema no siga propagando este evento
		 */
		return true;
	}


}
