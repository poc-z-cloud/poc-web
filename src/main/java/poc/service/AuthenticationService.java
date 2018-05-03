package poc.service;

import java.util.List;

import poc.domain.aggregate.AdminUserAggregate;
import poc.domain.model.AdminRole;
import poc.domain.model.AdminSystem;
import poc.domain.model.AdminUser;

public interface AuthenticationService {
	AdminUserAggregate signIn(String username, String password) throws POCException;
	
	void changePassword(String username, String oldPassword, String newPassword) throws POCException;
	
}
