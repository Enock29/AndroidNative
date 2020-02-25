package com.example.exo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle bundle = getIntent().getExtras();
        this.setTitle("Détails des utilisateurs");
        if (bundle != null) {
            TextView name = (TextView) findViewById(R.id.txt_user_name);
            TextView surname = (TextView) findViewById(R.id.user_surname);
            TextView unumero = (TextView) findViewById(R.id.user_numero);
            TextView usexe = (TextView) findViewById(R.id.user_sexe);

            String nom =  bundle.getString("user_nom");
            String prenom =  bundle.getString("user_prenom");
            String sexe =  bundle.getString("user_sexe");
            String numero =  bundle.getString("user_numero");

            name.setText(nom);
            surname.setText(last_name);
            unumero.setText(phone);
            usexe.setText(gender);

        }
    }
}
