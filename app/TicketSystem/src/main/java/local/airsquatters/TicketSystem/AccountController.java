package local.airsquatters.TicketSystem;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(value = "/")
public class AccountController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
	private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

	// public AccountController(AccountService accountService) {
	// 	this.accountService = accountService;
    // }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAllAccounts() {
	    LOG.info("Getting all accounts.");
	    return new ResponseEntity<List<Account>>(accountService.findAllAccounts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{cofcId}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable Integer cofcId) {
	    LOG.info("Getting user with ID: {}.", cofcId);
	    return new ResponseEntity<Account>(accountService.findSingleAccount(cofcId), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Account addNewUsers(@RequestBody Account account) {
//         Account u = new Account();
//         u.setFirstName(account.getFirstName());
//         u.setLastName(account.getLastName());
//         u.setEmail(account.getEmail());

// ObjectMapper mapper = new ObjectMapper();
    
//     try {
//         // convert user object to json string and return it 
//         mapper.writeValueAsString(u);
//     }
//     catch (JsonGenerationException | JsonMappingException  e) {
//         // catch various errors
//         e.printStackTrace();
//     }
	    LOG.info("Saving account.");
	    return createAccount(account);
    }

    public Account createAccount(int cofcId, String firstName, String lastName, String password, String email) {
        Account account = new Account(cofcId, firstName, lastName, password, email);
        try {
            accountRepository.insert(account);
            
            mongoTemplate.update( Account.class ).apply(new Update().push("cofcId").value(account)).first();
        }
        catch (Exception e) {
            throw e;
        }
        return account;
    }

    public Account createAccount(Account account) {
        try {
            accountRepository.insert(account);
            mongoTemplate.update(Account.class)
                .apply(new Update().push("cofcId").value(account))
                .first();
        }
        catch (Exception e) {
            throw e;
        }
        return account;
    }


}
