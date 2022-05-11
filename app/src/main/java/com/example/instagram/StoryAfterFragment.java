package com.example.instagram;

import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.instagram.databinding.FragmentStoryAfterBinding;

import java.util.ArrayList;

public class StoryAfterFragment extends Fragment {
    private FragmentStoryAfterBinding binding;
    private ArrayList<ModelForStory> stories;
    int position = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStoryAfterBinding.inflate(inflater);
        initArgument();
        nextAndPrevious();
        return binding.getRoot();
    }

    private void initArgument() {
        if (getArguments() != null) {
            stories = getArguments().getParcelableArrayList("model");
            position = getArguments().getInt("position");
            binding.imgSamez.setImageResource(stories.get(position).getImage_ebanny_samez());
        }
    }

    private void nextAndPrevious() {
        binding.imgNext.setOnClickListener(view -> {
            position++;
            binding.imgSamez.setImageResource(stories.get(position).getImage_ebanny_samez());
        });
        binding.imgPrevious.setOnClickListener(view -> {
            position--;
            binding.imgSamez.setImageResource(stories.get(position).getImage_ebanny_samez());
        });
    }
}