package com.example.androidcallingwebapi.adapters;


import com.example.androidcallingwebapi.MainActivity;
import com.example.androidcallingwebapi.MainActivity.ProductRowHolder;
import com.example.androidcallingwebapi.models.Product;

import com.example.androidcallingwebapi.R;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProductAdapter extends BaseAdapter implements OnClickListener {

	private LayoutInflater layoutInflater;
	private Product[] products;
	
    public ProductAdapter (MainActivity a, LayoutInflater l, Product[] data)
    {
    	this.layoutInflater = l;
    	this.products = data;
    }
    
	@Override
	public int getCount() {
		return this.products.length;
	}
	
	@Override
    public boolean areAllItemsEnabled () 
    {
    	return true;
    }

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		ProductRowHolder holder;
		
        if (convertView == null) {
        	Log.i("convertView == null", "start");
            convertView = layoutInflater.inflate(R.layout.productrow, parent, false);
            holder = new ProductRowHolder();
            holder.productId = (TextView) convertView.findViewById(R.id.product_id);
            holder.productName = (TextView) convertView.findViewById(R.id.product_name);
            holder.productPrice = (TextView) convertView.findViewById(R.id.product_price);
            convertView.setTag(holder);
            Log.i("convertView == null", "end");
        }
        else {
        	Log.i("convertView != null", "start");
            holder = (ProductRowHolder) convertView.getTag();
            Log.i("convertView != null", "end");
        }
        
   		convertView.setOnClickListener(this);
   		
   		Log.i("Set Product", "start");
   		Log.i("pos", pos +"");
   		Product product = products[pos];
   		holder.product = product;
   		Log.i("productId", product.getId() + "");
   		holder.productId.setText(product.getId() + "");
   		Log.i("productName", product.getName());
   		holder.productName.setText(product.getName());
   		Log.i("productPrice", product.getPrice() + "");
   		holder.productPrice.setText(product.getPrice() + "");
   		Log.i("Set Product", "end");
   		
        return convertView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.i("Click ListView", "");
	}

}
