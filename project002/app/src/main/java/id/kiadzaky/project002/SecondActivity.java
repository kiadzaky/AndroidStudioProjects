package id.kiadzaky.project002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button btn_move_third, btn_back_main;
    private TextView get_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_move_third = findViewById(R.id.btn_move_third);
        btn_back_main = findViewById(R.id.btn_back_main);
        get_name = findViewById(R.id.get_name);

        //menerima data dari main activity

        Intent intent_get_name = getIntent();
        String var_get_name = intent_get_name.getStringExtra("fullname");

        // menampilkan data
        get_name.setText(var_get_name);
        btn_move_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(i);
            }
        });

        btn_back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}