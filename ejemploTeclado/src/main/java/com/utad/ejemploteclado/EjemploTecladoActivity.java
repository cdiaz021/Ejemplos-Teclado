package com.utad.ejemploteclado;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;


public class EjemploTecladoActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_teclado);
    }

    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
    	/* Este m�todo devuelve un booleano, true, si consideramos que la pulsaci�n
    	 * ha sido procesada por nuestro c�digo, y falso, si queremos que otro manejador
    	 * de evento, siguiendo al nuestro, reciba la pulsaci�n.																	
    	 */
    	switch(keyCode){
			case KeyEvent.KEYCODE_CAMERA:
				Toast.makeText(this, "Obturador presionado", Toast.LENGTH_SHORT).show();
				return true;
			case KeyEvent.KEYCODE_1:
				Toast.makeText(this, "Presionado 1", Toast.LENGTH_SHORT).show();
				return true;
			case KeyEvent.KEYCODE_HOME:
				Toast.makeText(this, "HOME presionado", Toast.LENGTH_SHORT).show();
				return true;            
			case KeyEvent.KEYCODE_BACK:
			/*	Toast.makeText(this, "Retorno presionado", Toast.LENGTH_SHORT).show();
				Intent result = new Intent("Complete");
				setResult(Activity.RESULT_OK, result);
				finish();
				*/
				return true;			
			case KeyEvent.KEYCODE_VOLUME_UP:
				Toast.makeText(this, "Boton de Volumen Up presionado", Toast.LENGTH_SHORT).show();
				return true;
			case KeyEvent.KEYCODE_VOLUME_DOWN:
				Toast.makeText(this, "Boton de Volumen Down presionado", Toast.LENGTH_SHORT).show();			
		}
		return super.onKeyDown(keyCode, event);
	}

/*
	@Override
	public void onBackPressed() {
		//super.onBackPressed();
		Toast.makeText(this, "Retorno presionado", Toast.LENGTH_SHORT).show();
		Intent result = new Intent("Complete");
		setResult(Activity.RESULT_OK, result);
		finish();
	}
	*/
}
