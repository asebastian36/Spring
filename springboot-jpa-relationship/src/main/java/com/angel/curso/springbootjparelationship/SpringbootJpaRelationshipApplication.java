package com.angel.curso.springbootjparelationship;

import com.angel.curso.springbootjparelationship.entities.*;
import com.angel.curso.springbootjparelationship.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientDetailsRepository clientDetailsRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        oneToOneBidireccional();
    }

    @Transactional
    public void oneToOneBidireccional() {
        //  creamos un cliente, luego se crean los detalles y al final se relacionan guardando la relacion en bd
        Client client = new Client("Luis", "Mi");
        ClientDetails clientDetails = new ClientDetails(true, 5000);

        client.setClientDetails(clientDetails);
        clientDetails.setClient(client);

        clientRepository.save(client);
    }

    @Transactional
    public void oneToOneFindById() {
        //  buscamos un cliente, luego se crean los detalles y al final se relacionan guardando la relacion en bd
        ClientDetails clientDetails = new ClientDetails(true, 5000);
        clientDetailsRepository.save(clientDetails);

        Optional<Client> optionalClient = clientRepository.findOne(2L);
        optionalClient.ifPresent(client -> {
            client.setClientDetails(clientDetails);
            clientRepository.save(client);
        });
    }

    @Transactional
    public void oneToOne() {
        //  creamos un cliente, luego se crean los detalles y al final se relacionan guardando la relacion en bd
        ClientDetails clientDetails = new ClientDetails(true, 5000);
        clientDetailsRepository.save(clientDetails);

        Client client = new Client("Francisco", "Rodriguez");
        client.setClientDetails(clientDetails);
        clientRepository.save(client);
    }

    @Transactional
    public void removeInvoiceBidireccional() {
        //  se crea un cliente, le agrego dos facturas de manera bidireccional luego busco una factura y la elimino
        Client client = new Client("Sebastian", "Vergara");

        Invoice invoice0 = new Invoice("Compras para los examens", 2L);
        Invoice invoice1 = new Invoice("gastos para las calcomanias", 10L);

        client.addInvoice(invoice0).addInvoice(invoice1);
        clientRepository.save(client);

        Optional<Client> optionalClient1 = clientRepository.findOneWithInvoices(3L);

        optionalClient1.ifPresent(clientDb -> {
            Optional<Invoice> invoiceOptional = invoiceRepository.findById(2L);
            invoiceOptional.ifPresent(invoice -> {
                clientDb.removeInvoice(invoice);
                clientRepository.save(clientDb);
            });
        });
    }

    @Transactional
    public void removeInvoiceBidireccionalFindById() {
        //  busco un cliente, le agrego dos facturas de manera bidireccional luego busco una factura y la elimino
        Optional<Client> optionalClient = clientRepository.findOneWithInvoices(1L);
        optionalClient.ifPresent(client -> {
            Invoice invoice0 = new Invoice("Compras para los examens", 2L);
            Invoice invoice1 = new Invoice("gastos para las calcomanias", 10L);

            client.addInvoice(invoice0).addInvoice(invoice1);

            clientRepository.save(client);
        });

        Optional<Client> optionalClient1 = clientRepository.findOneWithInvoices(1L);

        optionalClient1.ifPresent(client -> {
           Optional<Invoice> invoiceOptional = invoiceRepository.findById(2L);
           invoiceOptional.ifPresent(invoice -> {
              client.removeInvoice(invoice);
              clientRepository.save(client);
           });
        });
    }

    @Transactional
    public void oneToManyBidireccionalFindById() {
        //  busco un cliente, le agrego dos facturas de manera bidireccional
        Optional<Client> optionalClient = clientRepository.findOneWithInvoices(1L);
        optionalClient.ifPresent(client -> {
            Invoice invoice0 = new Invoice("Compras para los examens", 2L);
            Invoice invoice1 = new Invoice("gastos para las calcomanias", 10L);

            client.addInvoice(invoice0).addInvoice(invoice1);

            clientRepository.save(client);
        });
    }

    @Transactional
    public void oneToManyBidireccional() {
        // agrego un cliente con dos facturas de manera bidireccional
        Client client = new Client("Sebastian", "Vergara");

        Invoice invoice0 = new Invoice("Compras para los caldos", 2500L);
        Invoice invoice1 = new Invoice("gastos para la moto", 200L);

        //  metodo personalizado para pasar cliente a factura
        client.addInvoice(invoice0).addInvoice(invoice1);

        clientRepository.save(client);
    }

    @Transactional
    public void removeAddressFindByIdClient() {
        //  busco al cliente 2 y le agrego dos direcciones, lo vuelvo a buscar despues para eliminar una direccion
        Optional<Client> optionalClient = clientRepository.findOneWithAdresses(2L);
        optionalClient.ifPresent(client -> {
            Address dir0 = new Address("Brasil", 891);
            Address dir1 = new Address("Argentina", 89);

            client.getAddresses().add(dir0);
            client.getAddresses().add(dir1);

            clientRepository.save(client);

            Optional<Client> optional = clientRepository.findOneWithAdresses(2L);
            optional.ifPresent(c -> {
                Address address = c.getAddresses().stream().findFirst().get();
                c.getAddresses().remove(address);
                clientRepository.save(c);
            });
        });
    }

    //  desde este metodo empiezan los cambios de fetch
    @Transactional
    public void removeAddress() {
        //  agrego un cliente con dos direcciones nuevas, lo busco y elimino una de sus direcciones
        Client client = new Client("Cesar", "Alvarez");

        Address dir0 = new Address("Exito", 567);
        Address dir1 = new Address("La v****", 567);

        Set<Address> addresses = new HashSet<>();
        addresses.add(dir0);
        addresses.add(dir1);
        client.setAddresses(addresses);

        clientRepository.save(client);

        Optional<Client> result = clientRepository.findOneWithAdresses(3L);
        result.ifPresent(c -> {
            c.getAddresses().remove(dir1);
            clientRepository.save(c);
        });
    }

    @Transactional
    public void oneToManyFindByIdClient() {
        //  busco al cliente 2 y le agrego dos direcciones
        Optional<Client> optionalClient = clientRepository.findById(2L);

        optionalClient.ifPresent(client -> {
            Address dir0 = new Address("Alaska", 123);
            Address dir1 = new Address("Canada", 1234);

            Set<Address> addresses = new HashSet<>();
            addresses.add(dir0);
            addresses.add(dir1);
            client.setAddresses(addresses);

            clientRepository.save(client);
        });
    }

    @Transactional
    public void oneToManyCreate() {
        //  agrego un cliente, creo dos direcciones y lo agrego a la bd de manera unidireccional
        Client client = new Client("Jesus", "Rodriguez");

        Address dir0 = new Address("La chingada", 123);
        Address dir1 = new Address("La v****", 1234);

        client.getAddresses().add(dir0);
        client.getAddresses().add(dir1);

        clientRepository.save(client);
    }

    @Transactional
    public void manyToOneFindByIdClient() {
        //  si encuentro al cliente 1, le agrego una factura
        Optional<Client> optionalClient = clientRepository.findById(1L);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.orElseThrow();

            Invoice invoice = new Invoice("Compras para la pc", 5000L);
            invoice.setClient(client);

            invoiceRepository.save(invoice);
        }
    }

    @Transactional
    public void manyToOneCreate() {
        //  agrego un cliente y a ese cliente le agrego una factura
        Client client = new Client("Barbara", "Franco");
        clientRepository.save(client);

        Invoice invoice = new Invoice("Compras del Shein", 1000L);
        invoice.setClient(client);

        invoiceRepository.save(invoice);
    }
}
