package ua.work.home.customviewhomework.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

import ua.work.home.customviewhomework.R;

/**
 * Created by Andrii Papai on 29.10.2017.
 */

public class TextButtonView extends RelativeLayout {
    private Context context;
    private EditText text;
    private ImageView button;
    private List<String> list;
    private ViewGroup rootView;

    public TextButtonView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public TextButtonView(Context context, List<String> list, ViewGroup rootView) {
        super(context);
        this.context = context;
        this.list = list;
        this.rootView = rootView;
        init();
    }

    public TextButtonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public TextButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.text_button_view, this);
        button = view.findViewById(R.id.button);
        text = view.findViewById(R.id.text);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setEnabled(false);
                button.setVisibility(INVISIBLE);
                if (list != null) {
                    list.add(getText());
                }
                addNewView();
            }
        });
    }

    private String getText() {
        return text.getText() != null ? text.getText().toString() : "";
    }

    private void addNewView() {
        rootView.addView(new TextButtonView(context, list, rootView));
    }
}
