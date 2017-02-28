package com.jux.recyclerviewtoolkitsample;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jux.recyclerviewtoolkit.adapter.SingleChoiceAdapter;

import java.util.Arrays;
import java.util.List;

public class SingleChoiceActivity extends BaseActivity {

    private static final List<String> ITEMS =
            Arrays.asList("Choice 1", "Choice 2", "Choice 3", "Choice 4", "Choice 5",
                    "Choice 6", "Choice 7", "Choice 8", "Choice 9", "Choice 10");

    @Override
    protected void setupToolbar() {
        super.setupToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void setupRecyclerView() {
        // Adapter
        SingleChoiceAdapter adapter = new SingleChoiceAdapter(this);
        adapter.setOnItemClickListener(this);
        adapter.setData(ITEMS);

        RecyclerView recyclerView = (RecyclerView) findViewById(android.R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View v, int position) {

    }

    @Override
    public void onInteractiveElementClick(View iconView, int position) {

    }
}
