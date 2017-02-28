package com.jux.recyclerviewtoolkit.viewholder;

import android.view.View;
import android.widget.TextView;

/**
 * A {@link BaseViewHolder} holding a single {@link TextView}<br/>
 * NB: Expected id for the TextView: android.R.id.text1
 */
public class SimpleViewHolder extends BaseViewHolder {
    public TextView textView;

    public SimpleViewHolder(View itemView, OnItemClickListener listener) {
        super(itemView, listener);

        textView = (TextView) itemView.findViewById(android.R.id.text1);
    }
}
