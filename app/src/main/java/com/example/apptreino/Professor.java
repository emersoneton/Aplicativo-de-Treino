package com.example.apptreino;

import android.content.Intent;
import android.os.Bundle;

import com.example.apptreino.modelo.professor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import java.util.UUID;

public class Professor extends AppCompatActivity {

    private EditText txtNomeProfessor;
    private EditText txtTelefoneProfessor;
    private EditText txtEmailProfessor;
    private EditText txtSenhaProfessor;
    private Switch swNutricionista;
    private Switch swTreinador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtNomeProfessor = findViewById(R.id.txtNomeProfessor);
        txtTelefoneProfessor = findViewById(R.id.txtTelefoneProfessor);
        txtEmailProfessor = findViewById(R.id.txtEmailProfessor);
        txtSenhaProfessor = findViewById(R.id.txtSenhaProfessor);
        swNutricionista = findViewById(R.id.swNutricionista);
        swTreinador = findViewById(R.id.swTreinador);
     //   swNutricionista.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);


    }


    public void voltar (View view){

       finish();

    }

    public void Salvar(View view){

        professor prof = new professor();

      //  prof.setId(UUID.randomUUID().toString());
        prof.setNome(txtNomeProfessor.getText().toString());
        prof.setTelefone(txtTelefoneProfessor.getText().toString());
        prof.setEmail(txtEmailProfessor.getText().toString());
        prof.setSenha(txtSenhaProfessor.getText().toString());
        prof.setTipo("P");

        if (swNutricionista.isChecked()){
            prof.setNutricionista("Nutricionista");
        }
        if (swTreinador.isChecked()){
            prof.setTreinador("Treinador");
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference();
        reference.child("professor").push().setValue(prof);

        finish();


    }

}
