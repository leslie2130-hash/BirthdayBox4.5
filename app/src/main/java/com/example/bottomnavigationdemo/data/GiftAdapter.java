package com.example.bottomnavigationdemo.data;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationdemo.R;
import com.example.bottomnavigationdemo.databinding.BoxCellBinding;

import java.util.ArrayList;
import java.util.List;

public class GiftAdapter extends RecyclerView.Adapter<GiftAdapter.MyViewHolder> {
    private BoxCellBinding binding;
    private List<Gift> list = new ArrayList<>();

    public GiftAdapter() {
        list.add(new Gift("namegift", "send to", "picture sls",R.drawable.clipboard));
        list.add(new Gift("namegift1", "send to", "picture sls",R.drawable.ic_baseline_cake_24));
        list.add(new Gift("namegift2", "send to", "picture sls",R.drawable.ic_baseline_perm_contact_calendar_24));
        list.add(new Gift("namegift3", "send to", "picture sls",R.drawable.ic_baseline_modify_24));
        list.add(new Gift("namegift4", "send to", "picture sls",R.drawable.ic_baseline_home_24));
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = BoxCellBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GiftAdapter.MyViewHolder holder, int position) {
        if (list.size() > 0) {

            binding.name.setText(list.get(position).getName());
            binding.info.setText(list.get(position).getInfo());
            binding.title.setText(list.get(position).getTitle());
            binding.imageView.setImageResource(list.get(position).getPictureId());
        }
    }

    @Override
    public int getItemCount() {
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
