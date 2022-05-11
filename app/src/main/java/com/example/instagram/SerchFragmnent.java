package com.example.instagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagram.databinding.FragmentMainBinding;
import com.example.instagram.databinding.FragmentSerchFragmnentBinding;

public class SerchFragmnent extends Fragment {
private FragmentSerchFragmnentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSerchFragmnentBinding.inflate(inflater);
        return binding.getRoot();
    }
}