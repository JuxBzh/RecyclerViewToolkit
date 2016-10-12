package com.jux.recyclerviewtoolkit.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;

import com.jux.recyclerviewtoolkit.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link RecyclerView.Adapter} that support multiple selection modes
 *
 * @see RecyclerView.Adapter
 * @see BaseViewHolder.OnItemClickListener
 */
public abstract class MultipleChoiceModeAdapter
        extends RecyclerView.Adapter<BaseViewHolder>
        implements BaseViewHolder.OnItemClickListener {

    public static final int CHOICE_MODE_NONE = 0;
    public static final int CHOICE_MODE_SINGLE = 1;
    public static final int CHOICE_MODE_MULTIPLE = 2;

    /**
     * The list of selected items
     */
    private SparseBooleanArray mSelectedItems;

    /**
     * Choice mode. Default is {@link #CHOICE_MODE_NONE}
     */
    private int mChoiceMode = CHOICE_MODE_NONE;

    /**
     * Item selection listener
     */
    private OnItemClickListener mItemClickListener;

    public MultipleChoiceModeAdapter() {
        mSelectedItems = new SparseBooleanArray();
    }

    /**
     * Select/Deselect the item at the given position
     *
     * @param position Item's position
     */
    public void toggleSelection(int position) {
        switch (mChoiceMode) {
            case CHOICE_MODE_NONE:
                break;
            case CHOICE_MODE_SINGLE:
                // Only one item can be selected at max and selected an already selected item doesn't have any effect
                mSelectedItems.clear();
                mSelectedItems.put(position, true);
                notifyDataSetChanged();
                break;
            case CHOICE_MODE_MULTIPLE:
                if (mSelectedItems.get(position)) {
                    mSelectedItems.delete(position);
                } else {
                    mSelectedItems.put(position, true);
                }
                notifyItemChanged(position);
                break;
            default:
                break;
        }
    }

    /**
     * Clear items selection
     */
    public void clearSelection() {
        mSelectedItems.clear();
        notifyDataSetChanged();
    }

    /**
     * @return The number of selected items
     */
    public int getSelectedItemsCount() {
        return mSelectedItems.size();
    }

    /**
     * @return The position of all selected items
     */
    public List<Integer> getSelectedItems() {
        List<Integer> selectedItems = new ArrayList<>(mSelectedItems.size());
        for (int i = 0; i < mSelectedItems.size(); i++) {
            selectedItems.add(mSelectedItems.keyAt(i));
        }

        return selectedItems;
    }

    /**
     * Set the choice mode. NB: Possible values are {@link #CHOICE_MODE_NONE}, {@link #CHOICE_MODE_SINGLE},
     * {@link #CHOICE_MODE_MULTIPLE}
     *
     * @param choiceMode The choice mode
     */
    public void setChoiceMode(int choiceMode) {
        if (choiceMode >= CHOICE_MODE_NONE && choiceMode <= CHOICE_MODE_MULTIPLE) {
            mChoiceMode = choiceMode;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        toggleSelection(position);

        if (mItemClickListener != null) {
            mItemClickListener.onItemClick(view, position);
        }
    }

    @Override
    public void onInteractiveElementClick(View iconView, int position) {
        if (mItemClickListener != null) {
            mItemClickListener.onInteractiveElementClick(iconView, position);
        }
    }

    /**
     * @param listener Item click listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    /**
     * Interface definition of a callback to be invoked when {@link BaseAdapter} item is clicked
     */
    public interface OnItemClickListener {
        /**
         * @see BaseViewHolder.OnItemClickListener#onItemClick(View, int)
         */
        void onItemClick(View v, int position);

        /**
         * @see BaseViewHolder.OnItemClickListener#onInteractiveElementClick(View, int)
         */
        void onInteractiveElementClick(View iconView, int position);
    }

}
