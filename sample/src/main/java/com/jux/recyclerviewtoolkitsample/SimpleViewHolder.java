package com.jux.recyclerviewtoolkitsample;

import android.view.View;
import android.widget.TextView;

import com.jux.recyclerviewtoolkit.viewholder.BaseViewHolder;

/**
 * A {@link BaseViewHolder} holding a single {@link TextView}
 */
public class SimpleViewHolder extends BaseViewHolder {
    TextView textView;

    public SimpleViewHolder(View itemView, OnItemClickListener listener) {
        super(itemView, listener);

        textView = (TextView) itemView.findViewById(android.R.id.text1);
    }
}
