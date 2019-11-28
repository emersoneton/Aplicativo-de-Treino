package com.example.apptreino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.example.apptreino.modelo.login;
import com.example.apptreino.modelo.treinos_e_dietas;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    private TextView txtLogin;
    private TextView txtSenha;
    private Button btnEntrar;
    private TextView txtTeste;
    private FirebaseAuth auth;
    String login;
    String senha;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        txtTeste = findViewById(R.id.txtTeste);
        auth = FirebaseAuth.getInstance();
        inicializaFirebase();
        txtLogin.setEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void inicializaFirebase() {

        //FirebaseApp.initializeApp(ListViewAlunos.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    public void entrar (View view){



     /*   login = txtLogin.getText().toString();
        String senha = txtSenha.getText().toString();

        if (login.equals("admin@admin.com") && senha.equals("administrador")){
            Intent intent = new Intent(MainActivity.this,Principal.class);
            startActivity( intent );
        }

        Query query;
        query = databaseReference.child("aluno").orderByChild("email").equalTo(login);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    com.example.apptreino.modelo.login treinos = objSnapshot.getValue(login.class);


                       String tipo = treinos.getTipo();
                       String nome = treinos.getNome();


                    System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkk tipo = " +tipo+ "Nome: " +nome);
                       if (tipo.equals("A")){
                           treinos.funcao();
                           Intent intent = new Intent(MainActivity.this,ListViewAlunos.class);
                              startActivity( intent );
                       }
                        if (tipo.equals("P")){
                            Intent intent = new Intent(MainActivity.this,Principal.class);
                            startActivity( intent );
                        }


                }

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }



        });

      //  Intent intent = new Intent(MainActivity.this,Principal.class);
      //  startActivity( intent );
        */
        logar();
    }

    public void limpar(){
        txtSenha.setText("");
        txtLogin.setText("");
        txtLogin.setEnabled(true);
    }

    private void logar(){
        String email = txtLogin.getText().toString();
         senha = txtSenha.getText().toString();
        if (  ! email.isEmpty() && !senha.isEmpty() ){
            //     auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, senha).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if( ! task.isSuccessful() ){
                                Toast.makeText(MainActivity.this,
                                        "Erro ao logar",
                                        Toast.LENGTH_LONG).show();
                            }else {
                                login = txtLogin.getText().toString();
                                senha = txtSenha.getText().toString();

                                if (login.equals("admin@admin.com") && senha.equals("administrador")){
                                    Intent intent = new Intent(MainActivity.this,Principal.class);
                                    startActivity( intent );
                                }

                                Query query;
                                query = databaseReference.child("aluno").orderByChild("email").equalTo(login);
                                query.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                                            com.example.apptreino.modelo.login treinos = objSnapshot.getValue(login.class);

                                            String tipo = treinos.getTipo();
                                            String nome = treinos.getNome();

                                            if (tipo.equals("A")){
                                                treinos.funcao();
                                                Intent intent = new Intent(MainActivity.this,ListViewAlunos.class);
                                                startActivity( intent );
                                            }

                                        }

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }

                                });







                                login = txtLogin.getText().toString();
                                senha = txtSenha.getText().toString();

                                if (login.equals("admin@admin.com") && senha.equals("administrador")){
                                    Intent intent = new Intent(MainActivity.this,Principal.class);
                                    startActivity( intent );
                                }

                                Query queryProfessor;
                                query = databaseReference.child("professor").orderByChild("email").equalTo(login);
                                query.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                                            com.example.apptreino.modelo.login treinos = objSnapshot.getValue(login.class);

                                            String tipo = treinos.getTipo();
                                            String nome = treinos.getNome();

                                            if (tipo.equals("P")){
                                                Intent intent = new Intent(MainActivity.this,Principal.class);
                                                startActivity( intent );
                                            }
                                        }

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }

                                });

                                limpar();
                            }
                        }
                    });


        }

    }


}
