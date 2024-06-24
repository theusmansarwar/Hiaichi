package com.usmansarwar.hiaichi;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.usmansarwar.hiaichi.Models.Model;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    List<Model> list;
    Activity activity;

    public Adapter(List<Model> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.items_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Model model= list.get(position);
        holder.tittle.setText(model.getTittle());
        holder.lacture.setText(model.getLacture());
        holder.course.setText(model.getCourse());
      holder.videoid.setText(model.getVideoid());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(activity, Show_Detail.class);
                intent.putExtra("Tittle", model.getTittle());
               intent.putExtra("Lacture",model.getLacture());
               intent.putExtra("Course", model.getCourse());
                intent.putExtra("Videoid",model.getVideoid());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tittle, lacture, course,videoid;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tittle= itemView.findViewById(R.id.Videotittle);
            lacture= itemView.findViewById(R.id.lacturenumber);
            videoid= itemView.findViewById(R.id.Videoid);
            course= itemView.findViewById(R.id.videocategory);
        }
    }
}
