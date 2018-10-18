/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/10/18  下午6:38
 * @version: 1.0
 */
public class SingleInstanceV2 {

	private static volatile SingleInstanceV2 instance ;

	private SingleInstanceV2(){

	}

	public static SingleInstanceV2 getInstance(){

		if (instance == null){
			synchronized (SingleInstanceV2.class){
				if (instance == null){
					instance = new SingleInstanceV2();
				}
			}
		}

		return instance;
	}



}
