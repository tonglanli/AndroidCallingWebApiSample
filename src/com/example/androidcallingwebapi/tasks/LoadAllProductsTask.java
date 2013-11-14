package com.example.androidcallingwebapi.tasks;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import com.example.androidcallingwebapi.JSONHttpClient;
import com.example.androidcallingwebapi.models.Product;
import com.example.androidcallingwebapi.util.ServiceUrl;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class LoadAllProductsTask extends AsyncTask<String, String, Product[]> {

	public Context context;
	private ProgressDialog progressDialog;
	
	public LoadAllProductsTask(Context context) {
		super();
		this.context = context;
	}

    @Override
    protected Product[] doInBackground(String... params) {
        Log.i("Task", "Task Start");
    	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        JSONHttpClient jsonHttpClient = new JSONHttpClient();
        Product[] products = jsonHttpClient.Get(ServiceUrl.PRODUCT, nameValuePairs, Product[].class);
        Log.i("Task", "Task End");
        return products;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();    //To change body of overridden methods use File | Settings | File Templates.
        /*
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading products. Please wait...");
        progressDialog.show();
        */
    }

}
