package com.example.facultycomms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Staff_Send_Mail extends AppCompatActivity {

    private EditText recipient;
    private EditText subject;
    private EditText faculty_name;
    private EditText p_email;
    private EditText body;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_send_mail);

        String c,parentMailId;
        UserDbHelper userDbHelper=new UserDbHelper(this);

        recipient = findViewById(R.id.parent_name);
        faculty_name = findViewById(R.id.faculty_name);
        subject =  findViewById(R.id.subject);
        body =  findViewById(R.id.body);
        sendEmail =  findViewById(R.id.send_mail);
        p_email = findViewById(R.id.parent_mail_id);

        c = recipient.getText().toString();

        parentMailId = userDbHelper.parentEmailAddress(c);
        p_email.setText(parentMailId);
        sendEmail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sendEmail();
                // clear the fields
                recipient.setText("");
                subject.setText("");
                body.setText("");
                p_email.setText("");
                faculty_name.setText("");
            }
        });
    }
    private void sendEmail()
    {
        String[] recipients = {recipient.getText().toString()};
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        // prompts email clients only
        email.setDataAndType(Uri.parse("mailto:"),"message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL, recipients);
        email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
        email.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
        try
        {
            // the user can choose the email client
            startActivity(Intent.createChooser(email, "Choose an email client from..."));
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(Staff_Send_Mail.this, "No email client installed.",Toast.LENGTH_LONG).show();
        }
    }
}