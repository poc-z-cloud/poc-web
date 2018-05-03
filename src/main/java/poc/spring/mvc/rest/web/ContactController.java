package poc.spring.mvc.rest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import poc.persistence.dao.ContactDAO;
import poc.persistence.domain.Contact;

@Controller
@RequestMapping("rest")
public class ContactController {
	
	@Autowired private ContactDAO contactDAO;
	
	@RequestMapping("contact/list")
	@ResponseBody
	public List<Contact> getContactList() {
		return contactDAO.selectAll();
	}
	
	@RequestMapping("contact/{id}")
	@ResponseBody
	public Contact getById(@PathVariable Long id) {
		return contactDAO.selectById(id);
	}
	
	/* same as above method, but is mapped to
	 * /api/person?id= rather than /api/person/{id}
	 */
	@RequestMapping(value="contact", params="id")
	@ResponseBody
	public Contact getByIdFromParam(@RequestParam("id") Long id) {
		return contactDAO.selectById(id);
	}
	
	/**
	 * Saves new person. Spring automatically binds the name
	 * and age parameters in the request to the person argument
	 * @param person
	 * @return String indicating success or failure of save
	 */
	@RequestMapping(value="contact/save", method=RequestMethod.POST)
	@ResponseBody
	public String saveContact(@RequestBody Contact contact) {
		contactDAO.insert(contact);
		return "\"Saved contact: " + contact.getName() +"\"";
	}
	
	@RequestMapping(value="contact/update", method=RequestMethod.POST)
	@ResponseBody
	public String updateContact(@RequestBody Contact contact) {
		contactDAO.update(contact);
		return "\"Updated contact: " + contact.getName() +"\"";
	}

	@RequestMapping("contact/delete/{id}")
	@ResponseBody
	public String deleteById(@PathVariable Long id) {
		contactDAO.deleteById(id);
		return "\"Deleted contact: " + id+"\"";
	}

}