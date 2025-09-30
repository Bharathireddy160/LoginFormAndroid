package com.example.aptask;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

EditText etName, etPin, etEmail;
RadioGroup rgGender;
CheckBox cbJava, cbPython, cbAndroid;
Spinner spYear;
Button btnPrev, btnSubmit;

@Override



protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_form);

etName = findViewById(R.id.etName);
etPin = findViewById(R.id.etPin);
etEmail = findViewById(R.id.etEmail);
rgGender = findViewById(R.id.rgGender);
cbJava = findViewById(R.id.cbJava);
cbPython = findViewById(R.id.cbPython);
cbAndroid = findViewById(R.id.cbAndroid);
spYear = findViewById(R.id.spYear);
btnPrev = findViewById(R.id.btnPrev);
btnSubmit = findViewById(R.id.btnSubmit);

// Spinner values
String[] years = {&quot;2023&quot;, &quot;2024&quot;, &quot;2025&quot;, &quot;2026&quot;};
ArrayAdapter&lt;String&gt; adapter = new ArrayAdapter&lt;&gt;(this,
android.R.layout.simple_spinner_item, years);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spYear.setAdapter(adapter);


// Prev Button
btnPrev.setOnClickListener(v -> finish());

// Submit Button
btnSubmit.setOnClickListener(v -> {
String name = etName.getText().toString();
String pin = etPin.getText().toString();
String email = etEmail.getText().toString();

int genderId = rgGender.getCheckedRadioButtonId();
RadioButton selectedGender = findViewById(genderId);
String gender = (selectedGender != null) ? selectedGender.getText().toString() : &quot;Not Selected&quot;;

StringBuilder courses = new StringBuilder();
if (cbJava.isChecked()) courses.append(&quot;Java &quot;);
if (cbPython.isChecked()) courses.append(&quot;Python &quot;);
if (cbAndroid.isChecked()) courses.append(&quot;Android &quot;);

String year = spYear.getSelectedItem().toString();

String result = &quot;Name: &quot; + name + &quot;\nPIN: &quot; + pin + &quot;\nEmail: &quot; + email +
&quot;\nGender: &quot; + gender + &quot;\nCourses: &quot; + courses +



&quot;\nYear: &quot; + year;

Intent intent = new Intent(FormActivity.this, ResultActivity.class);
intent.putExtra(&quot;result&quot;, result);
startActivity(intent);

Toast.makeText(FormActivity.this, &quot;Submitted Successfully&quot;, Toast.LENGTH_SHORT).show();
});
}
}