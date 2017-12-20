import java.util.ArrayList;

import javax.swing.JFrame;

public class Controller {
	CustomerRegister customerRegister;
	ProductRegister productRegister;
	Product product;
	Customer customer;
	Order order;

	JFrame interFace;

	public Controller(CustomerRegister customerRegister, ProductRegister productRegister, JFrame interFace) {
		this.customerRegister = customerRegister;
		this.productRegister = productRegister;
		this.interFace = interFace;

	}

	public ArrayList<Order> getArrayListOrders() {
		ArrayList<Order> orders = customer.getOrderList();
		return orders;
	}

	public void addOrder(String orderID, String deliveryDate) {
		Order order = new Order();
		order.setOrderID(orderID);
		order.setDeliveryDate(deliveryDate);
		customer.addOrder(order);
		order.setCustomerOrder(customer); // Detta kanske behöver findCustomer i registret

	}

	public Order findOrder(String orderID) {
		Order order = customer.findOrder(orderID);
		if (order != null) {
			return order;
		}
		return null;
	}

	public void removeOrder(String orderID) {
		customer.removeOrder(orderID);
	}

	public ArrayList<OrderLine> getArrayListOrderLines() {
		ArrayList<OrderLine> orderLines = order.getLines();
		return orderLines;
	}

	public void addOrderLines(String orderID, Product product, int quantity, String orderLineNumber) {
		OrderLine orderLine = new OrderLine();
		order = this.findOrder(orderID);
		orderLine.setNumber(orderLineNumber);
		orderLine.setQuantity(quantity);
		orderLine.setProduct(product);
		orderLine.setOrder(order);
	}
	public void removeOrderLine (String orderLineNumber) {
		order.removeOrderLine(orderLineNumber);
	}

	public ArrayList<Customer> getArrayListCustomers() {
		ArrayList<Customer> customers = customerRegister.getRegister();
		return customers;
	}

	public void addCustomer(String name, String address, String customerNumber) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setCustomerNumber(customerNumber);
		customerRegister.addCustomer(customer);

	}

	public Customer findCustomer(String customerNumber) {
		Customer customer = customerRegister.findCustomer(customerNumber);
		if (customer != null) {
			return customer;
		}
		return null;
	}

	public void removeCustomer(String customerNumber) {
		customerRegister.removeCustomer(customerNumber);
	}

	public void changeCustomer(String name, String address, String customerNumber) {
		Customer customer = this.findCustomer(customerNumber);
		customer.setAddress(address);
		customer.setName(name);
	}

	public ArrayList<Product> getArrayListProducts() {
		ArrayList<Product> products = productRegister.getProductRegister();
		return products;
	}

	public void addProduct(String name, String category, double price) {
		Product product = new Product();
		product.setCategory(category);
		product.setName(name);
		product.setPrice(price);
		productRegister.addProduct(product);
	}

	public Product findProduct(String name) {
		Product product = productRegister.findProduct(name);
		if (product != null) {
			return product;
		}
		return null;
	}

	public void removeProduct(String name) {
		productRegister.removeProduct(name);

	}

	public void changeProduct(String name, String category, double price) {
		Product product = this.findProduct(name);
		product.setCategory(category);
		product.setPrice(price);

	}

	public ArrayList<Unit> getArrayListUnits() {
		ArrayList<Unit> units = product.getUnitList();
		return units;
	}

	public void addUnit(String serialNumber, String name) {
		Unit unit = new Unit();
		unit.setSerialNumber(serialNumber);
		Product product = this.findProduct(name);
		product.addUnit(unit);

	}

	public Unit findUnit(String serialNumber, String name) {
		Product p = this.findProduct(name);
		if (p != null) {
			return p.findUnit(serialNumber);
		}
		return null;

	}

	public void removeUnit(String serialNumber, String name) {
		Product product = this.findProduct(name);
		product.removeUnit(serialNumber);
	}

}