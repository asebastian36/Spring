package com.angel.curso.springboot.webappdifactura.controllers;

import com.angel.curso.springboot.webappdifactura.models.Client;
import com.angel.curso.springboot.webappdifactura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show() {
        Invoice newInvoice = new Invoice();

        Client client = new Client();
        client.setName(invoice.getClient().getName());
        client.setLastname(invoice.getClient().getLastname());

        newInvoice.setClient(client);
        newInvoice.setDescription(invoice.getDescription());
        newInvoice.setItems(invoice.getItems());
        return newInvoice;
    }
}
