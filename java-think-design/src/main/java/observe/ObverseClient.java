package observe;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/7/12  11:26
 * @version: 1.0
 */
public class ObverseClient {



	public static void main(String[] args) {

		//注册监听者
		ListenerI alistener = new Alistener();

		Producer producer = new Producer();
		producer.register(alistener);

		producer.action(new Object());
	}

}
