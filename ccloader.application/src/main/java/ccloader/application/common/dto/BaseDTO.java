package ccloader.application.common.dto;

import java.io.Serializable;

/**
 * Base FrontEnd abstract class
 * @author Raffaele
 *
 */
public abstract class BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7072008331817322911L;
	
	/**
	 * 
	 * @return
	 * <i>true</i> if contained data is retained valid.
	 */
	public abstract boolean isValid();

}
