package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv;
    private Button btn3;
    public static final String KEY2 = "vvv";
    public static final int RESULT_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.textView);
        btn3 = findViewById(R.id.button3);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            tv.setText(bundle.getString(MainActivity.KEY));
        }
        btn3.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(KEY2,"Data from MainActivity2");
            setResult(RESULT_CODE, intent);
            finish();
        });
    }
}