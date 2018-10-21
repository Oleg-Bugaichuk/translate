package com.example.oleg.translate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HistoryPage extends Fragment
{

    public HistoryPage()
    {

    }

    public static HistoryPage newInstance()
    {
        return new HistoryPage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_history_fragment, container, false);
    }
}
