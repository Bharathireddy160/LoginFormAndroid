package com.example.aptask;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
TextView tvDate;
Button btnNext;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
tvDate = findViewById(R.id.tvDate);
btnNext = findViewById(R.id.btnNext);
// Set current date
String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
tvDate.setText(currentDate);
// Next button ? open form
btnNext.setOnClickListener(v -> {
Intent intent = new Intent(MainActivity.this, FormActivity.class);
startActivity(intent);
});
}
}