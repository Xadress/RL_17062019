package ccloader.application.common.service;

import org.springframework.beans.factory.annotation.Autowired;

import ccloader.application.common.ModelMapper;
import ccloader.application.user.model.User;

public class BaseService {
	
	@Autowired
	private User currentUser;
	
	@Autowired
	protected ModelMapper mapper;
	
	public User getCurrentUser() {
		return this.currentUser;
	}

}
