package com.ieli.quranway.quran_list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ieli.quranway.QuranActivity;
import com.ieli.quranway.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class QuranListActivity extends AppCompatActivity {
    private List<Surah> surahList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran_list);

        // Parse JSON and populate surahList
        parseJSON();

        ListView listView = findViewById(R.id.list_view);
        SurahAdapter adapter = new SurahAdapter(this, R.layout.list_item_surah, surahList);
        listView.setAdapter(adapter);
    }

    private void parseJSON() {
        try {
            // Open the JSON file from assets folder
            InputStream inputStream = getAssets().open("surahs.json");

            // Create a Reader from InputStream
            Reader reader = new InputStreamReader(inputStream);

            // Using Gson to parse JSON
            Gson gson = new Gson();
            Type surahListType = new TypeToken<List<Surah>>() {}.getType();
            List<Surah> surahList = gson.fromJson(reader, surahListType);

            // Now, surahList contains the parsed data
            // You can assign it to the global variable if needed
            this.surahList = surahList;

            // Close the InputStream
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
