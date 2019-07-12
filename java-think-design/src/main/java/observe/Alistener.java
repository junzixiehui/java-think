package observe;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/7/12  11:25
 * @version: 1.0
 */
public class Alistener implements ListenerI{

	public void handle(Object obj) {
		System.out.println("Alistener listen");
	}
}
