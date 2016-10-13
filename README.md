# RecyclerView Toolkit

RecyclerView Toolkit provides ready to use RecyclerView components.

## Download

Using gradle:
```gradle
dependencies {
    compile 'com.juxbzh:recyclerviewtoolkit:0.1.0'
}
```

## How do I use RecyclerView Toolkit ?

Either extend or directly use the components provided in the library

## Components

Here is a list of the components available in the library

### Adapters

 - **MultipleChoiceModeAdapter**: The base implementation of RecyclerView.Adapter that supports multiple selection modes
 - **BaseAdapter**: An adapter that behaves like an ArrayAdapter and that supports multiple selection mode
 - **BaseCursorAdapter**: An adapter that provides support for displaying data using Cursor
 - **HeaderFooterBaseAdapter**: An extension of BaseAdapter that provides support for an optional HEADER and/or FOOTER item
 - **MultipleChoiceAdapter**: An adapter that displays a list of non mutually exclusive items
 - **SingleChoiceAdapter**: An adapter that displays a list of mutually exclusive items

### ViewHolder

 - **BaseViewHolder**: The base implementation of RecyclerView.ViewHolder to be provides a callback interface to listen for item selection
 - **SingleChoiceViewHolder**: The ViewHolder that is used by the SingleChoiceAdapter
 - **MultipleChoiceViewHolder**: The ViewHolder that is used by the MultipleChoiceAdapter

### Decoration
 - **GridSpacingItemDecoration**: An implementation of RecyclerView.ItemDecoration to add spacing between items displayed in Grid layout