package id.kiadzaky.individual_task.ui.peserta;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import id.kiadzaky.individual_task.Konfiguration;
import id.kiadzaky.individual_task.R;

public class AddPesertaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_peserta);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tambah Peserta");

        WebView web_view_add_peserta = findViewById(R.id.web_view_add_peserta);
        web_view_add_peserta.getSettings().setLoadsImagesAutomatically(true);
        web_view_add_peserta.getSettings().setJavaScriptEnabled(true);
        web_view_add_peserta.getSettings().setDomStorageEnabled(true);

        // Tiga baris di bawah ini agar laman yang dimuat dapat
        // melakukan zoom.
        web_view_add_peserta.getSettings().setSupportZoom(true);
        web_view_add_peserta.getSettings().setBuiltInZoomControls(true);
        web_view_add_peserta.getSettings().setDisplayZoomControls(false);
        // Baris di bawah untuk menambahkan scrollbar di dalam WebView-nya
        web_view_add_peserta.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web_view_add_peserta.setWebViewClient(new WebViewClient());
        web_view_add_peserta.loadUrl(Konfiguration.TAMBAH_PESERTA);

        web_view_add_peserta.addJavascriptInterface(new WebAppInterface(this), "Android");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

}