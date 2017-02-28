package com.jux.recyclerviewtoolkit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jux.recyclerviewtoolkit.R;
import com.jux.recyclerviewtoolkit.viewholder.BaseViewHolder;
import com.jux.recyclerviewtoolkit.viewholder.SimpleViewHolder;

/**
 * A {@link BaseAdapter} that displays a list of {@link String}.<br/>
 * NB: Each cell provides a selection feedback
 */
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
                inflate(R.layout.simple_list_item, parent, false);
        return new SimpleViewHolder(itemView, this);
    }
}
