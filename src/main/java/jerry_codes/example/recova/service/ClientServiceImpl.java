package jerry_codes.example.recova.service;

import jerry_codes.example.recova.entity.Account;
import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.model.ClientDto;
import jerry_codes.example.recova.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Client::getFirstname))
                .collect(Collectors.toList());
    }

    @Override
    public Client saveClient(ClientDto clientDto) {

        Client client = Client.builder()
                .firstname(clientDto.getFirstname())
                .lastname(clientDto.getLastname())
                .address(clientDto.getAddress())
                .phonenumber(clientDto.getPhonenumber())
                .BVN(clientDto.getBVN())
                .NIN(clientDto.getNIN())
                .accounts(clientDto.getAccounts())
                .build();
        return client;
    }

    @Override
    public Client findClientByBvn(String BVN) {

        Client client = clientRepository.findByBVN(BVN);

        if (!BVN.isEmpty()) {
            client.getAccounts()
                    .forEach(account -> account.getAccountNumber().matches(client.getBVN()));

            if (client.getAccounts().isEmpty()) {
                client.getAccounts().forEach(account -> account.getAccountBalance());

            }
            throw new RuntimeException();
        }
        return client;
    }

    @Override
    public Set<Account> findAllAccountsByIdAndBVN(Long id, String BVN) {

       // Optional<Client> client1 = clientRepository.findAllAccountsByClient(id, client);
        Set<Account> accounts = clientRepository.findAllAccountsByIdAndBVN(id, BVN);

        if (accounts.isEmpty()){
            throw new RuntimeException();
        }else

        do {
            clientRepository.findByBVN(BVN).getAccounts()
                    .forEach(account -> account.getAccountBalance());
        }
        while (!accounts.isEmpty());

        return clientRepository.getById(id)
                .getAccounts()
                .stream()
                .sorted(Comparator.comparing(Account::getBank))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Map<String, BigDecimal>> findAllBalancesByBank(Long id) {

        Optional<Client> client = clientRepository.findById(id);

        if (client.isEmpty()) {
            throw new RuntimeException("Client not present" + id);
        }

        return client.get().getAccounts()
                .stream()
                .map(account -> Map.of(account.getBank(), account.getAccountBalance()))
                .collect(Collectors.toSet());
    }
}
