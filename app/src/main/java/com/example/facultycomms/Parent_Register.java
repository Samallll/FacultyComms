package com.example.facultycomms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public abstract class Parent_Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner dropdown;
    EditText student_name;
    EditText roll_number;
    EditText user_name,mobile_number;
    EditText email_id, password,parent_name;
    Button register;
    UserDbHelper userDbHelper = new UserDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_register);

        student_name=findViewById(R.id.student_name);
        roll_number=findViewById(R.id.student_roll_number);
        user_name=findViewById(R.id.user_name);
        email_id=findViewById(R.id.parent_mail_id);
        password=findViewById(R.id.parent_password);
        mobile_number=findViewById(R.id.contact_number);
        parent_name=findViewById(R.id.parent_name);
        register=findViewById(R.id.parent_register);
        dropdown =findViewById(R.id.student_degree);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.degree, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        dropdown.setAdapter(adapter);

    }
}