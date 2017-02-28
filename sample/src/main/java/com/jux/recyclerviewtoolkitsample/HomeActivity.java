package com.jux.recyclerviewtoolkitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jux.recyclerviewtoolkit.adapter.MultipleChoiceModeAdapter;
import com.jux.recyclerviewtoolkit.adapter.SimpleAdapter;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements MultipleChoiceModeAdapter.OnItemClickListener {

    private static final List<String> SECTIONS =
            Arrays.asList("Single choice adapter", "Multiple choice adapter", "Header and Footer adapter",
                    "Cursor adapter", "Interactive element");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupToolbar();
        setupRecyclerView();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupRecyclerView() {
        // Adapter
        SimpleAdapter adapter = new SimpleAdapter(this);
        adapter.setOnItemClickListener(this);
        adapter.setData(SECTIONS);

        RecyclerView recyclerView = (RecyclerView) findViewById(android.R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    // OnItemClickListener

    @Override
    public void onItemClick(View v, int position) {

    }

    @Override
    public void onInteractiveElementClick(View iconView, int position) {

    }
}
