package com.example.firebasetask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteData extends AppCompatActivity {

    FirebaseDatabase database;

    DatabaseReference reference;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

    editText=findViewById(R.id.txtdelete);


        database=FirebaseDatabase.getInstance("https://studentfirebase-883ab-default-rtdb.firebaseio.com/");
        reference=database.getReference("students");

    }



    public void DeleteStudent(View view) {
        String userid=editText.getText().toString();
        reference.child(userid).removeValue();

    }

    public void Reurntomain(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}