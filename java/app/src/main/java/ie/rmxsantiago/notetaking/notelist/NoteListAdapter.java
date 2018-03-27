package ie.rmxsantiago.notetaking.notelist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ie.rmxsantiago.notetaking.R;

/**
 * Created by rmxsantiago on 27/03/2018.
 */

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder> {
    private final List<String> mData;

    public NoteListAdapter(List<String> data) {
        mData = data;
    }

    @Override
    public NoteListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_note_list, parent, false);
        return new NoteListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteListAdapter.ViewHolder holder, int position) {
        holder.textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.textView = view.findViewById(R.id.textView);
        }
    }
}
