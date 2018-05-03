package poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poc.domain.dao.UserMapper;
import poc.domain.model.User;

@Service
@Transactional
public class UserService {

	@Autowired private UserMapper userMapper;
	
	public User getUser(int userId)
	{
		return userMapper.getUser(userId);
	}
}
