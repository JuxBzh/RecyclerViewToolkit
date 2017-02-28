package com.jux.recyclerviewtoolkitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jux.recyclerviewtoolkit.adapter.MultipleChoiceModeAdapter;


public abstract class BaseActivity extends AppCompatActivity
        implements MultipleChoiceModeAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        setupToolbar();
        setupRecyclerView();
    }

    protected void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected abstract void setupRecyclerView();
}
