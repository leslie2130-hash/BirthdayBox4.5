package com.example.bottomnavigationdemo.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationdemo.Useless.Card;
import com.example.bottomnavigationdemo.Useless.CardViewModel;
import com.example.bottomnavigationdemo.databinding.BoxCellBinding;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {
    private BoxCellBinding binding;
    private CardViewModel viewModel;

    public CardAdapter(CardViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = BoxCellBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        List<Card> list = viewModel.getList().getValue();
        if (list.size() > 0) {
            Card card = list.get(position);
            binding.name.setText(card.getName());
            binding.info.setText(card.getInfo());
            binding.title.setText(card.getTitle());
            card.setIndex(position + 1);

        }
    }

    @Override
    public int getItemCount() {
        List<Card> list = viewModel.getList().getValue();
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private BoxCellBinding binding;

        public MyViewHolder(@NonNull BoxCellBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
