package ua.work.home.customviewhomework;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii Papai on 29.10.2017.
 */

public class App extends Application {
    private static List<String> list;


    @Override
    public void onCreate() {
        super.onCreate();

        list = new ArrayList<>();
    }

    public static List<String> getList() {
        return list;
    }
}
