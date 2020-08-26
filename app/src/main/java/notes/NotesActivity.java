package notes;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.helloworld.notes.BaseActivity;
import com.helloworld.notes.Constans;
import com.helloworld.notes.LoginActivity;
import com.helloworld.notes.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import models.Note;

public class NotesActivity extends BaseActivity {
    RecyclerView rvNotes;
    ArrayList<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        SetRecyclerViewData();
        setLogoutEvent();

    }

    private void populateNotelist(){
        noteList = new ArrayList<>();

        noteList.add(new Note("Pasear Perro", "Hace mucho que no sale"));
        noteList.add(new Note("Pasear Gato", "Que haga del baño"));
        noteList.add(new Note("Pasear tiburon", "A comer peces"));
        noteList.add(new Note("Pasear dinosaurio", "a dar e roll"));

    }

    private void SetRecyclerViewData(){
        rvNotes = findViewById(R.id.rvNotes);

        populateNotelist();

        NotesAdapter adapter = new NotesAdapter(noteList, NotesActivity.this);
         rvNotes.setAdapter(adapter);
         rvNotes.setHasFixedSize(true);
         RecyclerView.LayoutManager manager = new LinearLayoutManager(NotesActivity.this);
         rvNotes.setLayoutManager(manager);

    }

    private void setLogoutEvent() {
        Button btLogout = findViewById(R.id.btLogout);
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.setPref(Constans.PREFS_USER,false);
                Intent intent = new Intent(NotesActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}