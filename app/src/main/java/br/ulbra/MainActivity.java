package br.ulbra;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rbGrupo;

    Button btnCalc;

    EditText txtSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSal = (EditText) findViewById(R.id.txtSal);
        rbGrupo = (RadioGroup) findViewById(R.id.rbGrupo);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double salario = Double.parseDouble(txtSal.getText().toString());
                int gp = rbGrupo.getCheckedRadioButtonId();
                double novoSal = 0;
                if (gp == R.id.rb40){
                    novoSal = salario + (salario * 0.4);
                } else if (gp == R.id.rb45) {
                    novoSal = salario + (salario * 0.45);
                } else {
                    novoSal = salario + (salario * 0.5);
                }
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Novo salário");
                dialogo.setMessage("Seu novo salário é : R$" +String.valueOf(novoSal));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}