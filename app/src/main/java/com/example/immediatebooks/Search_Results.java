package com.example.immediatebooks;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Search_Results extends Fragment {

    private TextView textView;

    public Search_Results() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search__results, container, false);

        textView = view.findViewById(R.id.search_results);
        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        textView.setText(message);

        return view;
    }

}
