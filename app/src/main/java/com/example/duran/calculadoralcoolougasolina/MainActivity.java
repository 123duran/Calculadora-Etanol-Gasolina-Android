package com.example.duran.calculadoralcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Declaração das variáveis
    Double alcool;
    Double gasolina;
    String resultado;
    //Declaração dos EditTexts
    EditText edPrecoGasolina, edPrecoAlcool;



    //evento onClick do btnCalcular
    public  void  btnCalcular_click (View view){
    //atribuindo valor aos EditTexts
    edPrecoAlcool = (EditText)findViewById(R.id.edPrecoAlcool);
    edPrecoGasolina = (EditText)findViewById(R.id.edPrecoGasolina);

        //atribuindo às variáveis o valor dos EditTexts
    alcool = Double.parseDouble(edPrecoAlcool.getText().toString());
    gasolina = Double.parseDouble(edPrecoGasolina.getText().toString());

        //Chamando a função que calcula qual combustível é mais vantajoso
       if(( gasolina >0)&& (alcool >0)){
        resultado = calcularVantagem(alcool,gasolina);

           Toast.makeText(getApplicationContext(),resultado, Toast.LENGTH_SHORT).show();
    }
        else{

           Toast.makeText(getApplicationContext(),"Insira os valores corretamente", Toast.LENGTH_SHORT).show();
       }


    }

    //Função para calcular qual combustível é mais vantajoso
    public  String calcularVantagem (double alcool, double gasolina){
        String retorno = "";
        alcool = alcool * 1.3;
        if (alcool > gasolina ){
            retorno = "Abasteça com gasolina";
        }
        else if (alcool == gasolina){

            retorno = "Abasteça com qualquer um, os dois estão equivalentes  ";
        }
        else if (gasolina > alcool){

            retorno = "Abasteça com Etanol";
        }

        return retorno;

    }

}
