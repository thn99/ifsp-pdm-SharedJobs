 package com.example.sharedjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

     private EditText nomeEt;
     private EditText emailEt;
     private RadioGroup tipoTelefoneRg;
     private RadioButton telefoneComercialRb;
     private RadioButton telefoneResidencialRb;
     private EditText telefoneEt;
     private RadioGroup sexoRg;
     private RadioButton masculinoRb;
     private RadioButton femininoRb;
     private EditText dataEt;
     private Spinner formacaoSp;
     private LinearLayout formacaoLl;
     private EditText anoFormaturaEt;
     private EditText anoConclusaoEt;
     private EditText orientadorEt;
     private EditText instituicaoEt;
     private EditText monografiaEt;
     private EditText vagaEt;
     String tipoTelefone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        formacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position <= 1) {
                    anoFormaturaEt.setVisibility(View.VISIBLE);
                    anoConclusaoEt.setVisibility(View.GONE);
                    anoConclusaoEt.setText("");
                    orientadorEt.setVisibility(View.GONE);
                    orientadorEt.setText("");
                    instituicaoEt.setVisibility(View.GONE);
                    instituicaoEt.setText("");
                    monografiaEt.setVisibility(View.GONE);
                    monografiaEt.setText("");
                } else if (position == 2 || position == 3){
                    anoConclusaoEt.setVisibility(View.VISIBLE);
                    instituicaoEt.setVisibility(View.VISIBLE);
                    instituicaoEt.setText("");
                    monografiaEt.setVisibility(View.GONE);
                    monografiaEt.setText("");
                    anoFormaturaEt.setVisibility(View.GONE);
                    anoFormaturaEt.setText("");
                    orientadorEt.setVisibility(View.GONE);
                    orientadorEt.setText("");
                } else {
                    anoConclusaoEt.setVisibility(View.VISIBLE);
                    instituicaoEt.setVisibility(View.VISIBLE);
                    monografiaEt.setVisibility(View.VISIBLE);
                    orientadorEt.setVisibility(View.VISIBLE);
                    anoFormaturaEt.setVisibility(View.GONE);
                    anoFormaturaEt.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

     private void bindViews(){
         nomeEt = findViewById(R.id.nomeEt);
         emailEt = findViewById(R.id.emailEt);
         tipoTelefoneRg = findViewById(R.id.tipoTelefoneRg);
         telefoneEt = findViewById(R.id.telefoneEt);
         dataEt = findViewById(R.id.dataEt);
         formacaoSp = findViewById(R.id.formacaoSp);
         formacaoLl = findViewById(R.id.formacaoLl);
         anoFormaturaEt = findViewById(R.id.anoFormaturaEt);
         anoConclusaoEt = findViewById(R.id.anoConclusaoEt);
         orientadorEt = findViewById(R.id.orientadorEt);
         instituicaoEt = findViewById(R.id.instituicaoEt);
         monografiaEt = findViewById(R.id.monografiaEt);
         vagaEt = findViewById(R.id.vagaEt);
         sexoRg = findViewById(R.id.sexoRg);
     }

    public void onClickButton(View view) {
        if(view.getId() == R.id.salvarBt) saveForm();
        else cleanForm();
    }

     private void saveForm() {
        StringBuffer sb = new StringBuffer();
        sb.append("Nome: ").append(nomeEt.getText().toString()).append("\n")
                .append("Email: ").append(emailEt.getText().toString()).append("\n");
        tipoTelefone = (tipoTelefoneRg.getCheckedRadioButtonId() == R.id.telefoneComercialRb)
                ? "Comercial" : "Residencial";
        sb.append("Tipo de telefone: ").append(tipoTelefone).append("\n")
                .append("Telefone: ").append(telefoneEt.getText().toString()).append("\n")
                .append("Sexo: ");
        if (sexoRg.getCheckedRadioButtonId() == R.id.masculinoRb) sb.append("Masculino").append("\n");
        else sb.append("Feminino").append("\n");
        sb.append("Data de Nascimento: ").append(dataEt.getText().toString()).append("\n");


        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
     }
     private void cleanForm() {
        nomeEt.setText("");
        emailEt.setText("");
        dataEt.setText("");
        tipoTelefoneRg.clearCheck();
        sexoRg.clearCheck();
        anoFormaturaEt.setText("");
        anoConclusaoEt.setText("");
        instituicaoEt.setText("");
        orientadorEt.setText("");
        monografiaEt.setText("");
        vagaEt.setText("");
        telefoneEt.setText("");
     }
 }