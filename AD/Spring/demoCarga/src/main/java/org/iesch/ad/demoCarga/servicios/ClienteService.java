package org.iesch.ad.demoCarga.servicios;

import jakarta.transaction.Transactional;
import org.iesch.ad.demoCarga.modelo.Cliente;
import org.iesch.ad.demoCarga.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Los servicios sirven para la lógica de negocio
@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepositorio clienteRepositorio;

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Transactional
    public void mostrarDatos(long id) {

        logger.trace("entra en mostrar datos");
        logger.debug("id " + id);

        Optional<Cliente> clienteOptional = clienteRepositorio.findById(id);
        logger.debug("Se hace la consulta findById");

        if (clienteOptional.isPresent()) {

            Cliente cliente = clienteOptional.get();
            System.out.println(cliente.getNombre());
            System.out.println(cliente.getId());
            System.out.println(cliente);

            System.out.println("---".repeat(10));
            System.out.println(cliente.getPedidos().size());

        } else System.out.println("No existe el cliente con id " + id);

        logger.trace("Sale de mostrarDatos");
    }

    @Transactional
    public void mostrarTodos() {

        List<Cliente> clienteList = clienteRepositorio.findAll();
//
//        System.out.println(clienteList.size());
//        System.out.println("###".repeat(20));
//
//        for (Cliente cliente : clienteList) {
//
//            System.out.println("Pedidos Cliente: " + cliente.getId() + " "
//            + cliente.getPedidos().size());
//
//        }

    }

    public void arreglaN1() {

        List<Cliente> clienteList = clienteRepositorio.findAllConPedidos();
        System.out.println(clienteList);

    }
}
