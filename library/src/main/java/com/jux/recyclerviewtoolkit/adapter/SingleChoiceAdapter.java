package com.jux.recyclerviewtoolkit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jux.recyclerviewtoolkit.viewholder.BaseViewHolder;
import com.jux.recyclerviewtoolkit.viewholder.SingleChoiceViewHolder;

/**
 * A {@link BaseAdapter} that displays a list of mutually exclusive items
 */
public class SingleChoiceAdapter extends BaseAdapter<String> {
    private int mLayoutResId;

    public SingleChoiceAdapter(Context context) {
        this(context, -1);
    }

    /**
     * Constructor
     *
     * @param context     Application context
     * @param layoutResId Resource identifier of the layout to be used for each cell
     *                    (NB: this layout must contain a CheckedTextView with id="text1")
     */
    public SingleChoiceAdapter(Context context, int layoutResId) {
        super(context);
        mLayoutResId = layoutResId;

        setChoiceMode(CHOICE_MODE_SINGLE);
    }

    @Override
    public void onBindBaseViewHolder(BaseViewHolder baseViewHolder, int i) {
        SingleChoiceViewHolder viewHolder = (SingleChoiceViewHolder) baseViewHolder;
        viewHolder.title.setText(getItem(i));
        viewHolder.title.setChecked(getSelectedItems().contains(i));
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(mLayoutResId != -1 ? mLayoutResId : android.R.layout.simple_list_item_single_choice,
                parent, false);
        return new SingleChoiceViewHolder(view, this);
    }
}
