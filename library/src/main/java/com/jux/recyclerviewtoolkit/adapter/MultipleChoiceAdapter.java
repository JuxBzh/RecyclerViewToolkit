package com.jux.recyclerviewtoolkit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jux.recyclerviewtoolkit.viewholder.BaseViewHolder;
import com.jux.recyclerviewtoolkit.viewholder.MultipleChoiceViewHolder;

/**
 * A {@link BaseAdapter} that displays a list of non mutually exclusive items
 */
public class MultipleChoiceAdapter extends BaseAdapter<String> {
    private int mLayoutResId;

    public MultipleChoiceAdapter(Context context) {
        this(context, -1);
    }

    /**
     * Constructor
     *
     * @param context     Application context
     * @param layoutResId Resource identifier of the layout to be used for each cell
     *                    (NB: this layout must contain a CheckedTextView with id="text1")
     */
    public MultipleChoiceAdapter(Context context, int layoutResId) {
        super(context);
        mLayoutResId = layoutResId;

        setChoiceMode(CHOICE_MODE_MULTIPLE);
    }

    @Override
    public void onBindBaseViewHolder(BaseViewHolder baseViewHolder, int i) {
        MultipleChoiceViewHolder viewHolder = (MultipleChoiceViewHolder) baseViewHolder;
        viewHolder.title.setText(getItem(i));
        viewHolder.title.setChecked(getSelectedItems().contains(i));
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(mLayoutResId != -1 ? mLayoutResId : android.R.layout.simple_list_item_multiple_choice,
                parent, false);
        return new MultipleChoiceViewHolder(view, this);
    }
}
