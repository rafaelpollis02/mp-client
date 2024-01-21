package br.com.service;

import br.com.domain.ClientEntity;
import br.com.exception.BusinessException;
import br.com.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    public List<ClientEntity> getAllClient() {
        return clientRepository.listAll();
    }

    public ClientEntity getClientById(Long id) throws BusinessException {

        ClientEntity clientEntity = clientRepository.findById(id);

        if (clientEntity == null) {
            throw new BusinessException("Não localizamos um cliente com o ID " + id);
        } else {
            return clientEntity;
        }
    }

    public ClientEntity saveClient(ClientEntity client) {
        clientRepository.persist(client);
        return client;
    }


}
