package id.kiadzaky.individual_task.ui.kelas;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.kiadzaky.individual_task.Konfiguration;
import id.kiadzaky.individual_task.R;
import id.kiadzaky.individual_task.ui.materi.AddMateriActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KelasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KelasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KelasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KelasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KelasFragment newInstance(String param1, String param2) {
        KelasFragment fragment = new KelasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private WebView web_view;
    private FloatingActionButton add_peserta;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_peserta, container, false);
        web_view = view.findViewById(R.id.web_view);
        add_peserta = view.findViewById(R.id.add_peserta);

        add_peserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AddKelasActivity.class);

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
        web_view.loadUrl(Konfiguration.TABEL_KELAS);
    }

}