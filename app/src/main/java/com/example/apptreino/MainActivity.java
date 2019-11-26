package com.example.apptreino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private TextView txtLogin;
    private TextView txtSenha;
    private Button btnEntrar;
    private TextView txtTeste;
    private FirebaseAuth auth;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        txtTeste = findViewById(R.id.txtTeste);
        auth = FirebaseAuth.getInstance();
        inicializaFirebase();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void inicializaFirebase() {

        //FirebaseApp.initializeApp(ListViewAlunos.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    public void entrar (View view){

        String login = txtLogin.getText().toString();
        String senha = txtSenha.getText().toString();

        if (senha.equals("a") && login.equals("a")){

        }
        logar();

     //   Intent intent = new Intent(MainActivity.this,Principal.class);
     //   startActivity( intent );

    }

    private void logar(){
        String email = txtLogin.getText().toString();
        String senha = txtSenha.getText().toString();
        if (  ! email.isEmpty() && !senha.isEmpty() ){
            //     auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, senha).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if( ! task.isSuccessful() ){
                                Toast.makeText(MainActivity.this,
                                        "Erro ao logar",
                                        Toast.LENGTH_LONG).show();
                            }else {

                                   Intent intent = new Intent(MainActivity.this,Principal.class);
                                   startActivity( intent );
                                finish();
                            }
                        }
                    });


        }
    }


}
