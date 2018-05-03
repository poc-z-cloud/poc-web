package poc.spring.mvc.rest.web;

import java.util.ArrayList;
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
public class ShoppingController {
	
	private static List<String> shoppingList= new ArrayList<String>();
	static{
		shoppingList.add("Milk");
		shoppingList.add("Bread");
		shoppingList.add("Cheese");
		
	}
	
	@Autowired private ContactDAO contactDAO;
	
	@RequestMapping("shopping/list")
	@ResponseBody
	public List<String> getContactList() {
		return shoppingList;
	}
	
	@RequestMapping(value="shopping/save", method=RequestMethod.POST)
	@ResponseBody
	public String saveContact(@RequestBody String shoppingItem) {
		shoppingList.add(shoppingItem);
		return "\"Saved Shopping Item: " + shoppingItem +"\"";
	}
	
	@RequestMapping("shopping/delete/{shoppingItem}")
	@ResponseBody
	public String deleteById(@PathVariable String shoppingItem) {
		shoppingList.remove(shoppingItem);
		return "\"Deleted Shopping Item: " + shoppingItem +"\"";
	}

}