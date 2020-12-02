package com.example.sqlite_pfe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListEtudiant extends AppCompatActivity {

    private ListView ListEtudiant;
    public static ArrayList<etudiant> arrayList = new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_etudiant);
        ListEtudiant = (ListView) findViewById(R.id.idlistetu);
        getAdapter();
        adapter = new MyAdapter(this, arrayList);
        ListEtudiant.setAdapter(adapter);

    }

    private EtudiantDBHelper dbHelper = null;

    public EtudiantDBHelper getDbHelper() {
        if (dbHelper == null) {
            dbHelper = new EtudiantDBHelper(this);
        }
        return dbHelper;
    }


        public void getAdapter() {
            arrayList = new ArrayList<>();
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
    }
}