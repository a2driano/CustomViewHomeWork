package ua.work.home.customviewhomework.utils;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ua.work.home.customviewhomework.databinding.ItemViewBinding;
import ua.work.home.customviewhomework.model.Note;

/**
 * Created by Andrii Papai on 29.10.2017.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> mUserList;

    public NoteAdapter(List<Note> userList) {
        mUserList = userList;
    }

    @Override
    public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemViewBinding binding = ItemViewBinding.inflate(inflater, parent, false);
        return new NoteHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(NoteHolder holder, int position) {
        Note note = mUserList.get(position);
        holder.binding.setText(note);
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {
        ItemViewBinding binding;

        public NoteHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }
    }
}
