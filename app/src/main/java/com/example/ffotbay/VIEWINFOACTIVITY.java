package com.example.ffotbay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class VIEWINFOACTIVITY extends AppCompatActivity {
    private TextView nom;
    private TextView prenom;
    private TextView email;
    private TextView dateNaissance;
    private TextView sexe;
    private TextView interets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewinfoactivity);

        nom=(TextView) findViewById(R.id.nom);
        prenom=(TextView) findViewById(R.id.prenom);
        email=(TextView) findViewById(R.id.email);
        dateNaissance=(TextView) findViewById(R.id.dateNaissance);
        sexe=(TextView) findViewById(R.id.sexe);
        interets=(TextView) findViewById(R.id.interets);


        // Obtenez les données transférées de l'activité source.
        Intent intent = getIntent();

        nom.setText(intent.getStringExtra("nom"));
        prenom.setText(intent.getStringExtra("prenom"));
        email.setText(intent.getStringExtra("email"));
        dateNaissance.setText(intent.getStringExtra("date_naissance"));
        sexe.setText(intent.getStringExtra("sexe"));
        interets.setText(intent.getStringExtra("interets"));
    }

    public void ReturnBack(View view){
        Intent intent= new Intent(getApplicationContext(), REGISTERINFOACTIVITY.class);
        finish();
        startActivity(intent);
    }
}

