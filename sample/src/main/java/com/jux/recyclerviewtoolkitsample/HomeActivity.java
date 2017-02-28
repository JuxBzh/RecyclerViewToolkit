package com.jux.recyclerviewtoolkitsample;

import android.content.Intent;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jux.recyclerviewtoolkit.adapter.SimpleAdapter;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends BaseActivity {

    private static final List<String> SECTIONS =
            Arrays.asList("Single choice adapter", "Multiple choice adapter", "Header and Footer adapter",
                    "Cursor adapter", "Interactive element");

    @Override
    protected void setupRecyclerView() {
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
        Intent intent;
        switch (position) {
            case 0: // Single choice adapter
                intent = new Intent(this, SingleChoiceActivity.class);
                startActivity(intent);
                break;
            case 1: // Multiple choice adapter
                Snackbar.make(findViewById(R.id.coordinator_layout), "Not implemented",
                        BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
            case 2: // Header and Footer adapter
                Snackbar.make(findViewById(R.id.coordinator_layout), "Not implemented",
                        BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
            case 3: // Cursor adapter
                Snackbar.make(findViewById(R.id.coordinator_layout), "Not implemented",
                        BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
            case 4: // Interactive element
                Snackbar.make(findViewById(R.id.coordinator_layout), "Not implemented",
                        BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
            default:
                Snackbar.make(findViewById(R.id.coordinator_layout), "Not implemented",
                        BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onInteractiveElementClick(View iconView, int position) {
    }
}
