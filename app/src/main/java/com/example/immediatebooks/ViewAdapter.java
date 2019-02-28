package com.example.immediatebooks;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private List<BookListItem> bookListItems;
    private Context context;

    public void setBookListItems(List<BookListItem> bookListItems) {
        this.bookListItems = bookListItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booklist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookListItem bookListItem = bookListItems.get(position);

        holder.title.setText(bookListItem.getTitle());
        holder.id.setText(bookListItem.getId());
    }

    @Override
    public int getItemCount() {
        return bookListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.bookTitle);
            this.id = itemView.findViewById(R.id.bookId);
        }
    }
}
