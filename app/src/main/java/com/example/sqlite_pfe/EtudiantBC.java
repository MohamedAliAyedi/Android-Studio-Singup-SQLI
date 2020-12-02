package com.example.sqlite_pfe;

import android.provider.BaseColumns;

public class EtudiantBC {
    public EtudiantBC() {}
    public static abstract class EtudiantEntry implements BaseColumns {
        public static final String TABLE_NAME = "etudiant";
        public static final String COLUMN_NAME_NOM = "nom";
        public static final String COLUMN_NAME_PRENOM = "prenom";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_LOGIN = "login";
        public static final String COLUMN_NAME_MDP = "mdp";
        private static final String TEXT_TYPE = " TEXT";
        private static final String INT_TYPE = " INTEGER";
        private static final String COMMA_SEP = ",";
        }
        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+ EtudiantEntry.TABLE_NAME
                + "(" +
                "_id INTEGER PRIMARY KEY," +
                EtudiantEntry.COLUMN_NAME_NOM + " TEXT," +
                EtudiantEntry.COLUMN_NAME_PRENOM + " TEXT," +
                EtudiantEntry.COLUMN_NAME_PHONE + " TEXT," +
                EtudiantEntry.COLUMN_NAME_EMAIL + " TEXT," +
                EtudiantEntry.COLUMN_NAME_LOGIN + " TEXT," +
                EtudiantEntry.COLUMN_NAME_MDP + " TEXT"
                + ")";
        public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + EtudiantEntry.TABLE_NAME;


}
