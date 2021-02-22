package com.zachary.zzzz;

import com.zachary.zzzz.model.User;
import com.zachary.zzzz.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import javax.annotation.Resource;
import java.sql.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class ZzzzApplication implements CommandLineRunner {
	@Resource
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ZzzzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取数据库连接
		Connection connection = DriverManager.getConnection(
						"jdbc:mysql://www.zacharye.top:3306/zachary",
						"root",
						"Zacharye"
		);
		//1.
//		Statement statement = connection.createStatement();
//		int iNum = statement.executeUpdate("insert into user(username, password, mobile, email, sex, nickname) values ('Z20210222', '123', '17326722301', '123@123.com','male','zzzz') ");
//		System.out.println("插入数据数：" + iNum);
//		//查询
//		ResultSet qryResult = statement.executeQuery("select * from user where username='Z20210222'");
//
//		while(qryResult.next()) {
//			System.out.println("查询结果：" + qryResult);
//			System.out.println("查询结果：" + qryResult.getString("username"));
//		}
//		//更新
//		statement.executeUpdate("update user set email = '124@123.com' where username = 'Z20210222'");
//		//查询
//		qryResult = statement.executeQuery("select * from user where username='Z20210222'");
//		while(qryResult.next()) {
//			System.out.println("查询结果：" + qryResult);
//			System.out.println("查询结果：" + qryResult.getString("username"));
//		}
//		//删除
//		int delNum = statement.executeUpdate("delete from user where username = 'Z20210222'");
//		System.out.println("删除结果：" + delNum);

		//2.prepare
//		connection.setAutoCommit(false);
//		PreparedStatement prepareStatement = connection.prepareStatement("insert into user(username, password, mobile, email, sex, nickname) values (?, ?, ?, ?,?,?) ");
//		for(int i = 0; i < 10; i++) {
//			prepareStatement.setString(1, "Z202102201" + i);
//			prepareStatement.setString(2, "123");
//			prepareStatement.setString(3, "17326722301");
//			prepareStatement.setString(4, "125@123.com");
//			prepareStatement.setString(5, "male");
//			prepareStatement.setString(6, "zzz");
//			prepareStatement.addBatch();
//		}
//		int[] nums = prepareStatement.executeBatch();
//		System.out.println("批量插入：" + nums.length);
//		Arrays.stream(nums).forEach(num -> System.out.println(num));
//		//查询
//		prepareStatement = connection.prepareStatement("select * from user where username = ?");
//		prepareStatement.setString(1, "Z202102201");
//		ResultSet qryResult = prepareStatement.executeQuery();
//		while(qryResult.next()) {
//			System.out.println("查询结果：" + qryResult);
//			System.out.println("查询结果：" + qryResult.getString("username"));
//		}
//		//修改
//		prepareStatement = connection.prepareStatement("update user set email = ? where username = ?");
//		prepareStatement.setString(1, "126@123.com");
//		prepareStatement.setString(2, "Z202102201");
//		int updateNum = prepareStatement.executeUpdate();
//		System.out.println("更新数据数：" + updateNum);
//		//查询
//		prepareStatement = connection.prepareStatement("select * from user where username = ?");
//		prepareStatement.setString(1, "Z202102201");
//		qryResult = prepareStatement.executeQuery();
//		while(qryResult.next()) {
//			System.out.println("查询结果：" + qryResult);
//			System.out.println("查询结果：" + qryResult.getString("username"));
//		}
//		//删除
//		prepareStatement = connection.prepareStatement("delete from user where username = ?");
//		prepareStatement.setString(1, "Z202102201");
//		int delNum = prepareStatement.executeUpdate();
//		System.out.println("删除数据数：" + delNum);
//		connection.commit();
		//3.
		User user = User.builder()
						.name("Z2021022200")
						.code("123")
						.bgName("bg123")
						.createTime(new Date()).build();
		//新增
		userRepository.save(user);
		//查询
		User qryUser = User.builder().name("Z2021022200").build();
		Example<User> userExample =  Example.of(qryUser);
		Optional<User> opUser = userRepository.findOne(userExample);
		System.out.println(opUser);
		//修改
		user = opUser.get();
		user.setCode("124");
		userRepository.save(user);
		opUser = userRepository.findOne(userExample);
		System.out.println(opUser);
		//删除
		userRepository.delete(user);
		opUser = userRepository.findOne(userExample);
		System.out.println(opUser);
		//系统退出
		System.exit(1);
	}
}
