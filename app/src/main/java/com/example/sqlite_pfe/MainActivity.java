package com.example.sqlite_pfe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private EditText nom;
    private EditText prenom;
    private EditText email;
    private EditText phone;
    private EditText login;
    private EditText mdp;

    private Button valider;
    private Button annuler;
    private Button listview;
    private Button recyview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        login = findViewById(R.id.login);
        mdp = findViewById(R.id.mdp);

        valider = findViewById(R.id.valider);
        annuler = findViewById(R.id.annuler);
        listview = findViewById(R.id.list_etud);
        recyview = findViewById(R.id.RecyclerList);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogButtonClicked(v);
            }
        });
        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    cleanAllInput();
            }
        });
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListEtudiant.class);
                startActivity(intent);
            }
        });

        recyview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RecyclerEtudiant.class);
                startActivity(intent);
            }
        });


    }

    private void cleanAllInput() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Attention");
            builder.setMessage("Tous les champ est clean ");
            // add a button
            builder.setPositiveButton("OK",null);
            builder.setNegativeButton("ANULLER",null);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        nom.setText("");
        prenom.setText("");
        email.setText("");
        phone.setText("");
        login.setText("");
        mdp.setText("");
    }

    public void showAlertDialogButtonClicked(View view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if ((prenom.getText().equals(null)) || (nom.getText().equals(null)) || (email.getText().equals(null)) || (phone.getText().equals(null)) || (login.getText().equals(null)) || (mdp.getText().equals(null))) {
            builder.setTitle("Attention");
            builder.setMessage("Tous les champ doivent etre remplir ");
            // add a button
            builder.setPositiveButton("OK", null);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            builder.setTitle("Merci");
            builder.setMessage("merci M. " + nom.getText() + " tous champ rempli click List pour affiché tous la list ");
            // add a button
            builder.setPositiveButton("OK", null);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
            ContentValues values = new ContentValues();
            values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_NOM, nom.getText().toString());
            values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_PRENOM, prenom.getText().toString());
            values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_PHONE, phone.getText().toString());
            values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_EMAIL, email.getText().toString());
            values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_LOGIN, login.getText().toString());
            values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_MDP, mdp.getText().toString());

            EtudiantDBHelper mDbHelper = new EtudiantDBHelper(getApplicationContext());
            SQLiteDatabase db = mDbHelper.getWritableDatabase();
            long newRowId;
            newRowId = db.insert("etudiant",null,values);
            db.close();
            mDbHelper.close();
            //Toast toast = Toast.makeText(getApplicationContext(), "ETUDIANT est bien inserté", Toast.LENGTH_LONG).show();

            }
        }

    }

