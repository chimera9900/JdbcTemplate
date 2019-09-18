package com.developer.jdbc.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.developer.jdbc.model.CustomerOrderList;
import com.developer.jdbc.model.CustomerOrderReport;
import com.developer.jdbc.model.Order;
import com.developer.jdbc.utils.StringUtils;

@Component
public class QueryCustomersAndOrerCount implements ApplicationRunner {
	
	 private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public QueryCustomersAndOrerCount(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		StringUtils.line();
//		String sql = "select c.*, (select count(o.id) from orders o where o.customer_fk=c.id) as count from customers c";
//		List<CustomerOrderReport> result = jdbcTemplate.query(sql, new CustomerOrderReportRowMapper());
//		result.forEach(x -> System.out.println(x.toString()));
		
		String sql = "select c.*, o.id as oid, o.sku from customers c left join orders o on c.id = o.customer_fk where o.id is not null order by id";
		
		ResultSetExtractor<Collection<CustomerOrderList>> rse = rs -> {
			Map<Long, CustomerOrderList> map = new HashMap<>();
			CustomerOrderList customer = null;
			
			while(rs.next()) {
				long id = rs.getLong("id");
					if(customer == null || id != customer.getCustomerId()) {
						customer = new CustomerOrderList(rs.getLong("id"), rs.getString("name"), 
								rs.getString("email"), new HashSet<>());
					}
					customer.getOrders().add(new Order(rs.getLong("oid"), rs.getString("sku")));
					map.put(customer.getCustomerId(), customer);
				}
			return map.values();
		};			
	
		Collection<CustomerOrderList> query = jdbcTemplate.query(sql, rse);
		query.forEach(x -> log.info(x.toString()));
	
	};
		}
	

class CustomerOrderReportRowMapper implements RowMapper<CustomerOrderReport>{
	@Override
	public CustomerOrderReport mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerOrderReport report = new CustomerOrderReport();
		report.setCustomerId(rs.getLong("id"));
		report.setName(rs.getString("name"));
		report.setEmail(rs.getString("email"));
		report.setOrderCount(rs.getInt("count"));
		return report;
	}
}






