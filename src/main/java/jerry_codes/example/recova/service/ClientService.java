package jerry_codes.example.recova.service;

import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.model.ClientDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ClientService {
    Client saveClient(ClientDto clientDto);

    List<Client> findAllClient();

    Client updateClient(Long id, Client client);

    Client findById(Long id);
}
