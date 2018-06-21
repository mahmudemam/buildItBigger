package com.udacity.nd.projects.jokeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import timber.log.Timber;


public class JokeActivity extends AppCompatActivity {
    public static final String INTENT_EXTRA_JOKE = "joke_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Timber.plant(new Timber.DebugTree());
        Timber.tag(JokeActivity.class.getSimpleName());

        Intent launchIntent = getIntent();
        if (launchIntent == null || ! launchIntent.hasExtra(INTENT_EXTRA_JOKE)) {
            Timber.e("Empty Intent");
            finish();
            return;
        }

        String joke = launchIntent.getStringExtra(INTENT_EXTRA_JOKE);

        TextView jokeTextView = findViewById(R.id.tv_joke_text);
        jokeTextView.setText(joke);
    }
}
