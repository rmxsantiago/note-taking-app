package ie.rmxsantiago.notetaking.note;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;

import ie.rmxsantiago.notetaking.R;

public class NoteActivity extends AppCompatActivity {
    Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mSpinner = findViewById(R.id.coursesSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,
                Arrays.asList(getResources().getStringArray(R.array.test)));
        mSpinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_email:{
                sendEmail();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void sendEmail() {
        String item = (String) mSpinner.getSelectedItem();
        String subject = "Note: " + item;
        String body = "Sending note by email.";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(intent);
    }
}
