package com.example.instagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterForStory extends RecyclerView.Adapter<AdapterForStory.ViewHolder> {
    private ArrayList<ModelForStory> modelForStoryList = new ArrayList<>();
    private final ItsForStoryInterface rec;
    public AdapterForStory(ArrayList<ModelForStory> model, ItsForStoryInterface rec) {
        this.modelForStoryList= model;
        this.rec = rec;
    }

    public ArrayList<ModelForStory> getList(){
        return modelForStoryList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_storeis
                ,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    int image = modelForStoryList.get(position).getImages();
    String samez = modelForStoryList.get(position).getIsAddStory();
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            rec.click(holder.getAdapterPosition());
        }
    });
        holder.setData(image, samez);
        return ;
    }

    @Override
    public int getItemCount() {

        return modelForStoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView;
    private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cool_man);
            textView = itemView.findViewById(R.id.txt_samez);
        }

        public void setData(int image, String samez) {
            imageView.setImageResource(image);
            textView.setText(samez);

        }
    }
    public interface ItsForStoryInterface{
          void click (int position);

        void Click(int position);
    }
  
}
