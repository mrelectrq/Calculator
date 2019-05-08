package com.example.startaplication;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class StringsAdapter extends RecyclerView.Adapter<StringsAdapter.StringHolder> {

    private ArrayList<String> notes;

    public class StringHolder extends RecyclerView.ViewHolder {
        private TextView textViewDescription;

        public StringHolder(View itemView) {
            super(itemView);
            textViewDescription = itemView.findViewById(R.id.number_result_string);
        }

    }

    public StringsAdapter(ArrayList<String> data) {
        this.notes = data;
    }


    @NonNull
    @Override
    public StringHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_add_item, parent, false);

        return new StringHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull StringHolder stringHolder, int i) {
        stringHolder.textViewDescription.setText(notes.get(i));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }


    public void addItem(String value) {
        notes.add(0, value);
        notifyItemInserted(0);
    }

    public void removeItem(int position) {
        notes.remove(position);
        notifyItemRemoved(position);
    }


}
