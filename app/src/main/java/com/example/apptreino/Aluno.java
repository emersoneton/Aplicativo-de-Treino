package com.example.apptreino;

import android.content.Intent;
import android.os.Bundle;

import com.example.apptreino.modelo.aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

public class Aluno extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtSenha;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtNome = findViewById(R.id.txtNomeAluno);
        txtEmail = findViewById(R.id.txtEmailAluno);
        txtSenha = findViewById(R.id.txtSenhaAluno);

    }

    private void inicializarFirebase() {

        FirebaseApp.initializeApp(Aluno.this);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference();
    }

  //  @Override
  //  public boolean onCreateOptionsMenu(Menu menu) {
      //  getMenuInflater().inflate(R.id.btnSalvarAluno);
    //    return super.onCreateOptionsMenu(menu);
   // }

    public void voltar (View view){

        Intent intent = new Intent(Aluno.this,Principal.class);
        startActivity( intent );

    }


    public void Salvar(View view){

            aluno alu = new aluno();

            alu.setId(UUID.randomUUID().toString());
            alu.setNome(txtNome.getText().toString());
            alu.setEmail(txtEmail.getText().toString());
            alu.setSenha(txtSenha.getText().toString());
            databaseReference.child("Aluno").child(alu.getId()).setValue(alu);

    }

}
