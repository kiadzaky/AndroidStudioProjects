package id.kiadzaky.individual_task.ui.instruktur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import id.kiadzaky.individual_task.Konfiguration;
import id.kiadzaky.individual_task.R;
import id.kiadzaky.individual_task.ui.peserta.WebAppInterface;

public class AddInstrukturActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_instruktur);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tambah Instruktur");

        WebView web_view_add_instruktur = findViewById(R.id.web_view_add_instruktur);
        web_view_add_instruktur.getSettings().setLoadsImagesAutomatically(true);
        web_view_add_instruktur.getSettings().setJavaScriptEnabled(true);
        web_view_add_instruktur.getSettings().setDomStorageEnabled(true);

        // Tiga baris di bawah ini agar laman yang dimuat dapat
        // melakukan zoom.
        web_view_add_instruktur.getSettings().setSupportZoom(true);
        web_view_add_instruktur.getSettings().setBuiltInZoomControls(true);
        web_view_add_instruktur.getSettings().setDisplayZoomControls(false);
        // Baris di bawah untuk menambahkan scrollbar di dalam WebView-nya
        web_view_add_instruktur.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web_view_add_instruktur.setWebViewClient(new WebViewClient());
        web_view_add_instruktur.loadUrl(Konfiguration.TAMBAH_INSTRUKTUR);

        web_view_add_instruktur.addJavascriptInterface(new WebAppInterface(this), "Android");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}