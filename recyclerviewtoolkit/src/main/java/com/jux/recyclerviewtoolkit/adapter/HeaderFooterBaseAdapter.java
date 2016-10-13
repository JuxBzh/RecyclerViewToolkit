package com.jux.recyclerviewtoolkit.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jux.recyclerviewtoolkit.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * An {@link android.support.v7.widget.RecyclerView.Adapter} that provides:
 * <ul>
 * <li>Support for various selection mode (NONE, SIMPLE, MULTIPLE)</li>
 * <li>Support for optional header and footer views</li>
 * </ul>
 *
 * @param <T> The model object used by the item item ViewHolder
 * @param <H> The model object used by the header ViewHolder
 * @param <F> The model object used by the footer ViewHolder
 */
public abstract class HeaderFooterBaseAdapter<T, H, F>
        extends MultipleChoiceModeAdapter {

    public static final int TYPE_HEADER = 100;
    public static final int TYPE_FOOTER = 200;
    public static final int TYPE_ITEM = 300;

    protected Context mContext;

    protected H mHeader;
    protected List<T> mDataSet;
    protected F mFooter;

    public HeaderFooterBaseAdapter(Context context) {
        super();
        mContext = context;
        mDataSet = new ArrayList<>();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return onCreateHeaderViewHolder(parent);
            case TYPE_FOOTER:
                return onCreateFooterViewHolder(parent);
            case TYPE_ITEM:
                return onCreateItemViewHolder(parent);
            default:
                throw new UnsupportedOperationException("Cannot create ViewHolder. Unsupported view type: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        // Set activated if the item is selected
        holder.itemView.setActivated(getSelectedItems().contains(position));

        if (isHeaderPosition(position)) {
            onBindHeaderViewHolder(holder);
        } else if (isFooterPosition(position)) {
            onBindFooterViewHolder(holder);
        } else {
            onBindItemViewHolder(holder, position);
        }
    }

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
     * @return The list of objects managed by the adapter
     */
    public List<T> getDataSet() {
        return new ArrayList<>(mDataSet);
    }

    /**
     * @param position Item's position
     * @return The object at the given position
     */
    public T getItem(int position) {
        if (hasHeader() && hasItems()) {
            return mDataSet.get(position - 1);
        }
        return mDataSet.get(position);
    }

    /**
     * @return The number of items including Header and Footer items
     */
    @Override
    public int getItemCount() {
        int size = mDataSet.size();
        if (hasHeader()) size++;
        if (hasFooter()) size++;

        return size;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderPosition(position)) return TYPE_HEADER;
        if (isFooterPosition(position)) return TYPE_FOOTER;
        return TYPE_ITEM;
    }

    public boolean isHeaderPosition(int position) {
        return hasHeader() && position == 0;
    }

    public boolean isFooterPosition(int position) {
        return hasFooter() && position == getItemCount() - 1;
    }

    public boolean hasHeader() {
        return mHeader != null;
    }

    public boolean hasFooter() {
        return mFooter != null;
    }

    public boolean hasItems() {
        return !mDataSet.isEmpty();
    }

    public H getHeader() {
        return mHeader;
    }

    public void setHeader(H header) {
        mHeader = header;
    }

    public F getFooter() {
        return mFooter;
    }

    public void setFooter(F footer) {
        mFooter = footer;
    }

    public abstract BaseViewHolder onCreateHeaderViewHolder(ViewGroup parent);

    public abstract BaseViewHolder onCreateFooterViewHolder(ViewGroup parent);

    public abstract BaseViewHolder onCreateItemViewHolder(ViewGroup parent);

    public abstract void onBindHeaderViewHolder(BaseViewHolder holder);

    public abstract void onBindFooterViewHolder(BaseViewHolder holder);

    public abstract void onBindItemViewHolder(BaseViewHolder holder, int position);
}
