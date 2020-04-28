package com.doubt.data;

import com.doubt.domain.Doubt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ItemDao {

	public ItemDao() {
		DatabaseInitialize initialize = new DatabaseInitialize();
		initialize.initializeDatabase();
	}

//        public List<Doubt> getAllDoubts() {
//		List<Doubt> doubts = new ArrayList<Doubt>();
//		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb1","root","Adesh12345@");
//			 Statement stm = conn.createStatement();
//			 ) {	
//			
//			ResultSet results = stm.executeQuery("SELECT * FROM doubts");
//			
//	
//		while (results.next()) {
//				Doubt doubts1 = new Doubt();
//				doubts1.setId(results.getLong("id"));
//				order.setStatus(results.getString("status"));
//				Map<Doubt,Integer> orderMap = convertContentsToOrderMap(results.getString("contents"));
//				order.setContents(orderMap);
//				order.setCustomer(results.getString("customer"));
//				orders.add(order);
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException(e); 
//		}
//		return orders;
//	}

        
	private List<Doubt> buildItems(ResultSet results) throws SQLException {
		List<Doubt> items = new ArrayList<>();
		while (results.next()) {
			Doubt doubts = new Doubt();
			doubts.setId(results.getInt("id"));
                        doubts.setQuestion(results.getString("question"));
			doubts.setAnswer(results.getString("answer"));
                        doubts.setTeacher(results.getString("teacher"));
                        doubts.setStatus(results.getString("status"));
                        doubts.setname(results.getString("student"));
			doubts.setrollno(results.getString("rollno"));
			items.add(doubts);
		}
		return items;
	}

	public List<Doubt>  getFullItems() {
		List<Doubt> doubts = null;
		try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb1","root","Adesh12345@");
				Statement stm = conn.createStatement();
				ResultSet results = stm.executeQuery("SELECT * FROM doubts");
				) {	
			doubts = buildItems(results);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return doubts;
	}

//	public List<Items> find(String searchString) {
//		List<Items> items = null;
//		try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","Adesh12345@");
//				PreparedStatement stm = conn.prepareStatement("SELECT * FROM items WHERE name LIKE ? OR description LIKE ? OR category LIKE ? ");
//				) {	
//
//			stm.setString(1, "%" + searchString + "%");
//			stm.setString(2, "%" + searchString + "%");
//                        stm.setString(3, "%" + searchString + "%");
//
//			ResultSet results = stm.executeQuery();
//			items = buildItems(results);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return items;
//	}
//
//	public Items getItem(int id) {
//		List<Items> items = null;
//		try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","Adesh12345@");
//				PreparedStatement stm = conn.prepareStatement("SELECT * FROM items WHERE id = ?");
//				) {	
//
//			stm.setInt(1, id);
//
//			ResultSet results = stm.executeQuery();
//			items = buildItems(results);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return items.get(0);
//	}
//
//
//	public Order newOrder(String customer) {
//		Order order = new Order(); 
//		order.setStatus("pending");
//		order.setCustomer(customer);
//		try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","Adesh12345@");
//				PreparedStatement stm = conn.prepareStatement("INSERT INTO orders (status, customer) values (?,?)", Statement.RETURN_GENERATED_KEYS);
//				) {	
//			stm.setString(1, order.getStatus());
//			stm.setString(2,  order.getCustomer());
//			stm.execute();
//			
//			try(ResultSet generatedKeys = stm.getGeneratedKeys()) {
//				generatedKeys.next();
//		        order.setId(generatedKeys.getLong(1));		        
//		    }
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return order;
//	}
//
//	private Map<Items,Integer> convertContentsToOrderMap(String contents) {
//		Map<Items,Integer> orderMap = new HashMap<>();
//		if (contents == null || contents.equals("")) {
//			return orderMap;
//		}
//			String[] items = contents.split(":");
//			for (int i = 0; i < items.length; i++) {
//				String key = items[i].split(",")[0];
//				String value = items[i].split(",")[1];
//				Items item = getItem(Integer.valueOf(key));
//				orderMap.put(item, Integer.valueOf(value));
//			}
//		return orderMap;
//	}
//
//	private String convertOrderMapToContents(Map<Items,Integer> orderMap) {
//		String contents = "";
//		if (orderMap.keySet().isEmpty()) {
//			return contents;
//		}
//		for (Items item : orderMap.keySet() ) {
//			contents = contents + item.getId() + "," + orderMap.get(item) + ":";
//		}
//		contents = contents.substring(0, contents.length()-1);
//		return contents;
//	}

//	public void addToOrder(Long id, Items item, int quantity) {
//		try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","Adesh12345@");
//				Statement stm = conn.createStatement();
//				ResultSet res = stm.executeQuery("SELECT * FROM orders WHERE ID = " + id);
//				PreparedStatement stmUpdate = conn.prepareStatement("UPDATE orders SET contents = ? WHERE id = ?");
//				) {	
//			res.next();
//			String contents = res.getString("contents");
//			Map<Items, Integer> orderMap = convertContentsToOrderMap(contents);
//			if (orderMap.get(item) != null) {
//				orderMap.put(item, orderMap.get(item) + quantity);
//			}
//			else {
//				orderMap.put(item, quantity);
//			}
//			contents = convertOrderMapToContents(orderMap);
//			stmUpdate.setString(1, contents);
//			stmUpdate.setLong(2, id);
//			stmUpdate.execute();
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//
//	}

//	public Double getOrderTotal(Long id) {
//		double d = 0d;
//		try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","Adesh12345@");
//				Statement stm = conn.createStatement();
//				ResultSet res = stm.executeQuery("SELECT * FROM orders WHERE id = " + id);
//				) {
//			res.next();
//			Map<Items,Integer> orderMap = convertContentsToOrderMap(res.getString("contents"));
//			for (Items item : orderMap.keySet()) {
//				d += item.getPrice() * orderMap.get(item);
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//
//		return d;
//	}
        
//        public Order getOrder(Long id) {
//		try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","Adesh12345@");
//				Statement stm = conn.createStatement();
//				ResultSet res = stm.executeQuery("SELECT * FROM orders WHERE id = " + id);
//				) {
//			res.next();
//			Map<Items,Integer> orderMap = convertContentsToOrderMap(res.getString("contents"));
//			Order order = new Order();
//			order.setCustomer(res.getString("customer"));
//			order.setId(res.getLong("id"));
//			order.setStatus(res.getString("status"));
//			order.setContents(orderMap);
//			return order;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		
//	}
        
//        public void updateOrderStatus(Long id, String status) {
//		try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","Adesh12345@");
//				Statement stm = conn.createStatement();
//				PreparedStatement stmUpdate = conn.prepareStatement("UPDATE orders SET status = ? WHERE id = ?");
//				) {	
//			stmUpdate.setString(1, status);
//			stmUpdate.setLong(2, id);
//			stmUpdate.execute();
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
}
