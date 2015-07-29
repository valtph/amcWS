package com.phvalt.amcws.objects;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import android.os.Parcel;
import android.os.Parcelable;

public class ResponseObject implements KvmSerializable,Parcelable{
	
	private int position; 
	private String catalogName;
	private String productName;
	private String productImage;
	private String productURL;
	private int catalogId;
	private int familyId;
	private String itemCode ;
	private double productAttenuation;
	private String productStiffness;
	private double loadPercentage;
	


	
	/**Empty constructor**/
	public ResponseObject() {}
	
	public ResponseObject(int pos, String cName, String pName, String pImage, String pURL, int cId, int fId, String iCode, double pAtt, String pStiff, double loadP) {
		super();
		this.position = pos;
		this.catalogName = cName;
		this.productName = pName;
		this.productImage = pImage;
		this.productURL = pURL;
		this.catalogId = cId;
		this.familyId = fId;
		this.itemCode = iCode;
		this.productAttenuation = pAtt;
		this.productStiffness = pStiff;
		this.loadPercentage = loadP;
	}

	
	
	@Override
	public Object getProperty(int index) {
		switch(index){
		case 0:return position;
		case 1:return catalogName;
		case 2:return productName;
		case 3:return productImage;
		case 4:return productURL;
		case 5:return catalogId;
		case 6:return familyId;
		case 7:return itemCode;
		case 8:return productAttenuation;
		case 9:return productStiffness;
		case 10:return loadPercentage;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 11;
	}
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch(index){
		case 0: info.type = PropertyInfo.INTEGER_CLASS;
		 		info.name = "Counter";
		 		break;
		case 1: info.type = PropertyInfo.STRING_CLASS;
		 		info.name = "CatalogName";
		 		break;
		case 2: info.type = PropertyInfo.STRING_CLASS;
 				info.name = "ProductName";
 				break;
		case 3: info.type = PropertyInfo.STRING_CLASS;
 				info.name = "ProductImage";
 				break;
		case 4: info.type = PropertyInfo.STRING_CLASS;
 				info.name = "ProductUrl";
 				break;
		case 5: info.type = PropertyInfo.INTEGER_CLASS;
 				info.name = "CatalogId";
 				break;
		case 6: info.type = PropertyInfo.INTEGER_CLASS;
 				info.name = "FamilyId";
 				break;
		case 7: info.type = PropertyInfo.STRING_CLASS;
 				info.name = "ItemCode";
 				break;
		case 8: info.type = Double.class;
 				info.name = "Attenuation";
 				break;
		case 9: info.type = PropertyInfo.STRING_CLASS;
 				info.name = "Stiffness";
 				break;
		case 10: info.type = Double.class;
				 info.name = "loadPercentage";
		default:break;
		}
	}
	@Override
	public void setProperty(int index, Object value) {
		
		switch(index){
		case 0:position = Integer.parseInt(value.toString());
		case 1:catalogName = value.toString();
		case 2:productName = value.toString();
		case 3:productImage = value.toString();
		case 4:productURL = value.toString();
		case 5:catalogId = Integer.parseInt(value.toString());
		case 6:familyId = Integer.parseInt(value.toString());;
		case 7:itemCode = value.toString();
		case 8:productAttenuation = Double.parseDouble(value.toString());
		case 9:productStiffness = value.toString();
		case 10:loadPercentage = Double.parseDouble(value.toString());
		}
		
	}
	
	public void setPropertyS(int index, String value) {
		
		switch(index){
		case 0:position = Integer.parseInt(value.toString());
		case 1:catalogName = value.toString();
		case 2:productName = value.toString();
		case 3:productImage = value.toString();
		case 4:productURL = value.toString();
		case 5:catalogId = Integer.parseInt(value.toString());
		case 6:familyId = Integer.parseInt(value.toString());;
		case 7:itemCode = value.toString();
		case 8:productAttenuation = Double.parseDouble(value.toString());
		case 9:productStiffness = value.toString();
		case 10:loadPercentage = Double.parseDouble(value.toString());
		}
		
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public void setProductAttenuation(double productAttenuation) {
		this.productAttenuation = productAttenuation;
	}

	public void setProductStiffness(String productStiffness) {
		this.productStiffness = productStiffness;
	}

	public void setLoadPercentage(double loadPercentage) {
		this.loadPercentage = loadPercentage;
	}

	public String getProductImage() {
		return productImage;
	}
	
	public int getProductIndex(){
		return this.position;
	}
	

	public String getProductURL() {
		return productURL;
	}

	public String toString(){
		return " result : "+this.position +" \n "
			   +"catalog : "+ this.catalogName+" \n "
			   +"itemId : "+this.itemCode+" \n "
			   +this.productURL+"\n"
			   +"attenuation : "+this.productAttenuation+" - " +"load :"+this.loadPercentage+"%"+" - " +"stiffness : "+this.productStiffness;
			  
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(position);
		dest.writeString(catalogName);
		dest.writeString(productName);
		dest.writeString(productImage);
		dest.writeString(productURL);
		dest.writeInt(catalogId);
		dest.writeInt(familyId);
		dest.writeString(itemCode) ;
		dest.writeDouble(productAttenuation);
		dest.writeString(productStiffness);
		dest.writeDouble(loadPercentage);
		
	}
	public static final Parcelable.Creator<ResponseObject> CREATOR = new Parcelable.Creator<ResponseObject>()
			{
			    @Override
			    public ResponseObject createFromParcel(Parcel source)
			    {
			        return new ResponseObject(source);
			    }

			    @Override
			    public ResponseObject[] newArray(int size)
			    {
				return new ResponseObject[size];
			    }
			};

			public ResponseObject(Parcel in) {
				this.position = in.readInt();
				this.catalogName = in.readString();
				this.productName = in.readString();
				this.productImage = in.readString();
				this.productURL = in.readString();
				this.catalogId = in.readInt();
				this.familyId = in.readInt();
				this.itemCode=in.readString();
				this.productAttenuation=in.readDouble();
				this.productStiffness=in.readString();
				this.loadPercentage=in.readDouble();
				
				
			}

}