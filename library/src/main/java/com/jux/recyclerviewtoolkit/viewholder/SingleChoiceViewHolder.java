package com.jux.recyclerviewtoolkit.viewholder;

import android.view.View;
import android.widget.CheckedTextView;

/**
 * A {@link BaseViewHolder} to be used with {@link com.jux.recyclerviewtoolkit.adapter.SingleChoiceAdapter}
 */
public class SingleChoiceViewHolder extends BaseViewHolder {
    public CheckedTextView title;

    public SingleChoiceViewHolder(View itemView, BaseViewHolder.OnItemClickListener listener) {
        super(itemView, listener);

        title = (CheckedTextView) itemView.findViewById(android.R.id.text1);
    }
}
