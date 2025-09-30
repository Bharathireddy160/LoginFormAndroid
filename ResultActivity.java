package com.example.aptask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

TextView tvResult;
Button btnBack;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_result);

tvResult = findViewById(R.id.tvResult);
btnBack = findViewById(R.id.btnBack);


// Get submitted data
String result = getIntent().getStringExtra("result");
if (result != null && !result.isEmpty()) {
tvResult.setText(result);
}

btnBack.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
finish();
}
}
);}
}