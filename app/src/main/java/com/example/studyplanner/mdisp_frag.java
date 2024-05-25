package com.example.studyplanner;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mdisp_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mdisp_frag extends Fragment {

    private AppCompatButton verify_btn, logout_btn;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public mdisp_frag() {
        // Required empty public constructor
    }

    public static mdisp_frag newInstance(String param1, String param2) {
        mdisp_frag fragment = new mdisp_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mdisp, container, false);

        // Initialize the buttons
        verify_btn = view.findViewById(R.id.verify);
        logout_btn = view.findViewById(R.id.logout);

        // Set click listeners for the buttons
        verify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_faverify();
            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutButtonClick(v); // Pass the View argument
            }
        });

        return view;
    }

    // Use the View parameter
    public void logoutButtonClick(View view) {
        // Call the logout function here
        SessionManager sessionManager = new SessionManager(getContext()); // Use getContext()
        sessionManager.logout();
    }

    public void openactivity_faverify() {
        Intent intent = new Intent(getActivity(), faverify.class);
        startActivity(intent);
    }
}
