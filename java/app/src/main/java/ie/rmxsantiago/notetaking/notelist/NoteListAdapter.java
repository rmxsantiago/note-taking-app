package ie.rmxsantiago.notetaking.notelist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ie.rmxsantiago.notetaking.R;
import ie.rmxsantiago.notetaking.model.pojos.Category;
import ie.rmxsantiago.notetaking.model.pojos.Note;
import ie.rmxsantiago.notetaking.note.NoteActivity;

/**
 * Created by rmxsantiago on 27/03/2018.
 */

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder> {
    private final List<Note> mData;
    private Context mContext;

    public NoteListAdapter(List<Note> data) {
        mData = data;
    }

    @Override
    public NoteListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_note_list, parent, false);
        return new NoteListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteListAdapter.ViewHolder holder, int position) {
        Note note = mData.get(position);
        holder.mNoteTitle.setText(note.getTitle());
        holder.mNoteText.setText(note.getText());
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mNoteTitle;
        public TextView mNoteText;
        public int mCurrentPosition;

        public ViewHolder(View view) {
            super(view);
            this.mNoteTitle = view.findViewById(R.id.textview_note_title);
            this.mNoteText = view.findViewById(R.id.textview_note_text);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), NoteActivity.class);
                    intent.putExtra(NoteActivity.NOTE, new Note(mNoteTitle.getText().toString(),
                            mNoteText.getText().toString(), new Category("")));
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
