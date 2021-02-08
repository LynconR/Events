package br.com.Find.Events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    private EditText edtEmailCadastro;
    private EditText edtNomeUsuario;
    private EditText edtSenhaCadastro;
    private EditText edtSenhaCadastroConfirmacao;
    private Button btnEfetuarCadastro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

    }
    public void voltarLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}