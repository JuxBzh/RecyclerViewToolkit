package com.jux.recyclerviewtoolkitsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jux.recyclerviewtoolkit.adapter.BaseAdapter;
import com.jux.recyclerviewtoolkit.viewholder.BaseViewHolder;


public class SimpleAdapter extends BaseAdapter<String> {

    public SimpleAdapter(Context context) {
        super(context);
        setChoiceMode(CHOICE_MODE_NONE);
    }

    @Override
    public void onBindBaseViewHolder(BaseViewHolder baseViewHolder, int i) {
        SimpleViewHolder viewHolder = (SimpleViewHolder) baseViewHolder;
        viewHolder.textView.setText(getItem(i));
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).
                inflate(android.R.layout.simple_list_item_1, parent, false);
        return new SimpleViewHolder(itemView, this);
    }
}
