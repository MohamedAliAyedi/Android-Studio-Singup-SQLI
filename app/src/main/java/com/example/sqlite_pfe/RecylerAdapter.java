package com.example.sqlite_pfe;


import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.List;

public class RecylerAdapter extends RecyclerView.Adapter <RecylerAdapter.ViewHolder> {

    public  static class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView fname,lname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fname = itemView.findViewById(R.id.nometud);
            lname = itemView.findViewById(R.id.preetud);

        }
    }
    private Context context;
    private List<etudiant> Letudiant;
    public RecylerAdapter (Context c , List<etudiant> EtudiantList){
        this.context = c;
        this.Letudiant = EtudiantList;
    }

    @Override
    public RecylerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.ligne_etudiant,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        etudiant p = Letudiant.get(position);
        holder.fname.setText(p.getFname());
        holder.lname.setText(p.getLname());
    }

    @Override
    public int getItemCount() {
        return Letudiant.size();
    }
}
