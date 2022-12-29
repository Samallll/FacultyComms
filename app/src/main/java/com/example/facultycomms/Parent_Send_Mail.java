package com.example.facultycomms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Parent_Send_Mail extends AppCompatActivity {

    private EditText recipient;
    private EditText subject;
    private EditText parent_name;
    private EditText f_email;
    private EditText body;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_send_mail);

        String c,staffMailId;
        UserDbHelper userDbHelper=new UserDbHelper(this);

        recipient = findViewById(R.id.faculty_name);
        parent_name = findViewById(R.id.parent_name);
        subject =  findViewById(R.id.subject);
        body =  findViewById(R.id.body);
        sendEmail =  findViewById(R.id.send_mail);
        f_email = findViewById(R.id.faculty_mail_id);

        c = recipient.getText().toString();

        staffMailId = userDbHelper.staffEmailAddress(c);
        f_email.setText(staffMailId);
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
                f_email.setText("");
                parent_name.setText("");
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
            Toast.makeText(Parent_Send_Mail.this, "No email client installed.",Toast.LENGTH_LONG).show();
        }

    }
}