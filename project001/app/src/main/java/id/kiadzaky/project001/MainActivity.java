package id.kiadzaky.project001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // langkah 1  membuat object : properties / variabel dan methods / function
    //global variabel: variabel bisa dipakai dalam 1 class
    private Button btn_toast, btn_counter_plus, btn_counter_minus, btn_reset;
    private TextView txt_display_view;
    private int my_value = 0; // nilai awal counter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // langkah 2 : mengenalkan global variabel dengan id dalam layout

        btn_toast = findViewById(R.id.btn_toast);
        btn_counter_plus = findViewById(R.id.btn_counter_plus);
        btn_counter_minus = findViewById(R.id.btn_counter_minus);
        btn_reset = findViewById(R.id.btn_reset);
        txt_display_view = findViewById(R.id.txt_display_view);

        //langkah 3 : event handling

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // kode perintah dalam btn toast
                Toast.makeText(MainActivity.this, "Halo Kamu Siapa?", Toast.LENGTH_LONG).show();
            }
        });
        btn_counter_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my_value += 1;
                if (txt_display_view != null) {
                    // data yg ditampilkan harus string, jadi di parsing
                    txt_display_view.setText(Integer.toString(my_value));
                }
            }
        });
        btn_counter_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my_value--;
                if (txt_display_view != null) {
                    // data yg ditampilkan harus string, jadi di parsing
                    txt_display_view.setText(Integer.toString(my_value));
                }
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my_value = 0;
                if (txt_display_view != null) {
                    // data yg ditampilkan harus string, jadi di parsing
                    txt_display_view.setText(Integer.toString(my_value));
                }
            }
        });
    }
}