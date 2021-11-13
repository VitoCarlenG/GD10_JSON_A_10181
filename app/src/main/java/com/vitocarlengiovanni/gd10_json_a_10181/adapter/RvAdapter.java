package com.vitocarlengiovanni.gd10_json_a_10181.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vitocarlengiovanni.gd10_json_a_10181.databinding.AdapterCardBinding;
import com.vitocarlengiovanni.gd10_json_a_10181.models.Student;

import java.util.List;
import java.util.stream.Collectors;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> implements Filterable {
    List<Student> listData;
    List<Student> filteredData;

    public RvAdapter(List<Student> data) {
        this.listData = data;
        this.filteredData = data;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RvViewHolder(
                AdapterCardBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        holder.bind(filteredData.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredData.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults Fr = new FilterResults();

                if (charSequence == null || charSequence.length() == 0) {
                    Fr.values = listData;
                } else {
                    Fr.values = listData.stream().filter(data -> data.getFullName().toLowerCase().contains(charSequence)).collect(Collectors.toList());
                }

                return Fr;
            }

            @SuppressLint("NotifyDataSetChanged")
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredData = (List<Student>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class RvViewHolder extends RecyclerView.ViewHolder {
        private AdapterCardBinding binding;

        public RvViewHolder(AdapterCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Student student) {
            String text1 = student.getFullName() + " - " + student.getNpm();
            this.binding.text1.setText(text1);
            String text2 = student.getFakultas() + " - " + student.getProdi();
            this.binding.text2.setText(text2);
        }
    }
}
