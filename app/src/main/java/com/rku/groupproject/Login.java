package com.rku.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    String pattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText name=findViewById(R.id.editUser);
        final EditText password=findViewById(R.id.editPass);
        Button login=findViewById(R.id.submit);

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String email=name.getText().toString();
                String pass=password.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(Login.this,"Please Enter Username!",Toast.LENGTH_SHORT).show();
                }
                else if(!email.matches(pattern)){
                    Toast.makeText(Login.this,"Invalid Username!!",Toast.LENGTH_SHORT).show();
                }
                else if(pass.isEmpty()){
                    Toast.makeText(Login.this,"Please Enter Password!",Toast.LENGTH_SHORT).show();
                }
                else if((email.equals("admin@gmail.com"))&&(pass.equals("admin"))){
                    Intent intent=new Intent(Login.this,AboutUs.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Login.this,"Incorrect Username or Password!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}