package com.phvalt.amcws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.R.integer;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class MainActivity extends Activity {

	private static final String TAG = "WSTEST"; // Logging purpose
	private EditText paramMass,paramBuffer, paramFreq, paramAtt;
	private TextView tryResult,tryRequest;
	private int idioma = 3;
	private Button srchBtn;
	private RequestObject requestObj;
	private ArrayList<ResponseObject> fullResponse;
	
	private final String NAMESPACE = "http://tempuri.org/";
	private final String URL = "http://www.mecanocaucho.com/gestor/wsandroid.asmx";
	private final String SOAP_ACTION1 = "http://tempuri.org/SearchForProductsInt";
	private final String METHOD_NAME1 = "SearchForProductsInt";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        paramFreq = (EditText)findViewById(R.id.editText1);
        paramMass = (EditText)findViewById(R.id.editText2);
        paramBuffer = (EditText)findViewById(R.id.editText3);
        paramAtt = (EditText)findViewById(R.id.editText4);
        srchBtn = (Button)findViewById(R.id.srchBtn);
        tryResult = (TextView)findViewById(R.id.tryReponse);
        tryRequest = (TextView)findViewById(R.id.tryRequest);
        
        srchBtn.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
			/**Get Parameters**/
				requestObj = new RequestObject(
						Integer.parseInt(paramMass.getText().toString()),
						Integer.parseInt(paramBuffer.getText().toString()),
						Integer.parseInt(paramFreq.getText().toString()),
						Integer.parseInt(paramAtt.getText().toString())
						);
				AsyncCallWS task = new AsyncCallWS();
				task.execute();
			}
		});
    }

	private void postRequest(RequestObject requestObj) {
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
		
		//add the requestObj
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
		
		envelope.dotNet=true;
		envelope.setOutputSoapObject(request);
		
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.debug =true;
		
		fullResponse = new ArrayList<ResponseObject>();
		
		try {
			androidHttpTransport.call(SOAP_ACTION1,envelope);
			Log.i(TAG, androidHttpTransport.requestDump);
			
			SoapObject response=(SoapObject) envelope.getResponse();
			Log.i(TAG,androidHttpTransport.responseDump);
			
			String howMany =Integer.toString(response.getPropertyCount()); 
			Log.i(TAG,"number of results" +howMany);
			Log.i(TAG, response.getProperty(0).toString());
			Log.i(TAG, response.getProperty(1).toString());
			
	/**		for (int i=0; i<response.getPropertyCount();i++){
				SoapObject soapResult = (SoapObject) response.getProperty(i);
				ResponseObject aResult = new ResponseObject();
				for(int j=0;j<soapResult.getPropertyCount();j++){
					aResult.setProperty(j, soapResult.getProperty(j));
				}
		}**/	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private class AsyncCallWS extends AsyncTask<Double, Void, Void>{

		@Override
		protected Void doInBackground(Double... params) {
			postRequest(requestObj);
			return null;
		}
		@Override
		protected void onProgressUpdate(Void... values) {
		}
		
		protected void onFinish(Void...String){
			
		}
	}
	
   
}
