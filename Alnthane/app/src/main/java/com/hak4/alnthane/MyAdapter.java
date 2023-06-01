package com.hak4.alnthane;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> mList;
    Context context;

    public MyAdapter(Context context , ArrayList<Model> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = mList.get(position);
        holder.yazar.setText(model.getYazar());
        holder.kitapismi.setText(model.getKitapismi());
        holder.alinti.setText(model.getAlinti());
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView yazar , kitapismi , alinti;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            yazar = itemView.findViewById(R.id.text_View_title);
            kitapismi = itemView.findViewById(R.id.text_View_kitapismi);
           alinti = itemView.findViewById(R.id.text_View_icerik);
        }
    }
}
