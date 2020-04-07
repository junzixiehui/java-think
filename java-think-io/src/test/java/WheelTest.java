import io.netty.util.HashedWheelTimer;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/2/23  1:01 PM
 * @version: 1.0
 */
public class WheelTest {

	@Test
	public void test1() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(1, TimeUnit.SECONDS,8);

		System.out.println("start:" + LocalDateTime.now().format(formatter));

		hashedWheelTimer.newTimeout(timeout -> {
			System.out.println("task :" + LocalDateTime.now().format(formatter));
		}, 10, TimeUnit.SECONDS);
		Thread.sleep(20000);
	}

	@Test
	public void test2() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS);
		System.out.println("start:" + LocalDateTime.now().format(formatter));


		hashedWheelTimer.newTimeout(timeout -> {
			Thread.sleep(3000);
			System.out.println("task1:" + LocalDateTime.now().format(formatter));
		}, 3, TimeUnit.SECONDS);


		hashedWheelTimer.newTimeout(timeout ->
				System.out.println("task2:" + LocalDateTime.now().format(
				formatter)), 4, TimeUnit.SECONDS);
		Thread.sleep(10000);
	}

}
