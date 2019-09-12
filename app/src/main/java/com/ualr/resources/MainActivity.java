package com.ualr.resources;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout rootLayout;
    ImageView image;
    TextView countryName;
    TextView countryDescription;
    Button button;
    Drawable graphic;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Locale.getDefault().getLanguage().equals("es")) {
            setSpanishTheme();
        }
        else {
            setEnglishTheme();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.root_layout);

        if (Locale.getDefault().getLanguage().equals("es")) {
            setSpanishElements();
        }
        else {
            setEnglishElements();
        }
    }

    public void setEnglishTheme() {
        setTheme(R.style.EnglishTheme);
    }

    public void setSpanishTheme() {
        setTheme(R.style.SpanishTheme);
    }

    public void setEnglishElements() {
        image = findViewById(R.id.country_image);
        graphic = getResources().getDrawable(R.drawable.ic_usa, null);
        image.setImageDrawable(graphic);

        countryName = findViewById(R.id.country_title_text);
        text = getResources().getString(R.string.en_conutry_name);
        countryName.setText(text);
        countryName.setTextColor(getResources().getColor(R.color.enColorAccent, null));

        countryDescription = findViewById(R.id.country_description_text);
        text = getResources().getString(R.string.en_country_description);
        countryDescription.setText(text);

        button = findViewById(R.id.lesson_learnt_button);
        button.setBackgroundTintList(getResources().getColorStateList(R.color.button_color_en, null));
    }

    public void setSpanishElements() {
        image = findViewById(R.id.country_image);
        graphic = getResources().getDrawable(R.drawable.ic_spain, null);
        image.setImageDrawable(graphic);

        countryName = findViewById(R.id.country_title_text);
        text = getResources().getString(R.string.es_conutry_name);
        countryName.setText(text);
        countryName.setTextColor(getResources().getColor(R.color.esColorAccent, null));

        countryDescription = findViewById(R.id.country_description_text);
        text = getResources().getString(R.string.es_country_description);
        countryDescription.setText(text);

        button = findViewById(R.id.lesson_learnt_button);
        button.setBackgroundTintList(getResources().getColorStateList(R.color.button_color_es, null));
    }

    public void onLessonLearntClicked(View view) {
        String congratsMessage = getResources().getString(R.string.congrats_text);
        Snackbar snackbar = Snackbar.make(rootLayout, congratsMessage, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
