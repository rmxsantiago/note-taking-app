package ie.rmxsantiago.notetaking.note;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import ie.rmxsantiago.notetaking.R;
import ie.rmxsantiago.notetaking.model.DataManager;
import ie.rmxsantiago.notetaking.model.pojos.Category;
import ie.rmxsantiago.notetaking.model.pojos.Note;

public class NoteActivity extends AppCompatActivity {
    public static final String NOTE = "NOTEPOSITION";

    private Spinner mSpinner;
    private TextView mNoteTitle;
    private TextView mNoteText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        // Spinner
        mSpinner = findViewById(R.id.spinner_courses);
        ArrayAdapter<Category> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, DataManager.getCategories());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        //TextViews
        mNoteTitle = findViewById(R.id.textview_note_title);
        mNoteText = findViewById(R.id.textview_note_text);

        Intent intent = getIntent();
        Note note = intent.getParcelableExtra(NOTE);
        mNoteTitle.setText(note.getTitle());
        mNoteText.setText(note.getText());
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
        Intent emailIntent = prepareEmailIntent();
        startActivity(emailIntent);
    }

    private Intent prepareEmailIntent(){
        final String category = (String) mSpinner.getSelectedItem();
        final String subject = getString(R.string.email_title) + " " + mNoteTitle.getText();


        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.email_text));
        builder.append("\n\n\n");
        builder.append(getString(R.string.category) + category);
        builder.append("\n\n");
        builder.append(mNoteText.getText());

        final String body = builder.toString();
        builder = null;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        return intent;
    }
}
