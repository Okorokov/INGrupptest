package com.example.hpsus.ingrupptest;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<Offer> data;
    private String btnText;


    public DataAdapter(List<Offer> data) {
        this.data = data;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder viewHolder, final int i) {

            viewHolder.tvOfferName.setText(data.get(i).getName());
            viewHolder.tvDes.setText(data.get(i).getDes());
            Picasso.with(viewHolder.context).load(data.get(i).getLogo()).into(viewHolder.ivLogo);
            viewHolder.btn.setText(data.get(i).getBtn());
            //View mCurrentView = viewHolder.itemView;
            viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(viewHolder.context,data.get(i).getBtn(),Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(viewHolder.context, OfferActivity.class);

                    intent.putExtra(MainActivity.KEY_ID,data.get(i).getId());
                    intent.putExtra(MainActivity.KEY_NAME,data.get(i).getName());
                    intent.putExtra(MainActivity.KEY_DES,data.get(i).getDes());
                    intent.putExtra(MainActivity.KEY_LOGO,data.get(i).getLogo());
                    intent.putExtra(MainActivity.KEY_URL,data.get(i).getUrl());
                    intent.putExtra(MainActivity.KEY_BTN,data.get(i).getBtn());
                    intent.putExtra(MainActivity.KEY_BTN2,data.get(i).getBtn2());
                    intent.putExtra(MainActivity.KEY_BROWSER,data.get(i).getBrowser());
                    intent.putExtra(MainActivity.KEY_ENABLED,data.get(i).getEnabled());
                    intent.putExtra(MainActivity.KEY_DESC_FULL,data.get(i).getDescFull());
                    viewHolder.context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvOfferName,tvDes;
        private ImageView ivLogo;
        private Context context;
        private Button btn;
        public ViewHolder(View view) {
            super(view);

            tvOfferName = (TextView)view.findViewById(R.id.tvOfferName);
            tvDes= (TextView)view.findViewById(R.id.tvDes);
            btn= (Button)view.findViewById(R.id.btn);
            ivLogo=(ImageView)view.findViewById(R.id.ivLogo);
            context=view.getContext();
        }
    }

}