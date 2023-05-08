    package com.example.firebasetask;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class MainActivity extends AppCompatActivity {

        TextView textView;
        String firstname,lastname,age,username;
        Users users;

        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }

        public void InsertData(View view) {
                Intent intent = new Intent(this,InsertData.class);
               startActivity(intent);

        }

    public void DeleteData(View view) {

    Intent intent=new Intent(this,DeleteData.class);
    startActivity(intent);
    }

    public void UpdataData(View view) {

            Intent intent = new Intent(this,UpdateData.class);
            startActivity(intent);

    }

    public void GetReports(View view) {

        Intent intent = new Intent(this,RetriveData.class);

        startActivity(intent);


    }
}