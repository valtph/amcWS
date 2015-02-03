package com.phvalt.amcws.objects;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class RequestObject implements KvmSerializable{
	public int totalMass ;
	public int buffersNo ;
	public int frequency;
	public int attenuation ;

	public RequestObject(int totalMass, int buffersNo, int frequency,
			int attenuation) {
		super();
		this.totalMass = totalMass;
		this.buffersNo = buffersNo;
		this.frequency = frequency;
		this.attenuation = attenuation;
	}
	@Override
	public Object getProperty(int index){
		switch (index){
		case 0: return totalMass;
		case 1: return buffersNo;
		case 2: return frequency;
		case 3: return attenuation;
		} return null;
	}
	@Override
	public int getPropertyCount(){
		return 4;
	}
	@Override
	public void getPropertyInfo(int index,Hashtable arg1,PropertyInfo info){
		switch(index){
		case 0 : info.type = PropertyInfo.INTEGER_CLASS;
				 info.name = "TotalMass";
				 break;
		case 1: info.type = PropertyInfo.INTEGER_CLASS;
		 		info.name = "BuffersNo";
		 		break;
		case 2: info.type = PropertyInfo.INTEGER_CLASS;
		 		info.name = "Frequency";
		 		break;
		case 3: info.type = PropertyInfo.INTEGER_CLASS;
		 		info.name = "Attenuation";
		 		break; 		
		default:break;
		}
	}
	@Override
	public void setProperty(int index, Object value){
		switch(index){
		case 0: totalMass = Integer.parseInt(value.toString());
		case 1: buffersNo = Integer.parseInt(value.toString());
		case 2: frequency = Integer.parseInt(value.toString());
		case 3: attenuation = Integer.parseInt(value.toString());
		}
	}
	
	
}
