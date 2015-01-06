package orderManagementID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@EnableAutoConfiguration
@Configuration
@ComponentScan()
public class ProductInfoService {

	@Autowired
	private Mongo mongo;

	@Autowired
	DataSource dataSource;

	@Autowired
	Product product;

	@Autowired
	Cars car;

	@Autowired
	Tvs tvs;

	@Autowired
	Nps nps;
	// private CarRepository carRepository;

	@Autowired
	CustomerOrderProductInfo customerOrderProductInfo;

	public Product checkProductAvailability(String product_id,
			String productType, String name) throws Exception {

		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoOperations mongoOps = new MongoTemplate(mongo, "test");
		Product prodInfo = new Product();

		//check for car availability
		if (productType.equalsIgnoreCase("cars")) {
			car = mongoOps.findOne(
					new Query(Criteria.where("_id").is(product_id)),
					Cars.class, productType);
			

			if (car != null) {

				Date startDate = car.getStartDate();
				Date endDate = car.getEndDate();
				Date current = new Date();

				if (endDate != null) {

					if (current.after(startDate) && current.before(endDate)) {

						if (checkInventoryForProductAvailabilty(product_id,
								productType) != 0) {

							// product = mapperFunction(productType);

							if (productType.equalsIgnoreCase("cars")) {
								if (car != null) {
									prodInfo.setProdId(car.getId());
									prodInfo.setProdModel(car.getModel());
									prodInfo.setProdYearofmanufacture(car
											.getYearofmanufacture());
									prodInfo.setProdCondition(car
											.getCondition());
									prodInfo.setProdMileage(car.getMileage());
									prodInfo.setProdDescription(car
											.getDescription());
									prodInfo.setProdPrice(car.getPrice());

								}
							}

						}

					}
				}

				else {

					if (checkInventoryForProductAvailabilty(product_id,
							productType) != 0) {

						// product = mapperFunction(productType);

						if (productType.equalsIgnoreCase("cars")) {
							if (car != null) {
								prodInfo.setProdId(car.getId());
								prodInfo.setProdModel(car.getModel());
								prodInfo.setProdYearofmanufacture(car
										.getYearofmanufacture());
								prodInfo.setProdCondition(car.getCondition());
								prodInfo.setProdMileage(car.getMileage());
								prodInfo.setProdDescription(car
										.getDescription());
								prodInfo.setProdPrice(car.getPrice());

							}
						}

					}

				}

			}
		}
		
		//check for tv availability

		if (productType.equalsIgnoreCase("tvs")) {

			tvs = mongoOps.findOne(
					new Query(Criteria.where("_id").is(product_id)), Tvs.class,
					productType);

			if (tvs != null) {

				Date startDate = tvs.getStartDate();
				Date endDate = tvs.getEndDate();
				Date current = new Date();

				if (endDate != null) {
					if (current.after(startDate) && current.before(endDate)) {

						// int productCount =
						// checkInventoryForProductAvailabilty(
						// product_id, product);
						if (checkInventoryForProductAvailabilty(product_id,
								productType) != 0) {
							// carList.add(car);

							// product = mapperFunction(productType);

							if (productType.equalsIgnoreCase("tvs")) {

								if (tvs != null) {

									prodInfo.setProdId(tvs.getId());
									prodInfo.setProdBrand(tvs.getBrand());
									prodInfo.setProdDiagonallength(tvs
											.getDiagonallength());
									prodInfo.setProdHd(tvs.getHD());
									prodInfo.setProdLength(tvs.getLength());
									prodInfo.setProdWidth(tvs.getWidth());
									prodInfo.setProdHeight(tvs.getHeight());
									prodInfo.setProdPrice(tvs.getPrice());
									prodInfo.setProdDescription(tvs
											.getDescription());
									prodInfo.setProdWarrantyPeriod(tvs
											.getWarrantyPeriod());

								}
							}

						}

					}
				} else {
					if (checkInventoryForProductAvailabilty(product_id,
							productType) != 0) {
						// carList.add(car);

						// product = mapperFunction(productType);

						if (productType.equalsIgnoreCase("tvs")) {

							if (tvs != null) {

								prodInfo.setProdId(tvs.getId());
								prodInfo.setProdBrand(tvs.getBrand());
								prodInfo.setProdDiagonallength(tvs
										.getDiagonallength());
								prodInfo.setProdHd(tvs.getHD());
								prodInfo.setProdLength(tvs.getLength());
								prodInfo.setProdWidth(tvs.getWidth());
								prodInfo.setProdHeight(tvs.getHeight());
								prodInfo.setProdPrice(tvs.getPrice());
								prodInfo.setProdDescription(tvs
										.getDescription());
								prodInfo.setProdWarrantyPeriod(tvs
										.getWarrantyPeriod());

							}
						}

					}
				}

			}

		}

		// check for nail polish availability
		if (productType.equalsIgnoreCase("nps")) {
			nps = mongoOps.findOne(
					new Query(Criteria.where("_id").is(product_id)), Nps.class,
					productType);

			if (nps != null) {

				Date startDate = nps.getStartDate();
				Date endDate = nps.getEndDate();
				Date current = new Date();

				if (endDate != null) {
					if (current.after(startDate) && current.before(endDate)) {

						// int productCount =
						// checkInventoryForProductAvailabilty(
						// product_id, product);
						if (checkInventoryForProductAvailabilty(product_id,
								productType) != 0) {
							// carList.add(car);

							// product = mapperFunction(productType);
							if (productType.equalsIgnoreCase("nps")) {

								if (nps != null) {

									prodInfo.setProdId(nps.getId());
									prodInfo.setProdBrand(nps.getBrand());
									prodInfo.setProdColor(nps.getColor());
									prodInfo.setProdDescription(nps
											.getDescription());
									prodInfo.setProdPrice(nps.getPrice());

								}
							}

						}

					}

				} else {

					// int productCount = checkInventoryForProductAvailabilty(
					// product_id, product);
					if (checkInventoryForProductAvailabilty(product_id,
							productType) != 0) {
						// carList.add(car);

						// product = mapperFunction(productType);
						if (productType.equalsIgnoreCase("nps")) {

							if (nps != null) {

								prodInfo.setProdId(nps.getId());
								prodInfo.setProdBrand(nps.getBrand());
								prodInfo.setProdColor(nps.getColor());
								prodInfo.setProdDescription(nps
										.getDescription());
								prodInfo.setProdPrice(nps.getPrice());

							}
						}

					}
				}

			}

		}

		return prodInfo;

	}

