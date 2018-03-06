package com.groundZero.settlementChamber.repository;

import com.groundZero.settlementChamber.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {

}
