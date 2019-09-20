package com.company.DelcieDionU1Capstone.service;

import com.company.DelcieDionU1Capstone.dao.*;
import com.company.DelcieDionU1Capstone.dto.Game;
import com.company.DelcieDionU1Capstone.dto.TShirt;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

public class ServiceLayerTest {

    ServiceLayer service;
    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    TShirtDao tShirtDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;


    @Before
    public void setUp() throws Exception {
        // What does this do???
//        setUpConsoleDaoMock();
//        setUpGameDaoMock();
//        setUpInvoiceDaoMock();
//        setUpTShirtDaoMock();

//        setUpProcessingFeeDaoMock();
//        setUpSalesTaxRateDaoMock();

        service = new ServiceLayer(consoleDao, gameDao, tShirtDao, invoiceDao, processingFeeDao, salesTaxRateDao);
    }

    // ✷
    @Test
    public void addInvoice() {
    }

    // ✷
    @Test
    public void getInvoice() {
    }

    // ✷
    @Test
    public void getAllInvoices() {
    }

    @Test
    public void addConsole() {
    }

    @Test
    public void getAllConsoles() {
    }

    @Test
    public void getConsoleByManufacturer() {
    }

    @Test
    public void getConsole() {
    }

    @Test
    public void updateConsole() {
    }

    @Test
    public void deleteConsole() {
    }

    @Test
    public void addGame() {
    }

    @Test
    public void getAllGames() {
    }

    @Test
    public void getGamesByStudio() {
    }

    @Test
    public void getGamesByEsrb() {
    }

    @Test
    public void getGamesByTitle() {
    }

    @Test
    public void getGame() {
    }

    @Test
    public void updateGame() {
    }

    @Test
    public void deleteGame() {
    }

    @Test
    public void addShirt() {
    }

    @Test
    public void getAllShirts() {
    }

    @Test
    public void getShirtByColor() {
    }

    @Test
    public void getShirtBySize() {
    }

    @Test
    public void getShirt() {
    }

    @Test
    public void updateShirt() {
    }

    @Test
    public void deleteShirt() {
    }

    // HELPER METHODS
    /*
    invoice_id int(11) not null auto_increment primary key,
    name varchar(80) not null,
    street varchar(30) not null,
    city varchar(30) not null,
    state varchar(30) not null,
    zipcode varchar(5) not null,
    item_type varchar(20) not null,
    item_id int(11) not null,
    unit_price decimal(5,2) not null,
    quantity int(11) not null,
    subtotal decimal(5,2) not null,
    tax decimal(5,2) not null,
    processing_fee decimal (5,2) not null,
    total decimal(5,2) not null
     */


}