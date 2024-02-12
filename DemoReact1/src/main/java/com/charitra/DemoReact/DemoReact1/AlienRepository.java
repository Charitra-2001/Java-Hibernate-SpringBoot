package com.charitra.DemoReact.DemoReact1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class AlienRepository {
	List<Aliens>aliens;
	
	Connection con = null;
	public AlienRepository(){
		String url = "jdbc:mysql://localhost:3306/test"; 
		String username = "root";
		String password = "Charitra2536";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public List<Aliens> getAliens() throws Exception
	{
		String query  = "SELECT * FROM alien";
		List<Aliens> aliens = new ArrayList<>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			Aliens a = new Aliens();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
			aliens.add(a);
		}
		return aliens;
	}
	
	public Aliens getAlien(int id) throws SQLException
	{
		Aliens a = new Aliens();
		String q = "Select * from alien where id=?";
		PreparedStatement pst = con.prepareStatement(q);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
			return a;
		}
		return null;
	}

	public void create(Aliens a1) throws Exception {
		String query = "INSERT INTO alien VALUES (?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,a1.getId());
		pst.setString(2, a1.getName());
		pst.setInt(3, a1.getPoints());
		pst.execute();
	}
	
	public void update(Aliens a1) throws SQLException
	{
		String query = "UPDATE alien SET name=?,points =? WHERE id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, a1.getName());
		pst.setInt(2, a1.getPoints());
		pst.setInt(3,a1.getId());
		pst.executeUpdate();
	}

	public void delete(int id) throws Exception {
		String query = "DELETE FROM alien where id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.execute();
		
	}
}