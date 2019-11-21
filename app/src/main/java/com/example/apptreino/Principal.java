package com.example.apptreino;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

    }

    public void finish(View view) {
        finish();
    }

}
