package com.example.androidcallingwebapi.tasks;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.androidcallingwebapi.MainActivity;
import com.example.androidcallingwebapi.R;
import com.example.androidcallingwebapi.clients.JSONHttpClient;
import com.example.androidcallingwebapi.models.Product;
import com.example.androidcallingwebapi.util.ServiceUrl;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class LoadAllProductsTask extends AsyncTask<String, String, Product[]> {

	private ProgressDialog progDialog;
	private Context context;
	private MainActivity activity;
	
	public LoadAllProductsTask(MainActivity activity) {
		super();
		this.activity = activity;
		this.context = this.activity.getApplicationContext();
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
        progDialog = ProgressDialog.show(this.activity, "Search", this.context.getResources().getString(R.string.looking_for_products) , true, false);
    }

    @Override
    protected void onPostExecute(Product[] result) 
    {
    	super.onPostExecute(result);
    	progDialog.dismiss();   
    }
}
