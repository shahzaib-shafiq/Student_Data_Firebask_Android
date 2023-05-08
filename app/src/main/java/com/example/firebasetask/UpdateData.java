package com.example.firebasetask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class UpdateData extends AppCompatActivity {

    FirebaseDatabase database;

    DatabaseReference reference;
    String name,dept,reg_No,cGPA,email;
    EditText Name,Dept,Reg_No,CGPA,Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        database=FirebaseDatabase.getInstance("https://studentfirebase-883ab-default-rtdb.firebaseio.com/");
        reference=database.getReference("students");

        Name=findViewById(R.id.updateName);
        Dept=findViewById(R.id.updateDept);
        Reg_No=findViewById(R.id.updateReg_No);
        CGPA=findViewById(R.id.updateCGPA);
        Email=findViewById(R.id.updateEmail);




    }

    public void UpdateData(View view)
    {
        name=Name.getText().toString();
        dept=Dept.getText().toString();
        reg_No=Reg_No.getText().toString();
        cGPA=CGPA.getText().toString();
        email=Email.getText().toString();

        updateData(name,dept,reg_No,cGPA,email);
        

    }

    private void updateData(String name, String dept, String reg_no, String cGPA, String email) {


        HashMap user = new HashMap<>();
        user.put("name",name);
        user.put("dept",dept);
        user.put("cGPA",cGPA);
        user.put("email",email);



        reference.child(reg_no).updateChildren(user).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
               if (task.isSuccessful())
               {
                   Name.setText("");
                   Dept.setText("");
                   Reg_No.setText("");
                   CGPA.setText("");
                   Email.setText("");


               }
            }
        });

    }

    public void ReturntoMain(View view) {

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}