package ccloader.application.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@SuppressWarnings("unchecked")
	public <T, V> T map(V o, Class<T> clazz) {
		T result = null;
		
		try {
			if(o instanceof IConvertibleItem<?>) {
				result = ((IConvertibleItem<T>) o).convertTo();
			}else {
				result = clazz.newInstance();
				if(o!=null) {
					((IConvertibleItem<V>) result).convertFrom(o);
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error(e.getMessage());
		}
		
		return result;
	}
	
	public <T, V> List<T>mapAsList(List<V> listToConvert, Class<T> clazz) {
		List<T> result = new ArrayList<>();
		if(listToConvert!=null) {
			listToConvert.forEach(elem -> result.add(this.map(elem, clazz)));
		}
		return result;
	}
	
}
