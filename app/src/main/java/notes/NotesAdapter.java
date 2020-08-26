package notes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.notes.Constans;
import com.helloworld.notes.R;

import java.util.ArrayList;

import models.Note;

public class NotesAdapter extends RecyclerView.Adapter <NoteViewHolder> {

    ArrayList<Note> noteList;
    Context ctx;

    public NotesAdapter(ArrayList<Note> noteList, Context ctx) {
        this.noteList = noteList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, final int i) {
        holder.tvNoteTitle.setText(noteList.get(i).getTitle());
        holder.tvNoteBody.setText(noteList.get(i).getBody());

        holder.llNoteContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, DetailNoteActivity.class);
                intent.putExtra(Constans.EXTRA_NOTE_TITLE, noteList.get(i).getTitle());
                intent.putExtra(Constans.EXTRA_NOTE_BODY, noteList.get(i).getBody());
                ctx.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
