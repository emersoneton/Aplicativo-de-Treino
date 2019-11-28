package com.example.apptreino;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.apptreino.modelo.dietas_e_treinos;
import com.example.apptreino.modelo.jogavalores;
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
import android.widget.TextView;
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
import static com.example.apptreino.R.id.txtInformativo;

public class Cadastro_Treino_Dieta extends AppCompatActivity {


    private ConstraintLayout tela;
    private TextView Informativo;
    private EditText edtCadastroTreino;
    private EditText edtCadastroDieta;
    private Button btnSalvarCadastroTreino;



    public void Salvar (View view){

        treinos_e_dietas treinos = new treinos_e_dietas();
        dietas_e_treinos dietas = new dietas_e_treinos();
        jogavalores alu = new jogavalores();

        String valor1 = alu.valor;

        treinos.setTreinos(edtCadastroTreino.getText().toString());
        treinos.setDietas(edtCadastroDieta.getText().toString());
        treinos.setNomebusca(valor1);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference();
        reference.child("treinos").push().setValue(treinos);

        finish();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__treino__dieta);
        //   Toolbar toolbar = findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);
        tela = findViewById(R.id.tela);
        edtCadastroTreino = findViewById(R.id.edtCadastroTreino);
        edtCadastroDieta = findViewById(R.id.edtCadastroDieta);
        Informativo = findViewById(R.id.txtInformativo);
        btnSalvarCadastroTreino = findViewById(R.id.btnSalvarCadastroTreino);





        tela.setOnTouchListener(new OnSwipeTouchListener(this) {

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                //tvSwipe.setText("NÃO");
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                //tvSwipe.setText("SIM
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                edtCadastroTreino.setVisibility(View.VISIBLE);
                edtCadastroDieta.setVisibility(View.INVISIBLE);
                Informativo.setText("Cadastro de Treino");
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                edtCadastroTreino.setVisibility(View.INVISIBLE);
                edtCadastroDieta.setVisibility(View.VISIBLE);
                Informativo.setText("Cadastro de Dieta");
            }

        });
    }
}

