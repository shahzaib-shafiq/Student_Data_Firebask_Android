package com.example.firebasetask;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.firebasetask.R;
import com.example.firebasetask.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Objects;

public class RetriveData extends AppCompatActivity {

    EditText cgpaSearch,deptSearch;
    RecyclerView recyclerView,recyclerView1;
    ArrayList<Users> studentList = new ArrayList<Users>();

    ArrayList<Users> reqStudentList = new ArrayList<Users>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_data);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        cgpaSearch = findViewById(R.id.edtrecstu);
        deptSearch = findViewById(R.id.edtrecept);
        cgpaSearch.setText("0");
        deptSearch.setText("Dept");
        recyclerView = findViewById(R.id.recyclerViewcgpa);
        recyclerView1 = findViewById(R.id.recyclerViewdept);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager2);
        recyclerView1.setHasFixedSize(true);
    }

    public void Search_Stuent_With_Cgpa(View view) {
        Populate_RecyclerView(true,false);
    }

    public void Search_Stuent_With_Dept(View view) {
        Populate_RecyclerView(false,true);
    }

    private void Populate_RecyclerView(boolean isCgpa,boolean isDept){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Student");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Users student=new Users();
                    String Id  = snapshot.getKey();
                    student.setReg_No(Id);
                    student.setName(Objects.requireNonNull(snapshot.child("regNo").getValue()).toString());
                    student.setName(Objects.requireNonNull(snapshot.child("name").getValue()).toString());
                    student.setcGPA(Objects.requireNonNull(snapshot.child("cgpa").getValue()).toString());
                    student.setDept(Objects.requireNonNull(snapshot.child("dept").getValue()).toString());
                    student.setEmail(Objects.requireNonNull(snapshot.child("email").getValue()).toString());
                    studentList.add(student);
                }
                if(Float.parseFloat(cgpaSearch.getText().toString()) >= 3.00 && isCgpa == true && isDept == false){
                    reqStudentList.clear();
                    for(Users student : studentList){
                        if(Float.parseFloat(student.getcGPA().toString())>=3.00){
                            reqStudentList.add(student);
                        }
                    }
                    studentList.clear();
                    MyAdapter sortWithCgpa = new MyAdapter(reqStudentList,getApplicationContext());
                    recyclerView.setAdapter(sortWithCgpa);
                    sortWithCgpa.notifyDataSetChanged();
                }
                else if(Float.parseFloat(cgpaSearch.getText().toString()) <= 1.99 && isCgpa == true && isDept == false){
                    reqStudentList.clear();
                    for(Users student : studentList){
                        if(Float.parseFloat(student.getcGPA().toString())<=1.99){
                            reqStudentList.add(student);
                        }
                    }
                    studentList.clear();
                    MyAdapter sortWithCgpa = new MyAdapter(reqStudentList,getApplicationContext());
                    recyclerView.setAdapter(sortWithCgpa);
                    sortWithCgpa.notifyDataSetChanged();
                }
                else if(deptSearch.getText().toString().toUpperCase().equals("CS") && isDept  == true && isCgpa == false){
                    Log.d("TAG", "onDataChange: here"+deptSearch.getText().toString().toUpperCase() + isDept + isCgpa);
                    reqStudentList.clear();
                    for(Users student : studentList){
                        if(student.getDept().toString().toUpperCase().equals("CS")){
                            reqStudentList.add(student);
                            Log.d("TAG", "onDataChange: "+ reqStudentList.get(0).getDept());
                        }
                    }
                    studentList.clear();
                    MyAdapter sortWithDept = new MyAdapter(reqStudentList,getApplicationContext());
                    recyclerView1.setAdapter(sortWithDept);
                    sortWithDept.notifyDataSetChanged();
                } else if (deptSearch.getText().toString().toUpperCase().equals("SE")  && isDept  == true && isCgpa == false) {
                    reqStudentList.clear();
                    for(Users student : studentList){
                        if(student.getDept().toString().toUpperCase().equals("SE")){
                            reqStudentList.add(student);
                        }
                    }
                    studentList.clear();
                    MyAdapter sortWithDept = new MyAdapter(reqStudentList,getApplicationContext());
                    recyclerView1.setAdapter(sortWithDept);
                    sortWithDept.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }
    public void Menu(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}