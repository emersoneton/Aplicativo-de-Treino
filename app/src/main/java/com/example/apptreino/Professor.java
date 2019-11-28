package com.example.apptreino;

import android.content.Intent;
import android.os.Bundle;

import com.example.apptreino.modelo.professor;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.UUID;

public class Professor extends AppCompatActivity {

    private EditText txtNomeProfessor;
    private EditText txtTelefoneProfessor;
    private EditText txtEmailProfessor;
    private EditText txtSenhaProfessor;
    private Switch swNutricionista;
    private Switch swTreinador;
    private FirebaseAuth auth;
    private FirebaseUser usuario;


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
        auth = FirebaseAuth.getInstance();
     //   swNutricionista.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);


    }


    public void voltar (View view){

       finish();

    }

    public void Salvar(View view) {

        String email = txtEmailProfessor.getText().toString();
        String senha = txtSenhaProfessor.getText().toString();

        if (!email.isEmpty()) {


            auth.createUserWithEmailAndPassword(email, senha).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                usuario = auth.getCurrentUser();
                                professor prof = new professor();
                                //  prof.setId(UUID.randomUUID().toString());
                                prof.setNome(txtNomeProfessor.getText().toString());
                                prof.setTelefone(txtTelefoneProfessor.getText().toString());
                                prof.setEmail(txtEmailProfessor.getText().toString());
                                prof.setSenha(txtSenhaProfessor.getText().toString());
                                prof.setTipo("P");

                                if (swNutricionista.isChecked()) {
                                    prof.setNutricionista("Nutricionista");
                                }
                                if (swTreinador.isChecked()) {
                                    prof.setTreinador("Treinador");
                                }

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference reference = database.getReference();
                                reference.child("professor").push().setValue(prof);

                                Toast.makeText(Professor.this,
                                        "Cadastrado com Sucesso!",
                                        Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(Professor.this,
                                        "Erro ao cadastrar!",
                                        Toast.LENGTH_LONG).show();
                            }


                        }
                    });

            finish();


        }

    }
}
