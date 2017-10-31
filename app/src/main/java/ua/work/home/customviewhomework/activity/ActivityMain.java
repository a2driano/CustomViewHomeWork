package ua.work.home.customviewhomework.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import ua.work.home.customviewhomework.App;
import ua.work.home.customviewhomework.R;
import ua.work.home.customviewhomework.view.TextButtonCustomView;

public class ActivityMain extends AppCompatActivity {

    private LinearLayout mRootView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButton = findViewById(R.id.button_save);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMain.this, ActivityList.class);
                startActivity(intent);
            }
        });

        mRootView = findViewById(R.id.view_container);
        addCustomView();
    }

    private void addCustomView() {
        final TextButtonCustomView customView = new TextButtonCustomView(this);

        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCustomView();
                App.getList().add(customView.getTextCustomText());
            }
        });
        mRootView.addView(customView);
    }
}
