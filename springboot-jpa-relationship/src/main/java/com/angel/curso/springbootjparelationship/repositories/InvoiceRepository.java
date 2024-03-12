package com.angel.curso.springbootjparelationship.repositories;

import com.angel.curso.springbootjparelationship.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
