package com.ieli.quranway.quran_list;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ieli.quranway.QuranActivity;
import com.ieli.quranway.R;

import java.util.List;

public class SurahAdapter extends ArrayAdapter<Surah> {
    private Context mContext;
    private int mResource;

    public SurahAdapter(@NonNull Context context, int resource, @NonNull List<Surah> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        Surah surah = getItem(position);

        TextView indexTextView = convertView.findViewById(R.id.index_text_view);
        TextView surahNameTextView = convertView.findViewById(R.id.surah_name_text_view);
        TextView ayatCountTextView = convertView.findViewById(R.id.ayat_count_text_view);
        Button button = convertView.findViewById(R.id.button);

        indexTextView.setText(String.valueOf(position + 1));
        surahNameTextView.setText(surah.getSurahName());
        ayatCountTextView.setText(String.valueOf(surah.getAyatCount()));

        button.setOnClickListener(v -> {
            // Call the function to open Quran passing the surah number
            // Create an Intent to open the QuranActivity
            Intent intent = new Intent(mContext, QuranActivity.class);

            // Pass the surahNumber as an extra to QuranActivity
            intent.putExtra("SURAH_NUMBER", surah.getPageNumber() - 1);

            // Start QuranActivity
            mContext.startActivity(intent);
        });

        return convertView;
    }
}
