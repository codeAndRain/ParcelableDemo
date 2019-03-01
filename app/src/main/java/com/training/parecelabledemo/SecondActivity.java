package com.training.parecelabledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String PERSON_EXTRA = "PERSON_EXTRA";
    public static final String EMPLOYEE_EXTRA = "EMPLOYEE_EXTRA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView detailTextView = findViewById(R.id.details_textview);

        setupToolbar();

        Intent intent = getIntent();

        if (intent.hasExtra(PERSON_EXTRA)) {
            getPersonExtra(detailTextView, intent);
        } else if (intent.hasExtra(EMPLOYEE_EXTRA)) {
            getEmployeeExtra(detailTextView, intent);
        }
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void getPersonExtra(TextView detailTextView, Intent intent) {
        if (intent.getExtras() != null) {
            Person person = intent.getExtras().getParcelable(PERSON_EXTRA);
            if (person != null) {
                String detailMessage = " Welcome " + person.getFirstName() + " " + person.getLastName();

                detailTextView.setText(detailMessage);
            }
        }
    }

    private void getEmployeeExtra(TextView detailsTextView, Intent intent) {
        if (intent.getExtras() != null) {
            Employee employee = (Employee) intent.getExtras().getSerializable(EMPLOYEE_EXTRA);
            if (employee != null) {
                String detailMessage = " Welcome " + employee.getFirstName() + " " + employee.getLastName();

                detailsTextView.setText(detailMessage);
            }
        }
    }
}
