package com.jux.recyclerviewtoolkit.adapter;

import android.content.Context;

import com.jux.recyclerviewtoolkit.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@link MultipleChoiceModeAdapter} that behaves like an
 * {@link android.widget.ArrayAdapter}
 */
public abstract class BaseAdapter<T> extends MultipleChoiceModeAdapter {

    /**
     * Application context
     */
    protected Context mContext;

    /**
     * The data set displayed in the recycler view
     */
    protected List<T> mDataSet;

    public BaseAdapter(Context context) {
        super();
        mContext = context;
        mDataSet = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        // Set activated if the item is selected
        baseViewHolder.itemView.setActivated(getSelectedItems().contains(i));

        onBindBaseViewHolder(baseViewHolder, i);
    }

    public abstract void onBindBaseViewHolder(BaseViewHolder baseViewHolder, int i);

    /**
     * Set the data to be displayed
     *
     * @param data The data to be displayed. If <code>null</code> or empty the old data set will be cleared
     */
    public void setData(List<T> data) {
        mDataSet.clear();
        clearSelection();
        if (data != null && !data.isEmpty()) {
            mDataSet.addAll(data);
        }
        notifyDataSetChanged();
    }

    /**
     * @param position Item's position
     * @return The object at the given position
     */
    public T getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
