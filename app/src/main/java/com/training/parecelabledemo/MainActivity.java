package com.training.parecelabledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private Button saveSerializableButton;
    private Button saveParecelableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameEditText = findViewById(R.id.firstname_edit_text);
        lastNameEditText = findViewById(R.id.last_name_edit_text);
        saveSerializableButton = findViewById(R.id.save_button_serializable);
        saveParecelableButton = findViewById(R.id.save_button_parcelable);

        saveParecelableButton.setOnClickListener(this);
        saveSerializableButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_button_parcelable:
                String firstName = !firstNameEditText.getText().toString().isEmpty() ? firstNameEditText.getText().toString() : "";
                String lastName = !lastNameEditText.getText().toString().isEmpty() ? lastNameEditText.getText().toString() : "";
                Person person = new Person(firstName, lastName, 22);

                startSecondActivityParcelabe(person);
                break;
            case R.id.save_button_serializable:

                String firstName2 = !firstNameEditText.getText().toString().isEmpty() ? firstNameEditText.getText().toString() : "";
                String lastName2 = !lastNameEditText.getText().toString().isEmpty() ? lastNameEditText.getText().toString() : "";
                Employee employee = new Employee(firstName2, lastName2);

                startSecondActivitySerializable(employee);

                break;
        }
    }

    private void startSecondActivityParcelabe(Person person) {
        if (!person.getFirstName().isEmpty() && !person.getLastName().isEmpty()) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(SecondActivity.PERSON_EXTRA, person);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Fields cannot be empty.", Toast.LENGTH_SHORT).show();
        }
    }

    private void startSecondActivitySerializable(Employee employee) {
        if (!employee.getFirstName().isEmpty() && !employee.getLastName().isEmpty()) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(SecondActivity.EMPLOYEE_EXTRA, employee);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Fields cannot be empty.", Toast.LENGTH_SHORT).show();
        }
    }
}
