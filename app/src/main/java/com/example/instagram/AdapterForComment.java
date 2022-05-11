package com.example.instagram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterForComment extends RecyclerView.Adapter<AdapterForComment.ViewHolder> {
    private List<NoteModel> list = new ArrayList<>();
    public void addNewNote(NoteModel model){
        this.list.add(model);
        notifyDataSetChanged();
    }
    public void setNotesList(List <NoteModel> list1) {
        this.list = list1;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textTitle;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textTitle = itemView.findViewById(R.id.txt_title);
        }
        public void bind(NoteModel noteModel){
            textTitle.setText(noteModel.getTitle());
        }
    }
}
