package id.kiadzaky.project002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // life cycle activity
    public Toast myToast = null;
    private Button btn_move_second, btn_implicit;
    private EditText input_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(getApplicationContext(), "Ini On Create Activity", Toast.LENGTH_LONG).show();
        myToast = Toast.makeText(MainActivity.this,"onCreate",Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.CENTER,0,0);
        myToast.show();

        btn_move_second = findViewById(R.id.btn_move_second);
        btn_implicit = findViewById(R.id.btn_implicit);
        input_name = findViewById(R.id.input_name);

        btn_implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implicit intent
                Intent implicit = new Intent(Intent.ACTION_VIEW);
                implicit.setData(Uri.parse("http://google.com"));
                startActivity(implicit);
            }
        });

        btn_move_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //explicit, karena ada source dan destination
                String fullname = input_name.getText().toString(); //variabel nampung get data input-an
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("fullname", fullname);

                startActivity(i);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Ini On Start Activity", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Ini On Resume Activity", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Ini On Pause Activity", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Ini On Stop Activity", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Ini On Restart Activity", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(getApplicationContext(), "Ini On Destroy Activity", Toast.LENGTH_LONG).show();
        myToast = Toast.makeText(MainActivity.this,"Ini On Destroy Activity",Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.CENTER,0,0);
        myToast.show();
    }
}