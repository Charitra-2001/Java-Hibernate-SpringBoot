package com.charitra.repo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.charitra.model.Alien;
@Repository // We need to mark it as repository if we are using it as repository for all functions
public class AlienRepo {
	
	public JdbcTemplate template;
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	
	public AlienRepo() {
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName("com.mysql.jdbc.Driver");
		data.setUrl("jdbc:mysql://localhost:3306/test");
		data.setUsername("root");
		data.setPassword("Charitra2536");
		JdbcTemplate template1 = new JdbcTemplate(data);
		setTemplate(template1);
	}
	
	
	// JDBCTemplate is used to perform the operations of jdbc in sql
	
	public void save(Alien a) {
		String str = "Insert into alien (id,name,tech) values (?,?,?)";
		int ans = template.update(str,a.getId(),a.getName(),a.getTech());
		System.err.println(ans);
	}
	
	public List<Alien> findAll(){
		
		String queryString = "Select * from alien";
		
		org.springframework.jdbc.core.RowMapper<Alien> mapper = (rs,rowNum) -> {
				Alien alien = new Alien();
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setTech(rs.getString(3));
				return alien;
		};
		List<Alien>ans  = template.query(queryString, mapper);
		return ans;
	}
	
}	