	//checking inventory for product Availability
	private int checkInventoryForProductAvailabilty(String product_id,
			String product) {
		String sql = "SELECT count FROM product_inventory WHERE productId = ? and product_category = ?";

		Connection conn = null;
		int count = 0;
		int orderId = 0;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product_id);
			ps.setString(2, product);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
			rs.close();
			ps.close();
			return count;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
	
// inserting customer order in db
	public int insertOrderDetails(Customer customer, String productId,
			String product, String name) throws Exception {

		int customerId = 0;
		int orderId = 0;
		PreparedStatement ps;
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			String sql = "SELECT user_role_id FROM user_roles WHERE username = ?"
					+ "";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);

			ResultSet rsUser = ps.executeQuery();
			while (rsUser.next()) {
				customerId = rsUser.getInt("user_role_id");

			}
			rsUser.close();

			sql = "INSERT INTO CUSTOMERINFO "
					+ "(customerId,First_Name, Last_Name, Address, City, State, Zip_Code) VALUES (?,?, ?, ?, ?, ? , ?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ps.setString(2, customer.getFname());
			ps.setString(3, customer.getLname());
			ps.setString(4, customer.getAddr1() + " " + customer.getAddr2());
			ps.setString(5, customer.getCity());
			ps.setString(6, customer.getState());
			ps.setString(7, customer.getZipcode());
			ps.executeUpdate();
			// conn.commit();

			

			sql = "INSERT INTO customer_order_info "
					+ "(customerId, productId, prodType, orderStatus, orderDate) VALUES (?, ?, ?,?,?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ps.setString(2, productId);
			ps.setString(3, product);
			ps.setString(4, "pending");
			ps.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
			ps.executeUpdate();

			sql = "SELECT * FROM customer_order_info WHERE customerId = ? and productId = ? and prodType=? order by order_id desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ps.setString(2, productId);
			ps.setString(3, product);

