package net.openwritings.data.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = this.findViewById(R.id.main_linearlayout);

        SharedPref sharedPref = new SharedPref(this);

        // Add preference.
        Date now = new Date();
        sharedPref.add(now.getTime()+"", "Some value");

        // Display all preferences.
        Map<String, ?> allFavorites = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allFavorites.entrySet()) {
            String text = String.format("key=%s, value=%s", entry.getKey(), entry.getValue().toString());
            TextView textView = new TextView(this);
            textView.setText(text);
            linearLayout.addView(textView);
        }

    }
}
