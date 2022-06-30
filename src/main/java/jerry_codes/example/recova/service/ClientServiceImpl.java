package jerry_codes.example.recova.service;

import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.model.ClientDto;
import jerry_codes.example.recova.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClient(ClientDto clientDto) {

        Client client = Client.builder()
                .firstname(clientDto.getFirstname())
                .lastname(clientDto.getLastname())
                .telephone(clientDto.getTelephone())
                .address(clientDto.getAddress())
                .nin(clientDto.getNin())
                .bvn(clientDto.getBvn())
                .build();
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Client::getFirstname))
                .collect(Collectors.toList());
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Client clientInDB = clientRepository.findById(id).get();
        if (Objects.nonNull(client.getFirstname())&&
        !"".equalsIgnoreCase(client.getFirstname())){
            clientInDB.setFirstname(client.getFirstname());
        }

        if (Objects.nonNull(client.getLastname()) &&
        !"".equalsIgnoreCase(client.getLastname())){
            clientInDB.setLastname(client.getLastname());
        }

        if (Objects.nonNull(client.getTelephone()) &&
                !"".equalsIgnoreCase(client.getTelephone())){
            clientInDB.setTelephone(client.getTelephone());
        }

        if (Objects.nonNull(client.getAddress()) &&
                !"".equalsIgnoreCase(client.getAddress())){
            clientInDB.setAddress(client.getAddress());
        }

        if (Objects.nonNull(client.getNin()) &&
                !"".equalsIgnoreCase(client.getNin())){
            clientInDB.setNin(client.getNin());
        }

        if (Objects.nonNull(client.getBvn()) &&
                !"".equalsIgnoreCase(client.getBvn())){
            clientInDB.setBvn(client.getBvn());
        }
        return clientRepository.save(clientInDB);
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()){
            throw new RuntimeException("Client not found" + id);
        }
        return clientRepository.findById(id).get();
    }
}
