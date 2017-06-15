package com.example.kif.Lesson1_task_instantstate;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.kif.Lesson1_task_instantstate.AActivity_Main.EXTRA_TEXT_VIEW_KEY;
import static com.example.kif.Lesson1_task_instantstate.AActivity_Main.TEXT_VIEW_KEY;

public class DActivity extends AppCompatActivity {
    private TextView textView_task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView_task = (TextView) findViewById(R.id.main_text_task);

        Intent intent = getIntent();
        textView_task = (TextView) findViewById(R.id.main_text_task);
        textView_task.setText(intent.getStringExtra(EXTRA_TEXT_VIEW_KEY));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_d, menu);
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

        if(id==android.R.id.home){
            textView_task.append(" back from D activity"+ System.getProperty("line.separator"));

            NavUtils.navigateUpFromSameTask(this);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        textView_task.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }

    @Override
    public void onSaveInstanceState(Bundle out) {
        out.putString(TEXT_VIEW_KEY, textView_task.getText().toString());
        Log.d("TASK", "onSaveInstanceState: "+textView_task.getText().toString());

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(out);
    }
}
