package br.edu.ifsp.scl.ads.pdm.havagas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nomeEt;
    private EditText emailEt;
    private CheckBox emailCk;
    private EditText telEt;
    private Button addTelBt;
    private LinearLayout maisTel;
    private EditText tel2;
    private RadioGroup radioGroupTel;
    private RadioButton pessoal;
    private RadioButton comercial;
    private RadioGroup radioGroupS;
    private RadioButton fem;
    private RadioButton masc;
    private EditText dataNasc;
    private Spinner formSp;
    private LinearLayout formacaoFundLl;
    private LinearLayout formacaoGradEspLl;
    private LinearLayout formacaoMestEDoutLl;
    private EditText anoForm;
    private EditText anoConclusao;
    private EditText instituicao;
    private EditText titulo;
    private EditText vagas;
    private Button savarBt;
    private Button limparBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        formSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long id) {
                String formacao = ((TextView) view).getText().toString();
                if(formacao.equals("Fundamental") || formacao.equals("Médio")){
                    formacaoFundLl.setVisibility(View.VISIBLE);
                }
                if(formacao.equals("Graduação") || formacao.equals("Especialização") ){
                    formacaoGradEspLl.setVisibility(View.VISIBLE);
                }
                if(formacao.equals("Mestrado") || formacao.equals("Doutorado") ){
                    formacaoMestEDoutLl.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void onClick(View view){
        StringBuilder sb = new StringBuilder();
        sb.append(nomeEt.getText().toString());
        sb.append("\n");
        sb.append(emailEt.getText().toString());
        sb.append("\n");
        sb.append(telEt.getText().toString());
        sb.append("\n");
        sb.append(pessoal.isChecked() ? "Tel pessoal" : "Tel comercial");
        sb.append("\n");
        sb.append(vagas.getText().toString());
        sb.append("\n");
        sb.append(dataNasc.getText().toString());
        sb.append("\n");
        sb.append(emailCk.isChecked() ? "Receber e-mails" : "não receber e-mails");
        sb.append("\n");
        sb.append(masc.isChecked() ? "Masculino" : "Feminino");
        sb.append("\n");
        sb.append(((TextView) formSp.getSelectedView()).getText());
        sb.append("\n");

        if(view.getId() == R.id.salvarBt){
            Toast.makeText(this, sb.toString() , Toast.LENGTH_LONG).show();
        }
        if(view.getId() == R.id.limparBt){
            Toast.makeText(this,"Limpando", Toast.LENGTH_SHORT).show();
            limparCampos();
        }
        if(view.getId() == R.id.addTelBt){
            maisTel.setVisibility(View.VISIBLE);
        }


    }

    private void limparCampos() {
        nomeEt.setText("");
        emailEt.setText("");
        telEt.setText("");
        vagas.setText("");
        dataNasc.setText("");

    }

    private void bindViews(){
        nomeEt = findViewById(R.id.inputName);
        emailEt = findViewById(R.id.inputEmail);
        emailCk = findViewById(R.id.emailCk);
        telEt = findViewById(R.id.inputTel);
        addTelBt = findViewById(R.id.addTelBt);
        maisTel = findViewById(R.id.maisTel);
        tel2 = findViewById(R.id.inputTel2);
        radioGroupTel = findViewById(R.id.radioGroupTel);
        pessoal = findViewById(R.id.pessoalRb);
        comercial = findViewById(R.id.comercialRb);
        radioGroupS = findViewById(R.id.radioGroupS);
        fem = findViewById(R.id.femRb);
        masc = findViewById(R.id.mascRb);
        dataNasc = findViewById(R.id.inputDataNasc);
        formSp = findViewById(R.id.opcoesSp);
        formacaoFundLl = findViewById(R.id.formacaoFundLl);
        formacaoGradEspLl = findViewById(R.id.formacaoGradEspLl);
        formacaoMestEDoutLl = findViewById(R.id.formacaoMestEDoutLl);
        anoForm = findViewById(R.id.inputAnoFormatura);
        anoConclusao = findViewById(R.id.inputAnoConclusao);
        instituicao = findViewById(R.id.inputInstituicao);
        titulo = findViewById(R.id.inputTitulo);
        vagas = findViewById(R.id.inputVagas);
    }
}