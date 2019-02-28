package com.example.immediatebooks;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class Search extends Fragment {



    private EditText editText;
    Button button;
    OnSearchListener onSearchListener;



    public interface OnSearchListener
    {
        public void onSearch(String message);
    }


    public Search() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_search, container, false);



        button = view.findViewById(R.id.bn_search);
        editText = view.findViewById(R.id.txt_query);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                onSearchListener.onSearch(message);
            }
        });

        ImageView imageView = view.findViewById(R.id.book_image);

        Picasso.get().load(R.drawable.book).resize(450,450).into(imageView);



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            onSearchListener =  (OnSearchListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+"Must implement onMessageSend...");
        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
        editText.setText("");
    }

}
