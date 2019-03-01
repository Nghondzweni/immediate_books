package com.example.immediatebooks;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private List<BookListItem> bookListItems;
    private Context context;

    public void setBookListItems(List<BookListItem> bookListItems, Context context) {
        this.bookListItems = bookListItems;
        this.context = context;
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
        holder.author.setText(bookListItem.getAuthor());
        holder.favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Added to Favorites", Toast.LENGTH_SHORT).show();
            }
        });
        holder.to_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Added to Read Later", Toast.LENGTH_SHORT).show();
            }
        });
//        holder.id.setText(bookListItem.getId());

        Picasso.get()
                .load(bookListItem.getThumbnail())
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return bookListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
//        private TextView id;
        private TextView author;
        private ImageView thumbnail;
        private Button favorites;
        private Button to_read;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.bookTitle);
//            this.id = itemView.findViewById(R.id.bookId);
            this.author = itemView.findViewById(R.id.bookAuthor);
            this.thumbnail = itemView.findViewById(R.id.thumbnail);
            this.favorites = itemView.findViewById(R.id.bn_favorites);
            this.to_read = itemView.findViewById(R.id.bn_to_read);
        }
    }
}
