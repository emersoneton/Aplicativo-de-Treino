package com.example.apptreino;

import android.content.Intent;
import android.os.Bundle;

import com.example.apptreino.modelo.aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    private List<aluno> listPessoa = new ArrayList<aluno>();
    private ArrayAdapter<aluno> arrayAdapterAluno;



    //---Adalto
     ChildEventListener childEventListener;
     Query query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_alunos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        inicializaFirebase();

        ListViewAluno = (ListView) findViewById(R.id.ListViewAluno);

        arrayAdapterAluno = new ArrayAdapter<aluno>(this, android.R.layout.simple_list_item_1, listPessoa);
        ListViewAluno.setAdapter(arrayAdapterAluno);
        inicializarComponentes();


    }


    private void inicializaFirebase() {

        //FirebaseApp.initializeApp(ListViewAlunos.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    private void inicializarComponentes() {



        Query query;
        query = databaseReference.child("aluno").orderByChild("nome");

        listPessoa.clear();

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    aluno alu = objSnapshot.getValue(aluno.class);
                    listPessoa.add(alu);
                }
                arrayAdapterAluno.notifyDataSetChanged();
               // arrayAdapterAluno =
              //  ListViewAluno.setAdapter(arrayAdapterAluno);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }



        });


    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("entrou aqui!");
        }
    };



/*

    @Override
    protected void onStart() {
        super.onStart();

        listPessoa.clear();


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        query = databaseReference.child("aluno").orderByChild("nome");

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                aluno alu = new aluno();
//                alu.setNome(dataSnapshot.child("nome").getValue(String.class));

                aluno alu = dataSnapshot.getValue(aluno.class);

                listPessoa.add(alu);
                arrayAdapterAluno.notifyDataSetChanged();



            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        query.addChildEventListener( childEventListener );

    }

    @Override
    protected void onStop() {
        super.onStop();
        query.removeEventListener( childEventListener );
    }
*/
}
