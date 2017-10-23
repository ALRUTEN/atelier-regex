package com.example.bastienwcs.atelierregex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText age = (EditText) findViewById(R.id.age);
        final EditText address = (EditText) findViewById(R.id.address);
        final EditText email = (EditText) findViewById(R.id.email);
        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isNameOk = false;
                String nameContent = name.getText().toString();
                Pattern pattern = Pattern.compile("^[\\-a-zA-Z ]+$");
                Matcher m = pattern.matcher(nameContent);
                while (m.find()) {
                    isNameOk = true;
                }

                if (!isNameOk) {
                    name.setError(getResources().getString(R.string.error_name));
                }

                boolean isAgeOk = false;
                String ageContent = age.getText().toString();
                Pattern pattern1 = Pattern.compile("^[0-9]{3}+$");
                Matcher m1 = pattern1.matcher(ageContent);
                while (m1.find()) {
                    isNameOk = true;
                }

                if (!isAgeOk) {
                    age.setError(getResources().getString(R.string.error_age));
                }

                boolean isAddressOk = false;
                String adresseContent = age.getText().toString();
                Pattern pattern2 = Pattern.compile("[0-9]{1,3}(?:(?:[,. ]){1}[-a-zA-Zàâäéèêëïîôöùûüç]+)*");
                Matcher m2 = pattern2.matcher(adresseContent);
                while (m2.find()) {
                    isNameOk = true;
                }

                if (!isAddressOk) {
                    address.setError(getResources().getString(R.string.error_address));
                }

                boolean isEmailOk = false;
                String emailContent = age.getText().toString();
                Pattern pattern3 = Pattern.compile("^[\\w.-]+@[\\w.-]{2,}\\.[a-z]{2,5}$\n");
                Matcher m3 = pattern3.matcher(emailContent);
                while (m3.find()) {
                    isNameOk = true;
                    if (!isEmailOk) {
                        email.setError(getResources().getString(R.string.error_email));
                    }

                    if (isNameOk && isAgeOk && isAddressOk && isEmailOk) {
                        Toast.makeText(MainActivity.this,
                                getResources().getString(R.string.success), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}


