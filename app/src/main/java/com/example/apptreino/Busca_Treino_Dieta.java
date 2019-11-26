package com.example.apptreino;

import android.os.Bundle;

import com.example.apptreino.modelo.dietas_e_treinos;
import com.example.apptreino.modelo.treinos_e_dietas;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Busca_Treino_Dieta extends AppCompatActivity {

    private ConstraintLayout tela_busca;

    private ListView ListViewBuscaTreino;
    private ListView ListViewBuscaDieta;

  //  private ListView ListViewAluno;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private List<treinos_e_dietas> listTreino = new ArrayList<treinos_e_dietas>();
    private List<dietas_e_treinos> listDieta = new ArrayList<dietas_e_treinos>();

    private ArrayAdapter<treinos_e_dietas> arrayAdaptertreinos_e_dietas;
    private ArrayAdapter<dietas_e_treinos> arrayAdapterDietas_e_treinos;




    //---Adalto
    ChildEventListener childEventListener;
    Query query;
    Query queryDieta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca__treino__dieta);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     //   ListViewBuscaTreino = findViewById(R.id.ListViewBuscaTreino);
        tela_busca = findViewById(R.id.tela_busca);

        inicializaFirebase();

        ListViewBuscaTreino = (ListView) findViewById(R.id.ListViewBuscaTreino);
        ListViewBuscaDieta = (ListView) findViewById(R.id.ListViewBuscaDieta);

        arrayAdaptertreinos_e_dietas = new ArrayAdapter<treinos_e_dietas>(this, android.R.layout.simple_list_item_1, listTreino);
        arrayAdapterDietas_e_treinos = new ArrayAdapter<dietas_e_treinos>(this, android.R.layout.simple_list_item_1, listDieta);

        ListViewBuscaTreino.setAdapter(arrayAdaptertreinos_e_dietas);
        ListViewBuscaDieta.setAdapter(arrayAdapterDietas_e_treinos);
        inicializarComponentes();

        ListViewBuscaTreino.setOnTouchListener(new OnSwipeTouchListener(this) {

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

            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                ListViewBuscaTreino.setVisibility(View.INVISIBLE);
                ListViewBuscaDieta.setVisibility(View.VISIBLE);
            }

        });

        ListViewBuscaDieta.setOnTouchListener(new OnSwipeTouchListener(this) {

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
                ListViewBuscaDieta.setVisibility(View.INVISIBLE);
                ListViewBuscaTreino.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();

            }

        });

    }


    private void inicializaFirebase() {

        //FirebaseApp.initializeApp(ListViewAlunos.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    private void inicializarComponentes() {

        String valor = "treino";

        Query query;
        query = databaseReference.child("treinos").orderByChild("treinos");
        Query queryDieta;
        queryDieta = databaseReference.child("treinos").orderByChild("dietas");



        listTreino.clear();
        listDieta.clear();

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    treinos_e_dietas treinos = objSnapshot.getValue(treinos_e_dietas.class);
                    listTreino.add(treinos);
                }
                arrayAdaptertreinos_e_dietas.notifyDataSetChanged();
                // arrayAdapterAluno =
                //  ListViewAluno.setAdapter(arrayAdapterAluno);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }



        });

        queryDieta.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    dietas_e_treinos treinos = objSnapshot.getValue(dietas_e_treinos.class);
                    listDieta.add(treinos);
                }
                arrayAdapterDietas_e_treinos.notifyDataSetChanged();
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



}
