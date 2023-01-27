package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDial, btnMsg, btnEmail, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnMsg = findViewById(R.id.btnMsg);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Method for dialling a no.
                Intent iDial = new Intent(Intent.ACTION_DIAL);

                //To convert string formatted data into Uri (Uniform Resource Identifier)
                iDial.setData(Uri.parse("tel: +918888877777"));
                startActivity(iDial);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("+918888877777")));
                iMsg.putExtra("sms_body", "Please solve this issue asap.");
                startActivity(iMsg);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);

                //Particular type to open an email client
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmail.com","xyz@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Queries" );
                iEmail.putExtra(Intent.EXTRA_TEXT, "Please resolve this issue asap.");
                startActivity(Intent.createChooser(iEmail, "Email via"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "Download this Amazing App, ");
                startActivity(Intent.createChooser(iShare, "Share via"));
            }
        });

    }
}