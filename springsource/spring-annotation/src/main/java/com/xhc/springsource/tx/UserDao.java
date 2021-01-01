package com.xhc.springsource.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;
import java.util.UUID;

@Repository
public class UserDao {
	
	@Autowired(required = false)
	private JdbcTemplate jdbcTemplate;

	public void insert(){
		String sql = "INSERT INTO `t_account`(money,username) VALUES(?,?)";

		Random random = new Random(1000);//指定种子数字
		int i2 = random.nextInt(100);

		String username = UUID.randomUUID().toString().substring(0, 5);
		jdbcTemplate.update(sql, i2,username);
	}
}
