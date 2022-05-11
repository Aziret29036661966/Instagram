package com.example.instagram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagram.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements AdapterForStory.ItsForStoryInterface, AdapterForList.Callback {
    private FragmentMainBinding binding;
    private AdapterForStory adapter;
    private AdapterForList adapter1;
    private NavController controller;
    List<ModelForList> modelForLists = new ArrayList<>();
    ArrayList<ModelForStory> model = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initScroll();
        initData();
        initAdapter();
        initController();
        initAdapterTwo();
        initDataTwo();
        goToCamera();
    }
    private void initController() {
        NavHostFragment navHostController = (NavHostFragment)
                requireActivity().getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);
        controller = navHostController.getNavController();
    }

    private void initScroll() {
        binding.listProfile.setNestedScrollingEnabled(false);
    }

    private void initAdapterTwo() {
        adapter1 = new AdapterForList(modelForLists, this);
        binding.listProfile.setAdapter(adapter1);
        adapter1.notifyDataSetChanged();
    }

    private void initDataTwo() {
        modelForLists.add(new ModelForList(R.drawable.negr, R.drawable.rec,  "negr228 Tokyo, Japan"));
        modelForLists.add(new ModelForList(R.drawable.negr, R.drawable.rec, "negr228 Tokyo, Japan"));
        modelForLists.add(new ModelForList(R.drawable.negr, R.drawable.rec, "negr228 Tokyo, Japan"));
        modelForLists.add(new ModelForList(R.drawable.negr, R.drawable.rec, "negr228 Tokyo, Japan"));
        modelForLists.add(new ModelForList(R.drawable.negr, R.drawable.rec,  "negr228 Tokyo, Japan"));
        modelForLists.add(new ModelForList(R.drawable.negr, R.drawable.rec,  "negr228 Tokyo, Japan"));
        modelForLists.add(new ModelForList(R.drawable.negr, R.drawable.rec,  "negr228 Tokyo, Japan"));
    }

    private void initData() {
        model = new ArrayList<>();
        model.add(new ModelForStory(R.drawable.cool,R.drawable.ebannysamez, "ebanyuSamez228  "));
        model.add(new ModelForStory(R.drawable.cool,R.drawable.rec, "ebanyuSamez228  "));
        model.add(new ModelForStory(R.drawable.cool,R.drawable.ebannysamez, "ebanyuSamez228  "));
        model.add(new ModelForStory(R.drawable.cool,R.drawable.rec, "ebanyuSamez228  "));
        model.add(new ModelForStory(R.drawable.cool,R.drawable.ebannysamez, "ebanyuSamez228  "));
        model.add(new ModelForStory(R.drawable.cool,R.drawable.rec, "ebanyuSamez228  "));

    }

    private void initAdapter() {
        adapter = new AdapterForStory(model, this);
        binding.rvStories.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void click(int position) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("model", adapter.getList());
        bundle.putInt("position", position);
        controller.navigate(R.id.storyAfterFragment, bundle);
    }

    @Override
    public void Click(int position) {
    }

    @Override
    public void flick(int position) {
        controller.navigate(R.id.commentFragment);
    }
    public void goToCamera(){
        binding.imgCamera.setOnClickListener(view -> controller.navigate(R.id.cameraFragment));
    }
}