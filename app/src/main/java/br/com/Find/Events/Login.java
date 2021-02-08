package br.com.Find.Events;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtSenha;
    private CheckBox ckbMostrarSenha;
    private Button btnEntrar;
    private Button btnCadastrar;
    private ProgressBar loginProgressBar;
    private FirebaseAuth mAuth;
    private TextView txtError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnEntrar = findViewById(R.id.btnLogin);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        loginProgressBar = findViewById(R.id.loginProgressBar);
        ckbMostrarSenha = findViewById(R.id.ckbMostrarSenha);
        txtError = findViewById(R.id.txtError);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginEmail = edtEmail.getText().toString();
                String loginSenha = edtSenha.getText().toString();

                if(!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginSenha)){
                    loginProgressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(loginEmail,loginSenha)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        abrirHome();
                                    }
                                    else{
                                        String error = task.getException().getMessage();
                                        Toast.makeText(Login.this,  "Falha ao entrar "+error, Toast.LENGTH_SHORT).show();
                                        loginProgressBar.setVisibility(View.INVISIBLE);
                                        txtError.setText(loginEmail+loginSenha);
                                    }
                                }
                            });
                }
            }
        });
    }
    public void abrirHome(){
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void chamaCadastro(View view) {
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
        finish();
    }
}