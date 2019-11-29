package com.example.apptreino;

import android.content.Intent;
import android.os.Bundle;

import com.example.apptreino.modelo.professor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    private Button btnCadastraProfessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnCadastraProfessor = findViewById(R.id.btnCadastraProfessor);
        testar();

    }

    public void testar(){
        professor prof = new professor();

        String tipos = prof.getTipos();
        if (tipos.equals("P")) {
            btnCadastraProfessor.setEnabled(false);
            prof.professor2();
        }
    }

    public void professor (View view){

        Intent intent = new Intent(Principal.this,Professor.class);
        startActivity( intent );

    }

    public void aluno (View view){

            Intent intent = new Intent(Principal.this,Aluno.class);
            startActivity( intent );

    }

    public void ListViewAlunos (View view){

        Intent intent = new Intent(Principal.this,ListViewAlunos.class);
        startActivity( intent );

        // Intent de teste
       // Intent intent = new Intent(Principal.this,Cadastro_Treino_Dieta.class);
       // startActivity( intent );

      //  Intent intent = new Intent(Principal.this,Busca_Treino_Dieta.class);
      //  startActivity( intent );

    }


    public void finish(View view) {
        finish();
    }

}
