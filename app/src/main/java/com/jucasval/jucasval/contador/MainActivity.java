package com.jucasval.jucasval.contador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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


    }


}//fin class MainActivity
