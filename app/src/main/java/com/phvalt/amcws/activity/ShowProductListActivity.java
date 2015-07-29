package com.phvalt.amcws.activity;


import java.util.ArrayList;


import com.phvalt.amcws.R;
import com.phvalt.amcws.objects.*;
import com.phvalt.amcws.imageutils.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ShowProductListActivity extends Activity{
	
	private ArrayList<ResponseObject> products;

	
	private ListView list;
	private LazyAdapter adapter;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_list);
		
		Bundle b=this.getIntent().getExtras();
		products = b.getParcelableArrayList("listResult");
		
		/**Reconstruct List of response object and prepare display**/
		String[] urls = new String[products.size()+1];
		String[] names= new String[products.size()+1];
		for(ResponseObject obj: products){
			urls[obj.getProductIndex()]=obj.getProductImage();
			names[obj.getProductIndex()]=obj.toString();
		}
		
		list=(ListView)findViewById(R.id.list);
        adapter=new LazyAdapter(this, urls, names);
        list.setAdapter(adapter);
		
	}
	 public void onDestroy()
	    {
	        list.setAdapter(null);
	        super.onDestroy();
	    }
	    
	 public OnClickListener listener=new OnClickListener(){
	        @Override
	        public void onClick(View arg0) {
	            adapter.imageLoader.clearCache();
	            adapter.notifyDataSetChanged();
	            
	        }
	    };
	    
	 

	
}
