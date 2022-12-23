package com.example.ffotbay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.RadioButton;
import android.content.Intent;
import android.widget.Toast;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class REGISTERINFOACTIVITY extends AppCompatActivity {

    private Button enregistrer;
    private EditText nom;
    private EditText prenom;
    private EditText email;

    private Spinner jour;
    private Spinner mois;
    private Spinner annee;

    private RadioGroup sexe;

    private CheckBox interet_android;
    private CheckBox interet_php;
    private CheckBox interet_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerinfoactivity);

        enregistrer = (Button) findViewById(R.id.save);

        nom= (EditText) findViewById(R.id.nom);
        prenom= (EditText) findViewById(R.id.prenom);
        email= (EditText) findViewById(R.id.email);

        jour= (Spinner) findViewById(R.id.jours);
        mois= (Spinner) findViewById(R.id.mois);
        annee= (Spinner) findViewById(R.id.annee);

        sexe=(RadioGroup) findViewById(R.id.radioSex);

        interet_android= (CheckBox) findViewById(R.id.chkAndroid);
        interet_php= (CheckBox) findViewById(R.id.chkPHP);
        interet_java= (CheckBox) findViewById(R.id.chkJava);

    }

    enregistrer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str_nom="";
            String str_prenom="";
            String str_email="";

            int int_jour=0;
            int int_mois=0;
            int int_annee=0;
            String str_date="";

            String str_sexe="";
            String str_interets="";

            //Validation
            boolean info_valable=true;

            //s'assurer que ce n'est pas vide
            if(nom.getText().toString().trim().equals("")==false){
                str_nom=nom.getText().toString().trim();
            }else{
                info_valable=false;
            }

            if(prenom.getText().toString().trim().equals("")==false){
                str_prenom=prenom.getText().toString().trim();
            }else{
                info_valable=false;
            }


            if(email.getText().toString().trim().equals("")==false){
                str_email=email.getText().toString().trim();
            }else{
                info_valable=false;
            }


            int_jour=Integer.valueOf(String.valueOf(jour.getSelectedItem()));
            int_mois=Integer.valueOf(String.valueOf(mois.getSelectedItem()));
            int_annee=Integer.valueOf(String.valueOf(annee.getSelectedItem()));

            str_date=String.valueOf(int_jour) + "-" + String.valueOf(int_mois) + "-" + String.valueOf(int_annee) ;

            // obtenir le bouton radio sélectionné de radioGroup
            int selectedId = sexe.getCheckedRadioButtonId();

            if (selectedId != -1){
                RadioButton radioSexButton;
                radioSexButton = (RadioButton) findViewById(selectedId);
                str_sexe=radioSexButton.getText().toString();
            }else{
                info_valable=false;
            }

            if (interet_android.isChecked() || interet_java.isChecked() || interet_php.isChecked()){
                str_interets= " ";
                if (interet_android.isChecked()){
                    str_interets += "Android ";
                }
                if (interet_php.isChecked()){
                    str_interets += "PHP ";
                }
                if (interet_java.isChecked()){
                    str_interets += "JAVA ";
                }
            }else{
                info_valable=false;
            }

            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);


            if (info_valable==false){
                Toast.makeText(getApplicationContext(),"Il manque des informations",Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(getApplicationContext(), VIEWINFOACTIVITY.class);
                intent.putExtra("nom",str_nom);
                intent.putExtra("prenom",str_prenom);
                intent.putExtra("email",str_email);
                intent.putExtra("date_naissance",str_date);
                intent.putExtra("sexe",str_sexe);
                intent.putExtra("interets",str_interets);
                finish();
                startActivity(intent);
            }

        }
    });

    }
