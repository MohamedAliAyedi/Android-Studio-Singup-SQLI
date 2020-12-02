package com.example.sqlite_pfe;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<etudiant> arrayList;
    private TextView lname, fname;
    public MyAdapter(Context context, ArrayList<etudiant> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.ligne_etudiant, parent, false);
        fname = convertView.findViewById(R.id.nometud);
        lname = convertView.findViewById(R.id.preetud);


        fname.setText(arrayList.get(position).getFname());
        lname.setText(arrayList.get(position).getLname());
        return convertView;
    }
}