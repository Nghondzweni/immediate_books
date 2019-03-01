package com.example.immediatebooks;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.immediatebooks.model.Feed;
import com.example.immediatebooks.model.Items;

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
public class Search_Results extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<BookListItem> bookListItems;



    public Search_Results() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_search__results, container, false);

        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);


                Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GoogleBooksApi googleBooksApi = retrofit.create(GoogleBooksApi.class);

        Call<Feed> call = googleBooksApi.getBooks(message);

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if(!response.isSuccessful()){
//                    textViewResult.setText("Code: " +response.code());
                    System.out.println("here1");
                    return;
                }
                ArrayList<Items> items = response.body().getItems();

                System.out.println("here3");

                recyclerView.setHasFixedSize(true);
                bookListItems = new ArrayList<>();


                for (Items book : items)
                {

                    BookListItem bookListItem = new BookListItem(
                            book.getVolumeInfo().getTitle(), book.getBookID(), "Author: " +book.getVolumeInfo().getAuthors().get(0), book.getVolumeInfo().getImageLinks().getThumbnail()
                    );
                    bookListItems.add(bookListItem);

                }
                adapter = new ViewAdapter();
                ((ViewAdapter) adapter).setBookListItems(bookListItems);
                recyclerView.setAdapter(adapter);
            }


            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
                System.out.println("here2");
            }
        });


        return view;
    }

}