			ResultSet rsOrder = ps.executeQuery();
			if (rsOrder.next()) {
				orderId = rsOrder.getInt("order_id");

			}
			rsOrder.close();

			sql = "INSERT INTO customer_payment_info "
					+ "(customerId,cc_no, exp_Date, security_code,orderId ) VALUES (?, ?, ?, ?,?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ps.setLong(2, customer.getCcname());
			ps.setString(3, customer.getDay() + "-" + customer.getMonth() + "-"
					+ customer.getYear());
			ps.setInt(4, customer.getCvv());
			ps.setInt(5, orderId);
			ps.executeUpdate();

			// product Inventory

			sql = "SELECT count FROM product_inventory WHERE productId = ? and product_category = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, productId);
			ps.setString(2, product);

			int count = 0;
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				count = set.getInt("count");
				if (count != 0) {
					count -= 1;
				}
			}

			set.close();

			if (count != 0) {
				sql = "Update product_inventory set count = ? where productId = ? and product_category=?";

				ps = conn.prepareStatement(sql);
				ps.setInt(1, count);
				ps.setString(2, productId);
				ps.setString(3, product);
				ps.executeUpdate();
			}
			conn.commit();

			// conn.commit();

			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return orderId;
	}
	
	
	// fetching order history

	public List<Product> fectchAllOrder(String name) throws Exception {

		List<Product> orderList = new ArrayList<Product>();
		List<CustomerOrderProductInfo> list = new ArrayList<CustomerOrderProductInfo>();
		PreparedStatement ps;
		Connection conn = null;
		int customerId = 0;
		String sql;

		try {
			conn = dataSource.getConnection();
			sql = "SELECT user_role_id FROM user_roles WHERE username = ?" + "";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);

			ResultSet rsUser = ps.executeQuery();
			while (rsUser.next()) {
				customerId = rsUser.getInt("user_role_id");

			}
			rsUser.close();

			sql = "SELECT * from customer_order_info where customerId= ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				customerOrderProductInfo = new CustomerOrderProductInfo();
				customerOrderProductInfo.setOrderId(resultSet
						.getInt("order_id"));
				customerOrderProductInfo.setProdid(resultSet
						.getInt("productId"));
				customerOrderProductInfo.setProdType(resultSet
						.getString("prodType"));
				customerOrderProductInfo.setOrderDate(resultSet
						.getDate("orderDate"));
				customerOrderProductInfo.setOrderStatus(resultSet
						.getString("orderStatus"));
				list.add(customerOrderProductInfo);
			}

			CustomerOrderProductInfo info;
			if (!list.isEmpty() && list != null) {
				for (int i = 0; i < list.size(); i++) {
					info = list.get(i);
					MongoClient mongo = new MongoClient("localhost", 27017);
					MongoOperations mongoOps = new MongoTemplate(mongo, "test");

					if (info.getProdType().equalsIgnoreCase("cars")) {

						car = mongoOps.findOne(new Query(Criteria.where("_id")
								.is((Integer.toString(info.getProdid())))),
								Cars.class, info.getProdType());
						Product prod = new Product();
						if (car != null) {
							prod.setProdId(car.getId());
							prod.setProdModel(car.getModel());
							prod.setProdYearofmanufacture(car
									.getYearofmanufacture());
							prod.setProdCondition(car.getCondition());
							prod.setProdMileage(car.getMileage());
							prod.setProdDescription(car.getDescription());
							prod.setProdPrice(car.getPrice());
							prod.setProdCategory(info.getProdType());
							prod.setOrderId(info.getOrderId());
							Date utilOrderDate = new java.util.Date(info
									.getOrderDate().getTime());
							if (calculateDateDiff(new Date(), utilOrderDate) <= 3) {

								prod.setOrderStatus("Pending");
							} else {

								prod.setOrderStatus("processed");
							}

							orderList.add(prod);
						}

					}
					if (info.getProdType().equalsIgnoreCase("tvs")) {
						tvs = mongoOps.findOne(new Query(Criteria.where("_id")
								.is((Integer.toString(info.getProdid())))),
								Tvs.class, info.getProdType());
						Product prod = new Product();
						if (tvs != null) {

							prod.setProdId(tvs.getId());
							prod.setProdBrand(tvs.getBrand());
							prod.setProdDiagonallength(tvs.getDiagonallength());
							prod.setProdHd(tvs.getHD());
							prod.setProdLength(tvs.getLength());
							prod.setProdWidth(tvs.getWidth());
							prod.setProdHeight(tvs.getHeight());
							prod.setProdPrice(tvs.getPrice());
							prod.setProdDescription(tvs.getDescription());
							prod.setProdWarrantyPeriod(tvs.getWarrantyPeriod());
							prod.setProdCategory(info.getProdType());
							prod.setOrderId(info.getOrderId());
							Date utilOrderDate = new java.util.Date(info
									.getOrderDate().getTime());
							if (calculateDateDiff(new Date(), utilOrderDate) <= 3) {

								prod.setOrderStatus("Pending");
							} else {

								prod.setOrderStatus("processed");
							}
							orderList.add(prod);
						}
					}
					if (info.getProdType().equalsIgnoreCase("nps")) {
						nps = mongoOps.findOne(new Query(Criteria.where("_id")
								.is((Integer.toString(info.getProdid())))),
								Nps.class, info.getProdType());

						Product prod = new Product();
						if (nps != null) {

							prod.setProdId(nps.getId());
							prod.setProdBrand(nps.getBrand());
							prod.setProdColor(nps.getColor());
							prod.setProdDescription(nps.getDescription());
							prod.setProdPrice(nps.getPrice());
							prod.setProdCategory(info.getProdType());
							prod.setOrderId(info.getOrderId());

							Date utilOrderDate = new java.util.Date(info
									.getOrderDate().getTime());
							if (calculateDateDiff(new Date(), utilOrderDate) <= 3) {

								prod.setOrderStatus("Pending");
							} else {

								prod.setOrderStatus("processed");
							}
							orderList.add(prod);

						}

					}

				}

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return orderList;

	}

	
	// deleting selected order
	public boolean deleteOrder(int orderId) {

		PreparedStatement ps;
		Connection conn = null;
		String sql;
		int prod_id = 0;
		String prod_type = null;
		String orderStatus = null;
		java.sql.Date sqlOrderDate = null;
		java.util.Date utilOrderDate = null;
		int count = 0;
		boolean status = false;
		// String sql;

		try {
			conn = dataSource.getConnection();

			sql = "SELECT * FROM customer_order_info WHERE order_id = ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);

			ResultSet rsUser = ps.executeQuery();
			if (rsUser.next()) {
				prod_id = rsUser.getInt("productId");
				prod_type = rsUser.getString("prodType");
				orderStatus = rsUser.getString("orderStatus");
				sqlOrderDate = rsUser.getDate("orderDate");

				utilOrderDate = new java.util.Date(sqlOrderDate.getTime());
				// count = rsUser.getInt("count");

			}
			rsUser.close();

			// Date currentDate = new Date();

			if (calculateDateDiff(new Date(), utilOrderDate) <= 3) {

				sql = "DELETE from customer_payment_info WHERE orderId = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, orderId);
				ps.executeUpdate();

				sql = "DELETE from customer_order_info WHERE order_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, orderId);
				ps.executeUpdate();

				sql = "SELECT count FROM product_inventory WHERE productId = ? and product_category = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, prod_id);
				ps.setString(2, prod_type);

				ResultSet set = ps.executeQuery();
				if (set.next()) {
					count = set.getInt("count");

					count += 1;

				}

				set.close();

				sql = "Update product_inventory set count = ? where productId = ? and product_category=?";

				ps = conn.prepareStatement(sql);
				ps.setInt(1, count);
				ps.setInt(2, prod_id);
				ps.setString(3, prod_type);
				ps.executeUpdate();
				status = true;
				ps.close();
				conn.commit();

			}

		} catch (Exception e) {
		} finally {
		}

		return status;

	}

	private int calculateDateDiff(Date date, Date orderDate) throws Exception {
		long diff = date.getTime() - orderDate.getTime();

		int diffDays = (int) (diff / (24 * 60 * 60 * 1000)) + 1;
		return diffDays;
	}
}