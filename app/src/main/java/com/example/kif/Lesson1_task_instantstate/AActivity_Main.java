package com.example.kif.Lesson1_task_instantstate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class AActivity_Main extends AppCompatActivity {
    public static final String TEXT_VIEW_KEY = "com.example.kif.levelup_1_task.TEXT_VIEW_KEY";
    public static final String EXTRA_TEXT_VIEW_KEY = "com.example.kif.levelup_1_task.EXTRA_TEXT_VIEW_KEY";

    private TextView textView_task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


        textView_task = (TextView) findViewById(R.id.main_text_task);

        if (savedInstanceState != null) {
            textView_task.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
        } else {
            textView_task.setText("First A activity" + System.getProperty("line.separator"));

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Hey you just hit "+item.getTitle(),Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id==R.id.navigates){
            textView_task.append(" A activity"+ System.getProperty("line.separator"));

            Intent I = new Intent(this, BActivity.class);
            I.putExtra(EXTRA_TEXT_VIEW_KEY, textView_task.getText().toString());
            startActivity(I);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        textView_task.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }

    @Override
    public void onSaveInstanceState(Bundle out) {
        Log.d("TASK", "onSaveInstanceState: "+textView_task.getText().toString());
        out.putString(TEXT_VIEW_KEY, textView_task.getText().toString());

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(out);
    }

}