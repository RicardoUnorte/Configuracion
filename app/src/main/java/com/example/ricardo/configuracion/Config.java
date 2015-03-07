package com.example.ricardo.configuracion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.preference.PreferenceActivity;
import android.widget.TextView;


public class Config extends ActionBarActivity {

    private static final int SETTINGS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        showUserSettings();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_config, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.action_settings:
                Intent i = new Intent(this, SettingsActivity.class);
                startActivityForResult(i, SETTINGS);
                break;

        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SETTINGS:
                showUserSettings();
                break;

        }

    }

    private void showUserSettings() {
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2= new StringBuilder();

        builder.append("\n Nombre: "
                + sharedPrefs.getString("name", "NULL"));

        builder1.append("\n Edad:"
                + sharedPrefs.getString("edad", "NULL"));

        builder2.append("\n Genero: "
                + sharedPrefs.getString("genero", "NULL"));

        TextView settingsTextView = (TextView) findViewById(R.id.textView);
        TextView settingsTextView1 = (TextView) findViewById(R.id.textView2);
        TextView settingsTextView2 = (TextView) findViewById(R.id.textView3);

        settingsTextView.setText(builder.toString());
        settingsTextView1.setText(builder1.toString());
        settingsTextView2.setText(builder2.toString());


    }

}



