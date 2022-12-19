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

public class Staff_Register extends AppCompatActivity {

    Spinner dropDown;
    EditText staff_name,staff_id;
    EditText user_name,mobile_no;
    EditText mail_id, password;
    Button register_staff;
    UserDbHelper userDbHelper = new UserDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_register);

        staff_name=findViewById(R.id.faculty_name);
        user_name=findViewById(R.id.staff_user_name);
        mail_id=findViewById(R.id.staff_mail_id);
        password=findViewById(R.id.staff_password);
        mobile_no=findViewById(R.id.contact_number);
        register_staff=findViewById(R.id.staff_register);
        dropDown =findViewById(R.id.staff_degree);
        staff_id = findViewById(R.id.faculty_id);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.degree, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        dropDown.setAdapter(adapter);

        register_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(staff_name.getText().toString().length()<=2)
                {
                    Toast.makeText(getApplicationContext(), "Please Enter the Valid Staff Name", Toast.LENGTH_LONG).show();
                }
                else if ((user_name.getText().toString().length()==0))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter the Username", Toast.LENGTH_LONG).show();
                }
                else if ((mobile_no.getText().toString().length()==0))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter the Mobile Number", Toast.LENGTH_LONG).show();
                }
                else if ((mail_id.getText().toString().length()==0))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter your Mail Address", Toast.LENGTH_LONG).show();
                }
                else if ((password.getText().toString().length()==0))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Password", Toast.LENGTH_LONG).show();
                }
                else
                {
                    String stname=staff_name.getText().toString();
                    String stmno=mobile_no.getText().toString();
                    String stuser=user_name.getText().toString();
                    String stmail=mail_id.getText().toString();
                    String stpass=password.getText().toString();
                    String stid=staff_id.getText().toString();
                    String stdegree=dropDown.getSelectedItem().toString();

                    userDbHelper.addStaff(new Staff(stname,stmail, stmno, stdegree, stuser, stpass, stid));

                    Toast.makeText(getApplicationContext(), "You have Registered Successfully", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Staff_Register.this, MainActivity.class);
                    startActivity(i);
                }
                dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {

                        Toast.makeText(getApplicationContext(), dropDown.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

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