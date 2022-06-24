package jerry_codes.example.recova.service;

import jerry_codes.example.recova.entity.Account;
import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.model.ClientDto;

import java.util.List;
import java.util.Set;

public interface ClientService {
    List<Client> findAllClient();

    Client saveClient(ClientDto clientDto);

    Client findClientByBvn(String BVN);

    Set<Account> findAllAccountsByIdAndBVN(Long id, String BVN);
}
