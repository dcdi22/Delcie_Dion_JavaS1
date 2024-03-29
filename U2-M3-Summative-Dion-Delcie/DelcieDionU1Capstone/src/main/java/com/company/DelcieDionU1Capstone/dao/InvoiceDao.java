package com.company.DelcieDionU1Capstone.dao;

import com.company.DelcieDionU1Capstone.dto.Invoice;

import java.util.List;

public interface InvoiceDao {

    /*
    get
    get all
    add
    update
    delete
     */

    Invoice getInvoice(int invoiceId);

    List<Invoice> getAllInvoices();

    Invoice addInvoice(Invoice invoice);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int invoiceId);



}
