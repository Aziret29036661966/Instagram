package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.instagram.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private NavController controller;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initController();
        initBottomNavigation();
    }

    private void initController() {
        NavHostFragment navHostController = (NavHostFragment)
                this.getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);
        controller = navHostController.getNavController();
    }

    private void initBottomNavigation() {
        NavigationUI.setupWithNavController(binding.bottomNavigation, controller);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            return true;
        });
    }
}