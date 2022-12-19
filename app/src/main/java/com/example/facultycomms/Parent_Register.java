package com.example.facultycomms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(student_name.getText().toString().length()<=2)
                {
                    Toast.makeText(getApplicationContext(), "Please Enter the Valid Student Name", Toast.LENGTH_LONG).show();
                }
                else if((roll_number.getText().toString().length()==0))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter the Reg number", Toast.LENGTH_LONG).show();
                }
                else if ((user_name.getText().toString().length()==0))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter the Username", Toast.LENGTH_LONG).show();
                }
                else if ((parent_name.getText().toString().length()==0))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter the Parent name", Toast.LENGTH_LONG).show();
                }
                else if ((mobile_number.getText().toString().length()==0))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter the Mobile Number", Toast.LENGTH_LONG).show();
                }
                else if ((email_id.getText().toString().length()==0))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter your Mail Address", Toast.LENGTH_LONG).show();
                }
                else if ((password.getText().toString().length()==0))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Password", Toast.LENGTH_LONG).show();
                }
                else
                {
                    String stname=student_name.getText().toString();
                    String stmno=mobile_number.getText().toString();
                    String strno=roll_number.getText().toString();
                    String stpnm=parent_name.getText().toString();
                    String stuser=user_name.getText().toString();
                    String stmail=email_id.getText().toString();
                    String stpass=password.getText().toString();
                    String stdegree=dropdown.getSelectedItem().toString();

                    userDbHelper.addParent(new Parent(stname, stmail, stmno, stdegree, stpnm, stuser, stpass, strno));

                    Toast.makeText(getApplicationContext(), "You have Registered Successfully", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Parent_Register.this, MainActivity.class);
                    startActivity(i);
                }
                dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {

                        Toast.makeText(getApplicationContext(), dropdown.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                        Toast.makeText(getApplicationContext(),"Please Select an option", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}