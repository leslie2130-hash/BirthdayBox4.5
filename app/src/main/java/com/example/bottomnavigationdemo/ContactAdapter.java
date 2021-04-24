package com.example.bottomnavigationdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationdemo.data.Friend;
import com.example.bottomnavigationdemo.databinding.ContactCellBinding;


import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    private ContactCellBinding binding;
    private FriendViewModel viewModel;
    private IOnClickListener listener;

    public ContactAdapter(FriendViewModel viewModel, IOnClickListener listener) {
        this.viewModel = viewModel;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ContactCellBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new MyViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        List<Friend> list = viewModel.getList().getValue();
        if (list.size() > 0) {
            Friend friend = list.get(position);
            binding.name.setText(friend.getName());
            binding.imageView.setImageResource(R.drawable.test1);
            //binding.hobby.setText(friend.getHobby());
            //binding.index.setText(String.valueOf(position + 1));
        }
    }

    @Override
    public int getItemCount() {
        List<Friend> list = viewModel.getList().getValue();
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ContactCellBinding binding;
        private IOnClickListener listener;

        public MyViewHolder(@NonNull ContactCellBinding itemView, IOnClickListener listener) {
            super(itemView.getRoot());
            binding = itemView;
            itemView.getRoot().setOnClickListener(this);
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            listener.onClick(getAdapterPosition());
        }


    }

    public  interface IOnClickListener{
        void onClick(int position);
    }
}
