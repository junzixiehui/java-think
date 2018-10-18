/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/10/18  下午6:38
 * @version: 1.0
 */
public class SingleInstance {

	private static SingleInstance instance = new SingleInstance();

	private SingleInstance(){

	}

	public static SingleInstance getInstance(){
		return instance;
	}



}
