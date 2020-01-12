package observe;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/7/12  11:27
 * @version: 1.0
 */
public class Producer {

	List<ListenerI> listenList = new ArrayList<ListenerI>();

	public void register(ListenerI listenerI){
		listenList.add(listenerI);
	}

	public void action(Object obj){
		listenList.forEach(listener -> {
			listener.handle(obj);
		});
	}
}
