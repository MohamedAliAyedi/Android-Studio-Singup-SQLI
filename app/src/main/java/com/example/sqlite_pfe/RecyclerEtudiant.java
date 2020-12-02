package com.example.sqlite_pfe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerEtudiant extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecylerAdapter recylerAdapter;
    public ArrayList<etudiant> etudiants;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_etudiant);
        recyclerView = findViewById(R.id.recyclerEtudiant);
        etudiants = new ArrayList<>();
        etudiants = getList();

        recylerAdapter = new RecylerAdapter(this,etudiants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recylerAdapter);
    }

        // GETTT DATAAA
    public ArrayList<etudiant> getList() {
        ArrayList<etudiant> arrayList = new ArrayList<>();
        String q = "SELECT " + EtudiantBC.EtudiantEntry.COLUMN_NAME_NOM + "," + EtudiantBC.EtudiantEntry.COLUMN_NAME_PRENOM + " FROM " + EtudiantBC.EtudiantEntry.TABLE_NAME;
        SQLiteDatabase db = getDbHelper().getReadableDatabase();
        Cursor c = db.rawQuery(q, null);
        int fname = c.getColumnIndex(EtudiantBC.EtudiantEntry.COLUMN_NAME_NOM);
        int lname = c.getColumnIndex(EtudiantBC.EtudiantEntry.COLUMN_NAME_PRENOM);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String ffname = c.getString(fname);
            String llname = c.getString(lname);

            arrayList.add(new etudiant(ffname, llname));

        }
        return arrayList;
    }

    private EtudiantDBHelper dbHelper = null;

    public EtudiantDBHelper getDbHelper() {
        if (dbHelper == null) {
            dbHelper = new EtudiantDBHelper(this);
        }
        return dbHelper;
    }

}