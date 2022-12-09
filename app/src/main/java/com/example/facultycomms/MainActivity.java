package com.example.facultycomms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user_Name;
    private EditText password;
    private RadioGroup radioGroup;
    private RadioButton radioGroup_Value;
    private Button login;
    private Button parent_Registration;
    private Button staff_Registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_Name = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        radioGroup = findViewById(R.id.select_option);
        password.setText("");
        login = findViewById(R.id.email_sign_in_button);
        parent_Registration = findViewById(R.id.parent_registration);
        staff_Registration = findViewById(R.id.staff_registration);
        login.setOnClickListener(this);
        parent_Registration.setOnClickListener(this);
        staff_Registration.setOnClickListener(this);
    }

    public void onRadioButtonClicked(View view){
        int value = radioGroup.getCheckedRadioButtonId();
        radioGroup_Value = findViewById(value);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        if(view == login)
        {
            Toast.makeText(this, "Logged in Successfully", Toast.LENGTH_LONG).show();
        }
        if(view == parent_Registration)
        {
            i = new Intent(this,Parent_Register.class);
            startActivity(i);
        }
        if(view == staff_Registration)
        {
            i = new Intent(this,Staff_Register.class);
            startActivity(i);
        }
    }
}