import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/10/18  下午6:40
 * @version: 1.0
 */
public class SingleInstanceTest {

	@Test
	public void getInstance() {

		SingleInstance instance = SingleInstance.getInstance();

		System.out.println(instance);
	}
}