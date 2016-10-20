# RecyclerView Toolkit

RecyclerView Toolkit provides ready to use RecyclerView components.

## Download

Using gradle:
```gradle
dependencies {
    compile 'com.juxbzh:recyclerviewtoolkit:0.2.0'
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

## License


    Copyright 2016 Julien Pédron

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.