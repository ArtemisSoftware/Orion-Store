package com.artemissoftware.orionstore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.artemissoftware.orionstore.IMainActivity;
import com.artemissoftware.orionstore.R;
import com.artemissoftware.orionstore.databinding.ProductItemBinding;
import com.artemissoftware.orionstore.models.Product;

import java.util.ArrayList;
import java.util.List;




public class ProductsAdapter extends  RecyclerView.Adapter<ProductsAdapter.BindingHolder>{

    private static final String TAG = "ProductsAdapter";

    private List<Product> mProducts = new ArrayList<>();
    private Context mContext;

    public ProductsAdapter(Context context, List<Product> products) {
        mProducts = products;
        mContext = context;
    }

    public void refreshList(List<Product> products){
        mProducts.clear();
        mProducts.addAll(products);
        notifyDataSetChanged();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.product_item, parent, false);

        ProductItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.product_item, parent, false);

        return new BindingHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {

        Product product = mProducts.get(position);
        holder.binding.setProduct(product);
        holder.binding.setIMainActivity((IMainActivity) mContext);

        //when image comes from url
        //holder.binding.setTestUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Uranometria_orion.jpg/500px-Uranometria_orion.jpg");
//        holder.binding.setVariable(BR.product, product);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }



    public class BindingHolder extends RecyclerView.ViewHolder{

//        ViewDataBinding binding;
        ProductItemBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }



}













