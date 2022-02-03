package id.kiadzaky.project003;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class CustomAppbarActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_appbar);
        toolbar = findViewById(R.id.toolbar_display_activity);
        setSupportActionBar(toolbar); // event handling untuk toolbar
    }

    //menampilkan option menu pada toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //event handling option menu diklik
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                Intent i = new Intent(CustomAppbarActivity.this, SettingsActivity.class);
                startActivity(i);
                break;
            case R.id.menu_camera:
                Toast.makeText(this, "Ini Camera", Toast.LENGTH_SHORT).show();
//                System.exit(1);
                break;
            case R.id.menu_search:
                Toast.makeText(this, "Ini Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_gallery:
                Toast.makeText(this, "Ini Gallery", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_label:
                Toast.makeText(this, "Ini Label", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Ga ada Menu", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}