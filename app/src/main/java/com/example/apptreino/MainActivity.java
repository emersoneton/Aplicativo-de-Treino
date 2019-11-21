package com.example.apptreino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    private TextView txtLogin;
    private TextView txtSenha;
    private Button btnEntrar;
    private TextView txtTeste;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        txtTeste = findViewById(R.id.txtTeste);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void entrar (View view){

        String login = txtLogin.getText().toString();
        String senha = txtSenha.getText().toString();

        if (senha.equals("a") && login.equals("a")){

        }

        Intent intent = new Intent(MainActivity.this,Principal.class);
        startActivity( intent );

    }
}
