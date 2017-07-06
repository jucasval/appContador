package com.jucasval.jucasval.contador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador = 0;
    }

    public void incrementar(View vista){

        contador++;
        mostrarResultado();

    }

    public void decrementar(View vista){

        contador--;
        mostrarResultado();

    }

    public void resetear(View vista){

        contador = 0;
        mostrarResultado();

    }

    public void mostrarResultado(){

        TextView textoResultado = (TextView) findViewById(R.id.contadorPulsaciones);

        textoResultado.setText(""+contador);

    }
}//fin class MainActivity
