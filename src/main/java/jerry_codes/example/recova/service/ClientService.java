package jerry_codes.example.recova.service;

import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.model.ClientDto;

import java.util.List;

public interface ClientService {
    Client saveClient(ClientDto clientDto);

    List<Client> findAllClient();

    Client updateClient(Long id, Client client);

    Client findById(Long id);

    Client deleteById(Long id);
}
