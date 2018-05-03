package poc.persistence.dao;

import java.util.List;

import poc.persistence.domain.Contact;

public interface ContactDAO {

	List<Contact> selectAll();
	Contact selectById(Long id);
	Contact insert(Contact contact);
	Contact update(Contact contact);
	void deleteById(Long id);
}
