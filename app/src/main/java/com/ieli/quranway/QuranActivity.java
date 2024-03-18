package com.ieli.quranway;

import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;


public class QuranActivity extends AppCompatActivity {

    public PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quran);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int surahNumber = getIntent().getIntExtra("SURAH_NUMBER", 0);

        pdfView = findViewById(R.id.pdfView);
        pdfView.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        pdfView.fromAsset("QuranPDF.pdf")
                .defaultPage(surahNumber)
                .enableSwipe(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .swipeHorizontal(true)
                .enableAntialiasing(true)
                .spacing(0)
                .autoSpacing(false)
                .enableAnnotationRendering(true)
                .pageFling(false)
                .pageSnap(true)
                .load();
    }
}