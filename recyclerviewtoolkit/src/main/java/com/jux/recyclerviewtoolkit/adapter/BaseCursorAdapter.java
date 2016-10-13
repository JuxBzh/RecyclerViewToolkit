package com.jux.recyclerviewtoolkit.adapter;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.provider.BaseColumns;

import com.jux.recyclerviewtoolkit.viewholder.BaseViewHolder;

/**
 * Implementation of {@link MultipleChoiceModeAdapter} that adds {@link Cursor} support
 *
 * @param <T> The type of object manipulated by the adapter
 */
public abstract class BaseCursorAdapter<T> extends MultipleChoiceModeAdapter {
    /**
     * Application context
     */
    private Context mContext;

    /**
     * The cursor holding the adapter data
     */
    private Cursor mCursor;

    /**
     * Flag indicating if the underlying data is valid
     */
    private boolean mDataValid;

    /**
     * Index of the {@link BaseColumns#_ID} column
     */
    private int mRowIdColumn;

    /**
     * Cursor data set observer
     */
    private DataSetObserver mDataSetObserver;

    /**
     * Cursor content observer
     */
    private CursorAdapterContentObserver mContentObserver;


    public BaseCursorAdapter(Context context, Cursor cursor) {
        super();
        mContext = context;
        init(cursor);
    }

    protected Context getContext() {
        return mContext;
    }

    private void init(Cursor c) {
        boolean cursorPresent = c != null;
        mCursor = c;
        mDataValid = cursorPresent;
        mRowIdColumn = cursorPresent ? c.getColumnIndexOrThrow(BaseColumns._ID) : -1;

        mDataSetObserver = new CursorAdapterDataSetObserver();

        if (cursorPresent) {
            if (mContentObserver != null) c.registerContentObserver(mContentObserver);
            if (mDataSetObserver != null) c.registerDataSetObserver(mDataSetObserver);
        }

        setHasStableIds(true);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (!mDataValid) {
            throw new IllegalStateException("onBindViewHolder shouldn't be called when data set is invalid");
        }
        if (!mCursor.moveToPosition(position)) {
            throw new IllegalStateException("Couldn't move the cursor to position " + position);
        }

        // Set activated if the item is selected
        holder.itemView.setActivated(getSelectedItems().contains(position));

        onBindBaseViewHolder(holder, mCursor, position);
    }

    public abstract void onBindBaseViewHolder(BaseViewHolder baseViewHolder, Cursor cursor, int position);

    @Override
    public int getItemCount() {
        if (mDataValid && mCursor != null) {
            return mCursor.getCount();
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        if (mDataValid && mCursor != null) {
            if (mCursor.moveToPosition(position)) {
                return mCursor.getLong(mRowIdColumn);
            }
        }
        return 0;
    }

    public abstract T getItem(int position);

    public Cursor getCursor() {
        return mCursor;
    }

    /**
     * Change the underlying cursor to a new cursor.
     * If there is an existing cursor it will be closed.
     *
     * @param cursor The new cursor to be used
     */
    public void changeCursor(Cursor cursor) {
        Cursor old = swapCursor(cursor);
        if (old != null) {
            old.close();
        }
    }

    /**
     * Swap in a new Cursor, returning the old Cursor.  Unlike
     * {@link #changeCursor(Cursor)}, the returned old Cursor is <em>not</em>
     * closed.
     *
     * @param newCursor The new cursor to be used.
     * @return The previously set Cursor, or null if there wasn't one
     * If the given new Cursor is the same instance is the previously set
     * Cursor, null is also returned.
     */
    public Cursor swapCursor(Cursor newCursor) {
        if (newCursor == mCursor) {
            return null;
        }

        Cursor oldCursor = mCursor;
        if (oldCursor != null) {
            if (mContentObserver != null) oldCursor.unregisterContentObserver(mContentObserver);
            if (mDataSetObserver != null) oldCursor.unregisterDataSetObserver(mDataSetObserver);
        }

        mCursor = newCursor;
        if (newCursor != null) {
            if (mContentObserver != null) newCursor.registerContentObserver(mContentObserver);
            if (mDataSetObserver != null) newCursor.registerDataSetObserver(mDataSetObserver);
            mRowIdColumn = newCursor.getColumnIndexOrThrow(BaseColumns._ID);
            mDataValid = true;

            // notify the observers about the new cursor
            notifyDataSetChanged();
        } else {
            mRowIdColumn = -1;
            mDataValid = false;

            // Invalidate data
            notifyItemRangeRemoved(0, getItemCount());
        }

        return oldCursor;
    }

    /**
     * Called when the {@link ContentObserver} on the cursor receives a change notification.
     * Can be implemented by sub-class.
     *
     * @see ContentObserver#onChange(boolean)
     */
    protected void onContentChanged() {
    }

    private class CursorAdapterContentObserver extends ContentObserver {
        public CursorAdapterContentObserver() {
            super(new Handler());
        }

        @Override
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override
        public void onChange(boolean selfChange) {
            onContentChanged();
        }
    }

    private class CursorAdapterDataSetObserver extends DataSetObserver {
        @Override
        public void onChanged() {
            mDataValid = true;
            notifyDataSetChanged();
        }

        @Override
        public void onInvalidated() {
            mDataValid = false;
            notifyItemRangeRemoved(0, getItemCount());
        }
    }
}
