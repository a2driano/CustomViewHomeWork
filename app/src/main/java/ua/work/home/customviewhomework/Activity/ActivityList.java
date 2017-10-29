package ua.work.home.customviewhomework.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ua.work.home.customviewhomework.App;
import ua.work.home.customviewhomework.R;
import ua.work.home.customviewhomework.model.Note;
import ua.work.home.customviewhomework.utils.NoteAdapter;

public class ActivityList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Note> mNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mNotes = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new NoteAdapter(createList()));
    }

    private List<Note> createList() {

        for (String text : App.getList()) {
            mNotes.add(new Note(text));
        }
        return mNotes;
    }
}
