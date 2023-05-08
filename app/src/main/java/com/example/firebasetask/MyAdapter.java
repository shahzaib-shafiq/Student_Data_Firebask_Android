package com.example.firebasetask;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<Users> StudentArrayList;
    Context context;

    public MyAdapter(ArrayList<Users> studentArrayList, Context context) {
        StudentArrayList = studentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_by_cgpa,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.regNo.setText(StudentArrayList.get(position).getReg_No());
        holder.name.setText(StudentArrayList.get(position).getName());
        holder.email.setText(StudentArrayList.get(position).getEmail());
        holder.cgpa.setText(StudentArrayList.get(position).getcGPA());
        holder.dept.setText(StudentArrayList.get(position).getDept());
    }

    @Override
    public int getItemCount() {
        return StudentArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView regNo,name,cgpa,dept,email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            regNo = itemView.findViewById(R.id.txtregno);
            name = itemView.findViewById(R.id.txtname);
            cgpa = itemView.findViewById(R.id.txtcgpa);
            dept = itemView.findViewById(R.id.txtdept);
            email = itemView.findViewById(R.id.txtemail);
        }
    }
}