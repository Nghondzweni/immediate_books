package com.example.immediatebooks;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.immediatebooks.model.Feed;
import com.example.immediatebooks.model.Items;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Search extends Fragment {

    private TextView textViewResult;
    private String title = "flowers";
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

        textViewResult = view.findViewById(R.id.textViewResults);

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GoogleBooksApi googleBooksApi = retrofit.create(GoogleBooksApi.class);

        Call <Feed> call = googleBooksApi.getBooks(title);

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " +response.code());
                    System.out.println(textViewResult);
                    return;
                }
                ArrayList<Items> items = response.body().getItems();

                for (Items book : items)
                {
                    String content = "";
                    content += "id: " +book.getBookID() + "\n";
                    content += "title: " +book.getVolumeInfo().getTitle() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

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
