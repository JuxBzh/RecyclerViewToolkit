package com.jux.recyclerviewtoolkit.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * An implementation of {@link RecyclerView.ViewHolder} that provides a callback interface to listen
 * for item selection
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /**
     * Item selection listener
     */
    protected OnItemClickListener mItemClickListener;

    public BaseViewHolder(View itemView, OnItemClickListener listener) {
        super(itemView);
        mItemClickListener = listener;

        // Set click listener
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    /**
     * Interface definition of a callback to be invoked when a {@link BaseViewHolder} item is clicked
     */
    public interface OnItemClickListener {
        /**
         * Callback for when the view holder itemView is selected
         *
         * @param view     The selected view
         * @param position The position of the selected view
         */
        void onItemClick(View view, int position);

        /**
         * A callback for when an clickable element inside the itemView is clicked.
         * This event can be used to start contextual action mode.
         * <p>
         * NB: Concrete implementations of {@link BaseViewHolder} have to
         * declare a click listener on the clickable element so the event can be propagated to the adapter.
         *
         * @param clickable The clickable element (i.e. an {@link android.widget.ImageView} displaying the photo of a contact)
         * @param position  The position of the item the icon view is in
         */
        void onInteractiveElementClick(View clickable, int position);
    }
}
