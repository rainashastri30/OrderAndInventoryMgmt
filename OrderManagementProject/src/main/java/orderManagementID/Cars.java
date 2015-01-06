package orderManagementID;

import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;



@EnableAutoConfiguration
@Configuration
@ComponentScan()
public class Cars {
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	@Id
	private String id;
	
	private String model;
	private String price;
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	private String yearofmanufacture;
	private Date startDate;
	private Date endDate;
	private String condition;
	private String mileage;
	private String description;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		description = description;
	}

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

	public String getYearofmanufacture() {
		return yearofmanufacture;
	}

	public void setYearofmanufacture(String yearofmanufacture) {
		this.yearofmanufacture = yearofmanufacture;
	}
	
//	private Date startDate;
	
//	private String FirstName;
	
//	private Date endDate;
	
	

}
