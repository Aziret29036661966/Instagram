package com.example.instagram;

import android.media.TimedMetaData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterForList extends RecyclerView.Adapter<AdapterForList.ViewHolder> {
    List<ModelForList> modelForLists = new ArrayList<>();
    private final Callback flick;
    public AdapterForList(List<ModelForList> modelForListList, Callback flick) {
        this.modelForLists= modelForListList;
        this.flick = flick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list
                ,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image = modelForLists.get(position).getImage();
        int image1 = modelForLists.get(position).getImage1();
        String name = modelForLists.get(position).getName();
        holder.image_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flick.flick(holder.getAdapterPosition());
            }
        });
        holder.setData(image, image1, name);
        return ;
    }
    @Override
    public int getItemCount() {
        return modelForLists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView, imageView1, imageView_like, image_chat, image_get, image_fix;
        private TextView textView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.negr);
            textView = itemView.findViewById(R.id.name);
            imageView1 = itemView.findViewById(R.id.rectangle);
            imageView_like = itemView.findViewById(R.id.img_like);
            image_chat = itemView.findViewById(R.id.img_chat);
            image_get = itemView.findViewById(R.id.img_get);
            image_fix = itemView.findViewById(R.id.img_fix);
        }

        public void setData(int image, int image1, String name) {
            imageView.setImageResource(image);
            textView.setText(name);
            imageView1.setImageResource(image1);
        }
    }
    public interface Callback{
     public void flick(int position);
    }
}
