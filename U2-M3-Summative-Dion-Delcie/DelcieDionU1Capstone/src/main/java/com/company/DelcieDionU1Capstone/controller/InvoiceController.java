package com.company.DelcieDionU1Capstone.controller;

import com.company.DelcieDionU1Capstone.dto.Invoice;
import com.company.DelcieDionU1Capstone.service.ServiceLayer;
import com.company.DelcieDionU1Capstone.viewmodel.InvoiceViewModel;
import com.company.DelcieDionU1Capstone.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/purchase")
public class InvoiceController {

    @Autowired
    ServiceLayer service;

    // ========== CREATE/ADD INVOICE ==========

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createInvoice (@RequestBody @Valid OrderViewModel ovm) {
        return service.addInvoice(ovm);
    }

    // ========== GET ALL INVOICES ==========

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices() {
        return service.getAllInvoices();
    }

    // ========== GET INVOICE ==========

    // public InvoiceViewModel getInvoice(int invoiceId)
    @RequestMapping(value = "/{invoiceId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable int invoiceId) {
        return service.getInvoice(invoiceId);
    }


}
