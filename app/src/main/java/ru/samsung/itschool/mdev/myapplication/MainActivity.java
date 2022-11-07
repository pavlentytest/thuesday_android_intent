package ru.samsung.itschool.mdev.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn, btn2;
    public static final String KEY = "ccc";
    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == MainActivity2.RESULT_CODE) {
                    Toast.makeText(getApplicationContext(),
                                    result.getData().getStringExtra(MainActivity2.KEY2),
                                    Toast.LENGTH_LONG).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn.setOnClickListener(view -> {
            // неявное намерение
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String url = "https://www.mirea.ru/";
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
        btn2.setOnClickListener(view -> {
            // явное намерение
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra(KEY,"Hello from MainActivity");
            //startActivity(intent);
            launcher.launch(intent);
        });

    }

    /* @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
    }*/
}