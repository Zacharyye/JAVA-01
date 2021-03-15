package com.week07.zachary;

import com.week07.zachary.model.Order;
import com.week07.zachary.model.User;
import com.week07.zachary.repository.OrderRepository;
import com.week07.zachary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;
import java.util.Date;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootApplication
public class ZacharyApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(ZacharyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			StopWatch time = new StopWatch("100w orders one by one");
			time.start();
			User user = User.builder()
//							.id((long) Math.random() * 1000000000000L)
							.name("测试")
							.createTime(new Date())
							.build();
			IntStream.range(0, 1)
							.forEach(i -> {
								userRepository.save(user);
							});
			IntStream.range(0,1000000)
							.forEach(i -> {
								orderRepository.save(Order.builder()
												.id((long) Math.random() * 1000000000000L)
												.userId(Long.valueOf(i))
												.productId(Long.valueOf(i))
												.worksite("测试")
												.status("1")
												.orderNo("ZO" + i)
												.createTime(new Date())
												.build());
							});
			time.stop();
			System.out.println(time.prettyPrint());
		}).start();
	}
}
