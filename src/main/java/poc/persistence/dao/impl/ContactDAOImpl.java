package poc.persistence.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import poc.persistence.dao.ContactDAO;
import poc.persistence.domain.Contact;

@Service
public class ContactDAOImpl implements ContactDAO{
	
	private static Map<Long,Contact> contactMap = new HashMap<Long,Contact>();
	static{
		contactMap.put(1l, new Contact(1l,"Nikolaus Otto","416-456-789"));
		contactMap.put(2l, new Contact(2l,"Robert Ford","416-123-456"));
		contactMap.put(3l, new Contact(3l,"Gottlieb Daimler","416-456-123"));
		contactMap.put(4l, new Contact(4l,"Lt. General Masaharu Homma","416-100-789"));
	}
	String[] names = {"Nikolaus Otto", "Robert Ford", "Gottlieb Daimler", "Lt. General Masaharu Homma"};

	@Override
	public List<Contact> selectAll() {
		return new ArrayList<Contact>(contactMap.values());
	}

	@Override
	public Contact selectById(Long id) {
		return contactMap.get(id);
	}

	@Override
	public Contact insert(Contact contact) {
		contactMap.put(contact.getId(), contact);
		return contact;
	}

	@Override
	public Contact update(Contact contact) {
		contactMap.put(contact.getId(), contact);
		return contact;
	}

	@Override
	public void deleteById(Long id) {
		if (contactMap.containsKey(id)){
			contactMap.remove(id);
		}
		
	}

	
}
