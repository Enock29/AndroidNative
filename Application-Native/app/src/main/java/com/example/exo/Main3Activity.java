package com.example.exo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.Adapter;
import models.User;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        this.setTitle("Utilisateurs");

        List<User> UserList = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.listUser) ;
        UserList.add(new User("AMOUCHAN", "Enock", 20,"Masculin","66485061"));
        UserList.add(new User("AMOUCHAN", "Gabriel", 55,"Masculin","66557788"));
        UserList.add(new User("AMOUCHAN", "Abel", 25,"Masculin","11223366"));
        UserList.add(new User("AMOUCHAN", "Abdias", 10,"Masculin","77889955"));

        listView.setAdapter(new Adapter(this,UserList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User item = (User) parent.getItemAtPosition(position);
                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("user_nom", item.getNom());
                intent.putExtra("user_prenom", item.getPrenom());
                intent.putExtra("user_numero", item.getNumero());
                intent.putExtra("user_sexe", item.getSexe());

                startActivity(intent);
            }
        });
    }
}