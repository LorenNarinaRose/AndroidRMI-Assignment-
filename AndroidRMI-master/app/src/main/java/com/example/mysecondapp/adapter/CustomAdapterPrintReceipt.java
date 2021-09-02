package com.example.mysecondapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mysecondapp.R;
import com.example.mysecondapp.model.Toy;

import java.util.List;

public class CustomAdapterPrintReceipt extends RecyclerView.Adapter<CustomAdapterPrintReceipt.ViewHolder> {
    private List<Toy> toys;
    public CustomAdapterPrintReceipt(List<Toy> toys){
        this.toys = toys;
    }

    @Override
    public CustomAdapterPrintReceipt.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_print_receipt, parent, false);
        return new ViewHolder(rowItem);
    }

    @Override
    public void onBindViewHolder(CustomAdapterPrintReceipt.ViewHolder holder, int position) {
        holder.textView.setText(this.toys.get(position).getName());
        holder.price.setText("KSH "+this.toys.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return this.toys.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private TextView price;
        private ImageView addPriceButton;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            this.textView = view.findViewById(R.id.tvToyName);
            this.price = view.findViewById(R.id.tvToyPrice);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "position : " + getLayoutPosition() + " text : " + this.textView.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}