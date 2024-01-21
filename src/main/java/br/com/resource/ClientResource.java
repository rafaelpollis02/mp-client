package br.com.resource;

import br.com.domain.ClientEntity;
import br.com.exception.BusinessException;
import br.com.service.ClientService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("api/v1/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {

    @Inject
    ClientService clientService;

    @GET
    public List<ClientEntity> getAllClient() {
        return clientService.getAllClient();
    }

    @GET
    @Path("{id}")
    public ClientEntity getClientById(@PathParam("id") Long id) throws BusinessException {
        return clientService.getClientById(id);
    }

    @POST
    @Transactional
    public ClientEntity saveClient(ClientEntity client) {
        clientService.saveClient(client);
        return client;
    }

}
