package com.acoer.test.contact.controller;

//imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoActionOperation;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Sorts.ascending;

import com.acoer.exception.ResourceNotFoundException;
import com.acoer.test.contact.domain.Contact;
import com.acoer.test.contact.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Controller
@RequestMapping("/contacts")
// Cross Origin to Instantiate Request Methods
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE })
@Api(tags = { "Contacts API - " })

// class For Contact Controller
public class ContactController {

	

	// MongoDatabase database = mongo.getDatabase("");
    //   //Creating a collection object
    //   MongoCollection<Contact> collection = database.getCollection("");

	// logger
	private static final Logger logger = LogManager.getLogger();

	// Contact Class Instance
	@Autowired
	private ContactService contactService;

	// contact Repo Instance
	@Autowired
	// private contactRepository cRepository;

	// set Contact Service Constructor
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	// Api Operation - retrieve all contacts
	@ApiOperation(value = "Get all contacts", notes = "Get all contacts")
	// api annotations & responses
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach isnot found")
	})

	// Create Operation - add Contact to List in MongoDB
	// Request Mapping : Add -> POST
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Contact contact) throws Exception {

		// logger
		logger.info("Adding to contacts list");

		// try catch statement
		// if contact exists - terminate process
		// output error
		// retry with a different contact

		try {
			contactService.add(contact);

			// error catching - dpulicate
		} catch (MongoWriteException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		} 
		// catch (CompletionException e) {
		// 	return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		// }
		return new ResponseEntity<>("Entry saved successfully", HttpStatus.OK);
	}

	// Update Operation - Update contents of Contact ( Number in this case )
	// Request Mapping : Update -> PUT
	@RequestMapping(value = "/update/{phonenumber}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable Contact phoneNum, @RequestBody Contact contact)
			throws Exception {

		// logger
		logger.info("Updating number in contacts list");
		try {
			// Retrieve Contacts
			Contact storedContact = (Contact) contactService.getAll();
			// Sets Contact First Name
			storedContact.setFName(contact.getFName());

			// Sets Contact Second Name
			storedContact.setSName(contact.getSName());

			// Sets contact Number
			storedContact.setNum(contact.getNum());

			// updates attributes
			contactService.update(storedContact);

			// returns successful message & HTTP response
			return new ResponseEntity<>("Entry updated successfully", HttpStatus.OK);
		} catch (ResourceNotFoundException e) {

		} catch (MongoWriteException e) {
			e.printStackTrace();
			return new ResponseEntity<>("Duplicate Number",HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.OK);

	}

	// Delete Operation - Delete contents of Contact( Name , Surname, Number)
	// Request Mapping - Delete -> DELETE
	@RequestMapping(value = "/delete/{phonenumber}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Contact phoneNum) throws ResourceNotFoundException {

		// logger
		logger.info("Deleting number & entry in contacts list");

		// Calls delete class to delete Phone Number
		try {
			contactService.delete(phoneNum);
			return new ResponseEntity<>("Number deleted successfully", HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
		}

		// if required to delete entire contact - adjust method to parse full contact
		// instance from contact
		// phoneNum - > contact
		// contactService.delete(contact);

		// returns successful message & HHTP response
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// List all Operation - Lists all contents of Contact ( Name , Surname , Number)
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Contact>> getContacts() {

		// logger
		logger.info("Retrieving list of contacts");

		// Retrives all contacts into array list
		List<Contact> result = new ArrayList<Contact>();

		// returns & Displays result & HTTP response
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	
	// Sort Surname Operation - Lists all contents of Contact via Surname Alphabetically
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Contact>> getContactsBySurname() {

		// logger
		logger.info("Retrieving list of contact in Ascending via First Names");

		// Retrives all contacts into array list
		List<Contact> result = new ArrayList<Contact>();


		// List<Contact> findByFirstName(String fName, Sort sort);

		// returns & Displays result & HTTP response
		return new ResponseEntity<>(result, HttpStatus.OK);

	}
	
	// Sort First Name Operation - Lists all contents of Contact by Name Alphabetically
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Contact>> getContactsByName() {

		// logger
		logger.info("Retrieving list of contacts in Ascending via First Name");

		// Retrives all contacts into array list
		List<Contact> result = Arrays.asList();
		


		// result.sort(Comparator.naturalOrder());
		// result.sort(ascending("fName")).into(result);
		// collection.find().sort(ascending("fName")).into(result);
		for(Contact results : result){
			return new ResponseEntity<>(result, HttpStatus.OK);
		}

		// returns & Displays result & HTTP response
		return new ResponseEntity<>(result, HttpStatus.OK);


	}

	// Search Operation - Searches for contact via Phone number
	@ApiOperation(value = "Search a Contact with a field", response = Contact.class)
	@RequestMapping(value = "/Search/{searchTerm}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Contact> showContact(@PathVariable String searchTerm, Model model) throws ResourceNotFoundException {

		// logger
		logger.info("Retrieving list of contacts");

		// Searches & throws an exception of contact search fails
		Contact contact;
		try {
			contact = (Contact) contactService.search(searchTerm).orElseThrow();
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// result.sort(Comparator.naturalOrder());
		// result.sort(ascending("fName")).into(result);
		// collection.find().sort(ascending("fName")).into(result);

		return new ResponseEntity<Contact>(HttpStatus.OK);
		// returns & displays searched results & HTTP response
		

}
}