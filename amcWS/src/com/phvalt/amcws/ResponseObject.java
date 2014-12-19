package com.phvalt.amcws;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class ResponseObject implements KvmSerializable{
	
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

	public ResponseObject() {}
	
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

	
}