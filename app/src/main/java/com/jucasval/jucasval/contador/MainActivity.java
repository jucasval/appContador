package com.jucasval.jucasval.contador;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int contador;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado = (TextView) findViewById(R.id.contadorPulsaciones);

        contador = 0;

        textoResultado.setText(""+contador);

        //ponemos a la escucha el teclado
        EventoTeclado teclado = new EventoTeclado();
        EditText n_reseteo  = (EditText)findViewById(R.id.valorReseteo);
        n_reseteo.setOnEditorActionListener(teclado);
    }

    //persistencia de datos con Bundle
    public void onSaveInstanceState(Bundle estado){

        estado.putInt("cuenta",contador);
        super.onSaveInstanceState(estado);

    }

    //persistencia de datos con Bundle
    public void onRestoreInstanceState(Bundle estado){

        super.onRestoreInstanceState(estado);
        contador = estado.getInt("cuenta");
        textoResultado.setText(""+contador);

    }

    


    public void incrementar(View vista){

        contador++;
        textoResultado.setText(""+contador);


    }

    public void decrementar(View vista){

        contador--;
        if(contador<0){
            CheckBox negativos = (CheckBox)findViewById(R.id.negativos);
            if(!negativos.isChecked()){
                contador = 0;
            }
        }
        textoResultado.setText(""+contador);


    }

    public void resetear(View vista){

        EditText n_reseteo = (EditText)findViewById(R.id.valorReseteo);
        try {
            contador = Integer.parseInt(n_reseteo.getText().toString());
        }catch(Exception e){
            contador = 0;
        }
        n_reseteo.setText("");
        textoResultado.setText(""+contador);

        //cierra el teclado cuando le doy al boton aceptar del mismo o cuando pulso sobre el
        //botón Resetear de la aplicación.
        InputMethodManager miteclado = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        miteclado.hideSoftInputFromWindow(n_reseteo.getWindowToken(),0);

    }

    //Ejecuta directamente (sin necesidad de pulsar el botón resetear)
    // el valor elegido en el campo resetear en la aplicación cuando pulso sobre el botón
    // aceptar del teclado
    class EventoTeclado implements TextView.OnEditorActionListener{

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event){

            if(actionId == EditorInfo.IME_ACTION_DONE)

                resetear(null);  //se pone null pq no es necesario pasar ninguna vista.
                                // Sólo que realice el método

            return false;

        }

    }


}//fin class MainActivity
