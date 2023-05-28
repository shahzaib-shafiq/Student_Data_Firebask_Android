package com.example.firebasetask;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasetask.MyAdapter;
import com.example.firebasetask.R;
import com.example.firebasetask.Users;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RetriveData extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter mainAdapter;

    SearchView searchView;
    FirebaseDatabase database;
    Users users;


    ArrayList<Users> list;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_data);
        database=FirebaseDatabase.getInstance("https://studentfirebase-883ab-default-rtdb.firebaseio.com/");
        reference=database.getReference("students");



        reference.child("3");
    }



    @Override
    protected void onStart() {
        super.onStart();
        if(reference!=null)
        {
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if(snapshot.exists())
                    {

                        list=new ArrayList<>();
                        for (DataSnapshot ds: snapshot.getChildren())
                        {


                            list.add(ds.getValue(Users.class));


                        }
                        MyAdapter myAdapter= new MyAdapter(list);
                        recyclerView=findViewById(R.id.rv);
                        searchView = findViewById(R.id.SearchView);
                        recyclerView.setAdapter(myAdapter);


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        if(searchView!=null)
        {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;

                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return true;
                }
            });
        }
    }

    private  void search(String str)
    {
        ArrayList<Users> myList = new ArrayList<>();
        for (Users object:list)
        {
            if(object.getName().toLowerCase().contains(str.toLowerCase()))
            {
                myList.add(object);

            }
        }
        MyAdapter myAdapter=new MyAdapter(myList);
        recyclerView.setAdapter(myAdapter);
    }
}
