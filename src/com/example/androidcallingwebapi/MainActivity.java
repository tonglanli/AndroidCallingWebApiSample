package com.example.androidcallingwebapi;


import java.util.concurrent.ExecutionException;

import com.example.androidcallingwebapi.adapters.ProductAdapter;
import com.example.androidcallingwebapi.models.Product;
import com.example.androidcallingwebapi.tasks.LoadAllProductsTask;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView productList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.productList = (ListView) findViewById(R.id.product_list);
		LoadAllProductsTask loadAllProductsTask = new LoadAllProductsTask(MainActivity.this.getApplicationContext());
		Product[] products = null;
		try {
			loadAllProductsTask.execute();
        }
        catch (Exception e)
        {
        	loadAllProductsTask.cancel(true);
            //alert (getResources().getString(R.string.no_products));
        }
		try {
			Log.i("loadAllProductsTask", "Task Start");
			products = loadAllProductsTask.get();
			Log.i("loadAllProductsTask", "Task End");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(products != null)
		{
			Log.i("Geted Product Count:", products.length + "Start");
			this.productList.setAdapter(new ProductAdapter(this,LayoutInflater.from(this), products));
			Log.i("Geted Product Count:", products.length + "End");
		}
		else
		{
			Log.i("Geted Product Count:", "null");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    public static class ProductRowHolder {
        public TextView productId, productName, productPrice;
        public Product product;
    }
}
