package orderManagementID;

import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;



@EnableAutoConfiguration
@Configuration
@ComponentScan()
public class Tvs {
	
@Id
private String id;
private String brand;
private String HD;
private String diagonalLength;
private String length;
private String width;
public String getLength() {
	return length;
}
public void setLength(String length) {
	this.length = length;
}
private String price;
private String height;
private String description;
private String warrantyPeriod;
private Date startDate;
private Date endDate;

public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}

public String getHD() {
	return HD;
}
public void setHD(String hD) {
	HD = hD;
}
public String getDiagonalLength() {
	return diagonalLength;
}
public void setDiagonalLength(String diagonalLength) {
	this.diagonalLength = diagonalLength;
}
public String getDiagonallength() {
	return diagonalLength;
}
public void setDiagonallength(String diagonallength) {
	this.diagonalLength = diagonallength;
}
public String getWidth() {
	return width;
}
public void setWidth(String width) {
	this.width = width;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getHeight() {
	return height;
}
public void setHeight(String height) {
	this.height = height;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getWarrantyPeriod() {
	return warrantyPeriod;
}
public void setWarrantyPeriod(String warrantyPeriod) {
	this.warrantyPeriod = warrantyPeriod;
}



}
