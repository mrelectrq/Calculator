package com.example.startaplication.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Adapter;

public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback{

    //https://www.journaldev.com/23164/android-recyclerview-swipe-to-delete-undo

    private Adapter myAdapter;

    public SwipeToDeleteCallback(Adapter adapter){
        super(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT);
        myAdapter = adapter;
    }




    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int position = viewHolder.getAdapterPosition();
    }


    public void deleteItem(int position){


    }
}
