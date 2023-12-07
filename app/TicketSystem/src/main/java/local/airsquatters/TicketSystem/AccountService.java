package local.airsquatters.TicketSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    public Account findSingleAccount(Integer cofcId) {
        return accountRepository.findAccountByCofcId(cofcId);
    }

    public Account createAccount(int cofcId, String firstName, String lastName, String password, String email) {
        Account account = new Account(cofcId, firstName, lastName, password, email);
        accountRepository.insert(account);

        mongoTemplate.update(Account.class)
            .apply(new Update().push("cofcIds").value(account))
            .first();

            return account;
    }

    public Account createAccount(Account account) {
        accountRepository.insert(account);

        mongoTemplate.update(Account.class)
            .apply(new Update().push("cofcIds").value(account))
            .first();

            return account;
    }

}
