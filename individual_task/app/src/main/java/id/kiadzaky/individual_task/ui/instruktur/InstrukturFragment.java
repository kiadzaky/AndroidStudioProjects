package id.kiadzaky.individual_task.ui.instruktur;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.kiadzaky.individual_task.Konfiguration;
import id.kiadzaky.individual_task.R;

public class InstrukturFragment extends Fragment {

    private WebView web_view;
    private FloatingActionButton add_peserta;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_peserta, container, false);
        web_view = view.findViewById(R.id.web_view);
        add_peserta = view.findViewById(R.id.add_peserta);

        add_peserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AddInstrukturActivity.class);

                startActivity(i);
            }
        });
        tampilWebview();

        return view;
    }

    private void tampilWebview() {
        web_view.getSettings().setLoadsImagesAutomatically(true);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.getSettings().setDomStorageEnabled(true);

        // Tiga baris di bawah ini agar laman yang dimuat dapat
        // melakukan zoom.
        web_view.getSettings().setSupportZoom(true);
        web_view.getSettings().setBuiltInZoomControls(true);
        web_view.getSettings().setDisplayZoomControls(false);
        // Baris di bawah untuk menambahkan scrollbar di dalam WebView-nya
        web_view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web_view.setWebViewClient(new WebViewClient());
        web_view.loadUrl(Konfiguration.TABEL_INSTRUKTUR );
    }


}