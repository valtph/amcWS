package com.phvalt.amcws.activity;

import java.io.IOException;
import java.util.ArrayList;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.phvalt.amcws.R;
import com.phvalt.amcws.objects.*;

import android.app.Activity;
import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class SearchForProducts extends Activity {

	private static final String TAG = "WSTEST"; // Logging purpose comment before release;
	private EditText paramMass, paramBuffer, paramFreq, paramAtt;
	private Button srchBtn,viewBtn;
	
	private TextView tryResult;
	
	
	private int idioma = 3;

	private RequestObject requestObj;
	private ArrayList<ResponseObject> fullResponse;


	private final String NAMESPACE = "http://tempuri.org/";
	private final String URL = "http://www.mecanocaucho.com/gestor/wsandroid.asmx";
	private final String SOAP_ACTION1 = "http://tempuri.org/SearchForProductsInt";
	private final String METHOD_NAME1 = "SearchForProductsInt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_products_activity);

		paramFreq = (EditText) findViewById(R.id.editText1);
		paramMass = (EditText) findViewById(R.id.editText2);
		paramBuffer = (EditText) findViewById(R.id.editText3);
		paramAtt = (EditText) findViewById(R.id.editText4);
		srchBtn = (Button) findViewById(R.id.srchBtn);
		tryResult = (TextView) findViewById(R.id.tryReponse);
		viewBtn=(Button) findViewById(R.id.viewBtn);
		viewBtn.setVisibility(View.GONE);
		
		viewBtn.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				/** Get Parameters **/
				startDisplayActivity();
			}
		});

		
		srchBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/** Get Parameters **/
				requestObj = new RequestObject(Integer.parseInt(paramMass
						.getText().toString()), Integer.parseInt(paramBuffer
						.getText().toString()), Integer.parseInt(paramFreq
						.getText().toString()), Integer.parseInt(paramAtt
						.getText().toString()));
				AsyncCallWS task = new AsyncCallWS();
				task.execute();
			}
		});

	}

	
	public class AsyncCallWS extends AsyncTask<Void, Integer, Boolean >{

		@Override
		protected Boolean doInBackground(Void... params) {
	
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);

			// add the requestObj
			PropertyInfo totalMass = new PropertyInfo();
			totalMass.setName("TotalMass");
			totalMass.setValue(requestObj.getProperty(0));
			totalMass.setType(PropertyInfo.INTEGER_CLASS);
			request.addProperty(totalMass);

			PropertyInfo buffersNo = new PropertyInfo();
			buffersNo.setName("BuffersNo");
			buffersNo.setValue(requestObj.getProperty(1));
			buffersNo.setType(PropertyInfo.INTEGER_CLASS);
			request.addProperty(buffersNo);

			PropertyInfo frequency = new PropertyInfo();
			frequency.setName("Frequency");
			frequency.setValue(requestObj.getProperty(2));
			frequency.setType(PropertyInfo.INTEGER_CLASS);
			request.addProperty(frequency);

			PropertyInfo attenuation = new PropertyInfo();
			attenuation.setName("Attenuation");
			attenuation.setValue(requestObj.getProperty(3));
			attenuation.setType(PropertyInfo.INTEGER_CLASS);
			request.addProperty(attenuation);

			PropertyInfo lang = new PropertyInfo();
			lang.setName("ididioma");
			lang.setValue(idioma);
			lang.setType(PropertyInfo.INTEGER_CLASS);
			request.addProperty(lang);

			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);

			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);

			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.debug = true;

			fullResponse = new ArrayList<ResponseObject>();

			try {
				androidHttpTransport.call(SOAP_ACTION1, envelope);
				Log.i(TAG, androidHttpTransport.requestDump);

				SoapObject response = (SoapObject) envelope.getResponse();
				 Log.i(TAG,androidHttpTransport.responseDump);

				String howMany = Integer.toString(response.getPropertyCount());
				Log.i(TAG, "number of results" + howMany);
				 Log.i(TAG, response.getProperty(0).toString()); //First
				// shows object AnyType{}
				 Log.i(TAG, response.getProperty(17).toString()); //Second
				// shows object AnyType{}

				for (int i = 0; i < response.getPropertyCount(); i++) {
					SoapObject soapResult = (SoapObject) response
							.getProperty(i);
					// Log.i(TAG,soapResult.toString());

					/** Convert SoapResult to ResponseObject**/
					ResponseObject aResult = new ResponseObject();

					aResult.setPosition(Integer.parseInt(soapResult
							.getProperty("Counter").toString()));
					aResult.setCatalogName(soapResult
							.getProperty("CatalogName").toString());
					aResult.setProductName(soapResult.getProperty(3).toString());
					aResult.setProductImage(soapResult.getProperty(3)
							.toString());
					aResult.setProductURL(soapResult.getProperty(4).toString());
					aResult.setCatalogId(Integer.parseInt(soapResult
							.getProperty(5).toString()));
					aResult.setFamilyId(Integer.parseInt(soapResult
							.getProperty(6).toString()));
					aResult.setItemCode(soapResult.getProperty(7).toString());
					aResult.setProductAttenuation(Double.parseDouble(soapResult
							.getProperty(8).toString()));
					aResult.setProductStiffness(soapResult.getProperty(9)
							.toString());
					aResult.setLoadPercentage(Double.parseDouble(soapResult
							.getProperty(10).toString()));

					fullResponse.add(aResult);
					publishProgress(i);
					Log.i(TAG, "liste " + aResult.toString());

				}
				Log.i(TAG, fullResponse.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return true;
		}

		@Override
		protected void onProgressUpdate(Integer... index) {
			/**fullResponse is a globalVariable type ArrayList<ResponseObject>**/
			tryResult.setText(index[0] + " objects found");
		}
		
		protected void onPostExecute(Boolean param){
			if(param){
				tryResult.append(" All results returned");
				viewBtn.setVisibility(View.VISIBLE);
			}
		}
	}

	public void startDisplayActivity() {
		// TODO Auto-generated method stub
		Intent i = new Intent(SearchForProducts.this, ShowProductListActivity.class);
	    i.putParcelableArrayListExtra("listResult",fullResponse);
	    startActivity(i);
	}

}
