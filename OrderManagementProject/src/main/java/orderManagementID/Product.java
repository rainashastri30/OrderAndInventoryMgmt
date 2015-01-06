package orderManagementID;

import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan()
public class Product {

	//

	private String prodId;

	private String setErrorMessage;

	private Date orderDate;

	private String orderStatus;

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getSetErrorMessage() {
		return setErrorMessage;
	}

	public void setSetErrorMessage(String setErrorMessage) {
		this.setErrorMessage = setErrorMessage;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdBrand() {
		return prodBrand;
	}

	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}

	public Date getProdStartDate() {
		return prodStartDate;
	}

	public void setProdStartDate(Date prodStartDate) {
		this.prodStartDate = prodStartDate;
	}

	public Date getProdEndDate() {
		return prodEndDate;
	}

	public void setProdEndDate(Date prodEndDate) {
		this.prodEndDate = prodEndDate;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public String getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdHd() {
		return prodHd;
	}

	public void setProdHd(String prodHd) {
		this.prodHd = prodHd;
	}

	public String getProdDiagonallength() {
		return prodDiagonallength;
	}

	public void setProdDiagonallength(String prodDiagonallength) {
		this.prodDiagonallength = prodDiagonallength;
	}

	public String getProdWidth() {
		return prodWidth;
	}

	public void setProdWidth(String prodWidth) {
		this.prodWidth = prodWidth;
	}

	public String getProdLength() {
		return prodLength;
	}

	public void setProdLength(String prodLength) {
		this.prodLength = prodLength;
	}

	public String getProdHeight() {
		return prodHeight;
	}

	public void setProdHeight(String prodHeight) {
		this.prodHeight = prodHeight;
	}

	public String getProdWarrantyPeriod() {
		return prodWarrantyPeriod;
	}

	public void setProdWarrantyPeriod(String prodWarrantyPeriod) {
		this.prodWarrantyPeriod = prodWarrantyPeriod;
	}

	public String getProdColor() {
		return prodColor;
	}

	public void setProdColor(String prodColor) {
		this.prodColor = prodColor;
	}

	public String getProdModel() {
		return prodModel;
	}

	public void setProdModel(String prodModel) {
		this.prodModel = prodModel;
	}

	public String getProdYearofmanufacture() {
		return prodYearofmanufacture;
	}

	public void setProdYearofmanufacture(String prodYearofmanufacture) {
		this.prodYearofmanufacture = prodYearofmanufacture;
	}

	public String getProdCondition() {
		return prodCondition;
	}

	public void setProdCondition(String prodCondition) {
		this.prodCondition = prodCondition;
	}

	public String getProdMileage() {
		return prodMileage;
	}

	public void setProdMileage(String prodMileage) {
		this.prodMileage = prodMileage;
	}

	private String prodBrand;
	private Date prodStartDate;
	private Date prodEndDate;
	private String prodDescription;
	private String prodPrice;

	private String prodHd;
	private String prodDiagonallength;
	private String prodWidth;
	private String prodLength;

	private String prodHeight;
	private String prodWarrantyPeriod;

	private String prodColor;

	private String prodModel;
	private String prodYearofmanufacture;
	private String prodCondition;
	private String prodMileage;
	private String prodCategory;
	private int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + "]";
	}

}
