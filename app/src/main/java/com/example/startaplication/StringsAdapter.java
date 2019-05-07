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

public class StringsAdapter extends RecyclerView.Adapter<StringsAdapter.StringHolder>{

    private List<String> notes = new ArrayList<>();
    private LayoutInflater mInflater;
    private AdapterView.OnItemClickListener mClickListener;

    StringsAdapter(Context context, List<String> data){
        this.mInflater= LayoutInflater.from(context);
        this.notes=data;
    }
    @NonNull
    @Override
    public StringHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.list_add_item, viewGroup, false);

        return new StringHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StringHolder stringHolder, int i) {
        String currentnote = notes.get(i);
        stringHolder.textViewDescription.setText(currentnote);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<String> notes){
        this.notes=notes;

    }

    class StringHolder extends  RecyclerView.ViewHolder{
        private TextView textViewDescription;

        public  StringHolder(View itemView){
            super(itemView);
            textViewDescription= itemView.findViewById(R.id.number_result_string);
        }

    }

}
