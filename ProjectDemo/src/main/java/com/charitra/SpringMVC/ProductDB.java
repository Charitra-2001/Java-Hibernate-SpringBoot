package com.charitra.SpringMVC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDB {
	
	// This is for spring JDBC
	//private JdbcTemplate template;
	
	// This is for normal JDBC
//	Connection con;
	
	// This is for Spring JPA 
	@Autowired
	ProductDB_JPA pdj;
	
	
	public ProductDB() {
		
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Charitra2536");
//			JdbcTemplate template1 = new JdbcTemplate(data);
//			setTemplate(template1);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		/* Now writing same in spring boot */
		
//		DriverManagerDataSource data = new DriverManagerDataSource();
//		data.setDriverClassName("com.mysql.jdbc.Driver");
//		data.setUrl("jdbc:mysql://localhost:3306/test");
//		data.setUsername("root");
//		data.setPassword("Charitra2536");
//		JdbcTemplate template1 = new JdbcTemplate(data);
//		setTemplate(template1);
		
		
		/* Nothing is required when using spring boot JPA*/
		
		
	}
//	public JdbcTemplate getTemplate() {
//		return template;
//	}
//
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//	}

	public void save(Product p) {
		
//		PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUCTS (name,type,place,warrenty) VALUES(?,?,?,?)");
//		ps.setString(1, p.getName());
//		ps.setString(2, p.getType());
//		ps.setString(3, p.getPlace());
//		ps.setInt(4, p.getWarrenty());
//		ps.execute();
		
		/* Now we are doing same in spring boot */
		
//		String query = "INSERT INTO PRODUCTS (name,type,place,warrenty) VALUES(?,?,?,?)";
//		template.update(query,p.getName(),p.getType(),p.getPlace(),p.getWarrenty());
//		
		/* Now doing same with spring JPA repository */
		
		pdj.save(p);
	}

	public List<Product> getAllProducts() {
		
		
//		String query = "Select * from products";
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(query);
//		List<Product> ans = new ArrayList<Product>();
//		
//		while(rs.next())
//		{
//			ans.add(new Product(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
//		}
//		return ans;
		
		
		
		/* Now we are doing same in spring boot */
		
//		String query = "Select * from products";
//		RowMapper<Product> mapper = (r,s)->{
//			
//			Product p = new Product();
//			p.setName(r.getString(2));
//			p.setType(r.getString(3));
//			p.setPlace(r.getString(4));
//			p.setWarrenty(r.getInt(5));
//			return p;
//		};
//		
//		List<Product> ans = template.query(query, mapper);
//		return ans;
		
		
		
		
		/* Now doing same with spring JPA repository */
		
		return pdj.findAll();
	}
//
	public Product getProductByName(String name){
//		String query = "Select * from products where name=?";
//		PreparedStatement st = con.prepareStatement(query);
//		st.setString(1,name);
//		ResultSet rs = st.executeQuery();
//		Product ans = null;
//		
//		if(rs.next())
//		{
//			ans = (new Product(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
//		}
//		return ans;
		
		/* Now we are doing same in spring boot JPA */
		
		
		return pdj.getByName(name);
		
		
		
	}
//
//	public List<Product> getAllProductsFromPlace(String place){
	
			/* It is similar to upper one */
////		String query = "Select * from products where place=?";
////		PreparedStatement st = con.prepareStatement(query);
////		st.setString(1,place);
////		ResultSet rs = st.executeQuery();
////		List<Product> ans = new ArrayList<>();
////		
////		while(rs.next())
////		{
////			ans.add(new Product(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
////		}
////		return ans;
//		
//		/* Now we are doing same in spring boot */
//		
//		
//		
//		
//	}
//
//	public List<Product> getAllProductsByExpiredWarrenty(int year){
////		String query = "Select * from products where warrenty<?";
////		PreparedStatement st = con.prepareStatement(query);
////		st.setInt(1,year);
////		ResultSet rs = st.executeQuery();
////		List<Product> ans = new ArrayList<>();
////		
////		while(rs.next())
////		{
////			ans.add(new Product(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
////		}
////		return ans;
//		
//		/* Now we are doing same in spring boot */
//		
//		
//		
//	}

}
