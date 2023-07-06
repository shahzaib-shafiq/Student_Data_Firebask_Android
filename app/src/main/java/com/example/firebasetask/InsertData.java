package com.example.firebasetask;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class InsertData extends AppCompatActivity {


    FirebaseDatabase database;

    DatabaseReference reference;
    Button InsertData,Back;

    String id="1";

    String name,dept,reg_No,cGPA,email;
    EditText Name,Dept,Reg_No,CGPA,Email;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        InsertData=findViewById(R.id.btninsertdata);
        Name=findViewById(R.id.uploadName);
        Dept=findViewById(R.id.uploadDept);
        Reg_No=findViewById(R.id.uploadReg_No);
        CGPA=findViewById(R.id.uploadCGPA);
        Email=findViewById(R.id.uploadEmail);

       //reference.removeValue();


   }

    public void EnterData(View view) {

        name=Name.getText().toString();
        dept=Dept.getText().toString();
        reg_No=Reg_No.getText().toString();
        cGPA=CGPA.getText().toString();
        email=Email.getText().toString();

        Users users=new Users(name,dept,reg_No,cGPA,email);

        database=FirebaseDatabase.getInstance("https://studentfirebase-883ab-default-rtdb.firebaseio.com/");
        reference=database.getReference("students");
        reference.child(reg_No).setValue(users);

    }

    public void ReturntoMain(View view) {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}