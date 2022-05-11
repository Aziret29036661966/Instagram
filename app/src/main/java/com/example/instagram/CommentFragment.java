package com.example.instagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.instagram.databinding.FragmentCommentBinding;
import com.example.instagram.db.MyDBManager;

public class CommentFragment extends Fragment {
    private FragmentCommentBinding binding;
    private MyDBManager myDBManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCommentBinding.inflate(inflater);
        myDBManager = new MyDBManager(requireContext());
        onClickSave();
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        myDBManager.openDB();
        for(String title : myDBManager.readFromDB()) {
            binding.txtTitle.append(title);
            binding.txtTitle.append("\n");
        }
    }

    public void onClickSave(){
        binding.btnGet.setOnClickListener(view -> {
            binding.txtTitle.setText("");
            myDBManager.insertToDB(binding.edtComment.getText().toString(), binding.edtComment.getText().toString());
            for(String title : myDBManager.readFromDB()) {
                binding.txtTitle.append(title);
                binding.txtTitle.append("\n");
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myDBManager.closeDB();
    }
}