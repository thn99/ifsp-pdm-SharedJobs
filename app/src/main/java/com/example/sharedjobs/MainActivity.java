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

import com.example.sharedjobs.databinding.ActivityMainBinding;

 public class MainActivity extends AppCompatActivity {

     private ActivityMainBinding activityMainBinding;
     String tipoTelefone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.formacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position <= 1) {
                    activityMainBinding.anoFormaturaEt.setVisibility(View.VISIBLE);
                    activityMainBinding.anoConclusaoEt.setVisibility(View.GONE);
                    activityMainBinding.anoConclusaoEt.setText("");
                    activityMainBinding.orientadorEt.setVisibility(View.GONE);
                    activityMainBinding.orientadorEt.setText("");
                    activityMainBinding.instituicaoEt.setVisibility(View.GONE);
                    activityMainBinding.instituicaoEt.setText("");
                    activityMainBinding.monografiaEt.setVisibility(View.GONE);
                    activityMainBinding.monografiaEt.setText("");
                } else if (position == 2 || position == 3){
                    activityMainBinding.anoConclusaoEt.setVisibility(View.VISIBLE);
                    activityMainBinding.instituicaoEt.setVisibility(View.VISIBLE);
                    activityMainBinding.instituicaoEt.setText("");
                    activityMainBinding.monografiaEt.setVisibility(View.GONE);
                    activityMainBinding.monografiaEt.setText("");
                    activityMainBinding.anoFormaturaEt.setVisibility(View.GONE);
                    activityMainBinding.anoFormaturaEt.setText("");
                    activityMainBinding.orientadorEt.setVisibility(View.GONE);
                    activityMainBinding.orientadorEt.setText("");
                } else {
                    activityMainBinding.anoConclusaoEt.setVisibility(View.VISIBLE);
                    activityMainBinding.instituicaoEt.setVisibility(View.VISIBLE);
                    activityMainBinding.monografiaEt.setVisibility(View.VISIBLE);
                    activityMainBinding.orientadorEt.setVisibility(View.VISIBLE);
                    activityMainBinding.anoFormaturaEt.setVisibility(View.GONE);
                    activityMainBinding.anoFormaturaEt.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onClickButton(View view) {
        if(view.getId() == R.id.salvarBt) saveForm();
        else cleanForm();
    }

     private void saveForm() {
        StringBuffer sb = new StringBuffer();
        sb.append("Nome: ").append(activityMainBinding.nomeEt.getText().toString()).append("\n")
                .append("Email: ").append(activityMainBinding.emailEt.getText().toString()).append("\n");
        tipoTelefone = (activityMainBinding.tipoTelefoneRg.getCheckedRadioButtonId() == R.id.telefoneComercialRb)
                ? "Comercial" : "Residencial";
        sb.append("Tipo de telefone: ").append(tipoTelefone).append("\n")
                .append("Telefone: ").append(activityMainBinding.telefoneEt.getText().toString()).append("\n")
                .append("Sexo: ");
        if (activityMainBinding.sexoRg.getCheckedRadioButtonId() == R.id.masculinoRb) sb.append("Masculino").append("\n");
        else sb.append("Feminino").append("\n");
        sb.append("Data de Nascimento: ").append(activityMainBinding.dataEt.getText().toString()).append("\n");


        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
     }
     private void cleanForm() {
        activityMainBinding.nomeEt.setText("");
        activityMainBinding.emailEt.setText("");
        activityMainBinding.dataEt.setText("");
        activityMainBinding.tipoTelefoneRg.clearCheck();
        activityMainBinding.sexoRg.clearCheck();
        activityMainBinding.anoFormaturaEt.setText("");
        activityMainBinding.anoConclusaoEt.setText("");
        activityMainBinding.instituicaoEt.setText("");
        activityMainBinding.orientadorEt.setText("");
        activityMainBinding.monografiaEt.setText("");
        activityMainBinding.vagaEt.setText("");
        activityMainBinding.telefoneEt.setText("");
     }
 }