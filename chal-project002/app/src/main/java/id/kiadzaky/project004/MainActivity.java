package id.kiadzaky.project004;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import id.kiadzaky.project004.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_share:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Download Aplikasi");
                i.putExtra(Intent.EXTRA_TEXT, "Dapatkan Diskon 10000");
                startActivity(Intent.createChooser(i, "Bagikan Aplikasi Ini"));
                break;
            case R.id.menu_exit:
                System.exit(1);
            default:
                Toast.makeText(this, "ERROR, Please Select Option", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        // custom toolbar
        setSupportActionBar(binding.toolbar);

        //default fragment dibuka pertama kali
        getSupportActionBar().setTitle("HOME");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, new HomeFragment())
                .commit();
        binding.navView.setCheckedItem(R.id.nav_home);

        //membuka drawer
        toggle = new ActionBarDrawerToggle(this, binding.drawer, binding.toolbar,
                R.string.open, R.string.close);
        // drawer back button
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        // sinkronisasi drawer

        toggle.syncState();

        // salah satu menu navigasi dipilih

        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment fragment = null;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        getSupportActionBar().setTitle("HOME Page");
                        binding.drawer.closeDrawer(GravityCompat.START);
                        callFragment(fragment);
                        break;
                    case R.id.nav_contact:
                        fragment = new ContactUsFragment();
                        getSupportActionBar().setTitle("CONTACT Page");
                        binding.drawer.closeDrawer(GravityCompat.START);
                        callFragment(fragment);
                        break;
                    case R.id.nav_about_us:
                        fragment = new AboutUsFragment();
                        getSupportActionBar().setTitle("ABOUT Page");
                        binding.drawer.closeDrawer(GravityCompat.START);
                        callFragment(fragment);
                        break;
                    case R.id.nav_galley:
                        fragment = new GalleryFragment();
                        getSupportActionBar().setTitle("GALLERY Page");
                        binding.drawer.closeDrawer(GravityCompat.START);
                        callFragment(fragment);
                        break;
                    case R.id.nav_employee:
                        fragment = new EmployeeFragment();
                        getSupportActionBar().setTitle("Employee Page");
                        binding.drawer.closeDrawer(GravityCompat.START);
                        callFragment(fragment);
                        break;
                    case R.id.nav_customer:
                        fragment = new GalleryFragment();
                        getSupportActionBar().setTitle("Customer Page");
                        binding.drawer.closeDrawer(GravityCompat.START);
                        callFragment(fragment);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Please Select Menu", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });


    }

    private void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
        );
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(null); // supaya nanti dia bisa saling bergantian
        transaction.commit();
    }
}