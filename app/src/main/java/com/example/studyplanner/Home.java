package com.example.studyplanner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.studyplanner.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {


    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainframe, new mdisp_frag())
                    .commit();
        }

        // Inflate the binding layout and set content view
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Find DrawerLayout
        final DrawerLayout drawerLayout = findViewById(R.id.main);

        // Set item selected listener for bottom navigation view
        binding.bnv.setOnItemSelectedListener(itemId -> {
            if (itemId.getItemId() == R.id.home) {
                repFragment(new mdisp_frag());
            } else if (itemId.getItemId() == R.id.splanner) {
                repFragment(new splanner_frag());
            } else if (itemId.getItemId() == R.id.resources) {
                 repFragment(new resources_frag());
            }
            return true;
        });
    }

    // Replace fragment method
    private void repFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainframe, fragment);
        fragmentTransaction.commit();
    }
}
