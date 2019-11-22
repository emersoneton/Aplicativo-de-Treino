package com.example.apptreino;

import android.os.Bundle;

import com.example.apptreino.modelo.treinos_e_dietas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Handler;

import static com.example.apptreino.R.id.tela;

public class Cadastro_Treino_Dieta extends AppCompatActivity {


    private ConstraintLayout tela;
    private EditText edtCadastroTreino;
    private Button btnSalvarCadastroTreino;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__treino__dieta);
     //   Toolbar toolbar = findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        tela = findViewById(R.id.tela);
        edtCadastroTreino = findViewById(R.id.edtCadastroTreino);
        btnSalvarCadastroTreino = findViewById(R.id.btnSalvarCadastroTreino);


    }

    public void Salvar(View view){

        treinos_e_dietas treinos = new treinos_e_dietas();

        treinos.setTreinos(edtCadastroTreino.getText().toString());


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference();
        reference.child("treinos").push().setValue(treinos);

        finish();

    }
    

}
