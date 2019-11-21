package com.example.apptreino;

import android.content.Intent;
import android.os.Bundle;

import com.example.apptreino.modelo.aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAlunos extends AppCompatActivity {

    private ListView ListViewAluno;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private List<Aluno> listPessoa = new ArrayList<Aluno>();
    private ArrayAdapter<Aluno> arrayAdapterAluno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_alunos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inicializarComponentes();
        inicializaFirebase();

    }


    private void inicializaFirebase() {

        FirebaseApp.initializeApp(ListViewAlunos.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    private void inicializarComponentes() {

        ListViewAluno = (ListView) findViewById(R.id.ListViewAluno);

        Query query;
        query = databaseReference.child("aluno").orderByChild("nome");

        listPessoa.clear();

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Aluno alu = objSnapshot.getValue(Aluno.class);
                    listPessoa.add(alu);
                }

                arrayAdapterAluno = new ArrayAdapter<Aluno>(ListViewAlunos.this, android.R.layout.simple_list_item_1,listPessoa);
                ListViewAluno.setAdapter(arrayAdapterAluno);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}
