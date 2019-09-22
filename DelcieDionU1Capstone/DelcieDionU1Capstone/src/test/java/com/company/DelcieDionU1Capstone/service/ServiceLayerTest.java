package com.company.DelcieDionU1Capstone.service;

import com.company.DelcieDionU1Capstone.dao.*;
import com.company.DelcieDionU1Capstone.dto.*;
import com.company.DelcieDionU1Capstone.viewmodel.OrderViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpTShirtDaoMock();

        setUpProcessingFeeDaoMock();
        setUpSalesTaxRateDaoMock();

        service = new ServiceLayer(consoleDao, gameDao, tShirtDao, invoiceDao, processingFeeDao, salesTaxRateDao);
    }

    // ✷
    @Test
    public void addGetInvoice() {
        //example OrderViewModel that would come in
        OrderViewModel ovm = new OrderViewModel();
        ovm.setName("Delcie");
        ovm.setStreet("Street");
        ovm.setCity("City");
        ovm.setState("GA");
        ovm.setZipcode("30102");
        ovm.setItemType("Consoles");
        ovm.setItemId(1);
        ovm.setQuantity(1);

        service.addInvoice(ovm);

        //example complete and calculated Invoice to be returned
        Invoice i = new Invoice();
        i.setName(ovm.getName());
        i.setStreet(ovm.getStreet());
        i.setCity(ovm.getCity());
        i.setState(ovm.getState());
        i.setZipcode(ovm.getZipcode());
        i.setItemType(ovm.getItemType());
        i.setItemId(ovm.getItemId());
        i.setUnitPrice(new BigDecimal("50.00"));
        i.setQuantity(ovm.getQuantity());
        i.setSubtotal(new BigDecimal("50.00"));
        i.setTax(new BigDecimal("3.50"));
        i.setProcessingFee(new BigDecimal("14.99"));
        i.setTotal(new BigDecimal("68.49"));

        //adding invoice
        i = invoiceDao.addInvoice(i);

        //retrieving invoice
        Invoice fromService = service.getInvoice(i.getInvoiceId());

        assertEquals(i, fromService);
//        assertEquals(ovm, fromService);

    }

    // ✷
    @Test
    public void getAllInvoices() {
        //example OrderViewModel that would come in
        OrderViewModel ovm = new OrderViewModel();
        ovm.setName("Delcie");
        ovm.setStreet("Street");
        ovm.setCity("City");
        ovm.setState("GA");
        ovm.setZipcode("30102");
        ovm.setItemType("Consoles");
        ovm.setItemId(1);
        ovm.setQuantity(1);

        service.addInvoice(ovm);

        //example complete and calculated Invoice to be returned
        Invoice i = new Invoice();
        i.setName(ovm.getName());
        i.setStreet(ovm.getStreet());
        i.setCity(ovm.getCity());
        i.setState(ovm.getState());
        i.setZipcode(ovm.getZipcode());
        i.setItemType(ovm.getItemType());
        i.setItemId(ovm.getItemId());
        i.setUnitPrice(new BigDecimal("50.00"));
        i.setQuantity(ovm.getQuantity());
        i.setSubtotal(new BigDecimal("50.00"));
        i.setTax(new BigDecimal("3.50"));
        i.setProcessingFee(new BigDecimal("14.99"));
        i.setTotal(new BigDecimal("68.49"));

        //adding invoice
        i = invoiceDao.addInvoice(i);

        List<Invoice>
    }

    // ✷ ##################################

    @Test
    public void addConsole() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("A lot");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("50.00"));
        console.setQuantity(1);
        console = service.addConsole(console);
        Console fromService = service.getConsole(console.getConsoleId());
        assertEquals(console, fromService);

    }

    @Test
    public void getAllConsoles() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("A lot");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("50.00"));
        console.setQuantity(1);
        console = service.addConsole(console);
        List<Console> cList = service.getAllConsoles();
        assertEquals(1, cList.size());
        assertEquals(console, cList.get(0));
    }

    @Test
    public void getConsoleByManufacturer() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("A lot");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("50.00"));
        console.setQuantity(1);
        console = service.addConsole(console);
        List<Console> cList = service.getConsoleByManufacturer("Sony");
        assertEquals(1, cList.size());
        assertEquals(console, cList.get(0));
    }

    @Test
    public void getConsole() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("A lot");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("50.00"));
        console.setQuantity(1);
        console = service.addConsole(console);
        Console fromService = service.getConsole(console.getConsoleId());
        assertEquals(console, fromService);
    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("A lot");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("50.00"));
        console.setQuantity(1);
        console = service.addConsole(console);

        ArgumentCaptor<Console> consoleCaptor = ArgumentCaptor.forClass(Console.class);
        doNothing().when(consoleDao).updateConsole(consoleCaptor.capture());
        service.updateConsole(console);
        verify(consoleDao, times(1)).updateConsole(consoleCaptor.getValue());
        Console console2 = consoleCaptor.getValue();
        assertEquals(console, console2);
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
    private void setUpInvoiceDaoMock() {
        // What's the point of this line?
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("Delcie");
        invoice.setStreet("Street");
        invoice.setCity("City");
        invoice.setState("GA");
        invoice.setZipcode("30102");
        invoice.setItemType("Consoles");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("50.00"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("50.00"));
        invoice.setTax(new BigDecimal("3.50"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("68.49"));

        Invoice invoice2 = new Invoice();
        invoice2.setName("Delcie");
        invoice2.setStreet("Street");
        invoice2.setCity("City");
        invoice2.setState("GA");
        invoice2.setZipcode("30102");
        invoice2.setItemType("Consoles");
        invoice2.setItemId(1);
        invoice2.setUnitPrice(new BigDecimal("50.00"));
        invoice2.setQuantity(1);
        invoice2.setSubtotal(new BigDecimal("50.00"));
        invoice2.setTax(new BigDecimal("3.50"));
        invoice2.setProcessingFee(new BigDecimal("14.99"));
        invoice2.setTotal(new BigDecimal("68.49"));

        List<Invoice> iList = new ArrayList<>();
        iList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(1);
        doReturn(iList).when(invoiceDao).getAllInvoices();

    }

    private void setUpConsoleDaoMock() {

        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);
        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("A lot");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("50.00"));
        console.setQuantity(1);

        Console console2 = new Console();
        console2.setModel("PS4");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("A lot");
        console2.setProcessor("AMD");
        console2.setPrice(new BigDecimal("50.00"));
        console2.setQuantity(1);

        List<Console> cList = new ArrayList<>();
        cList.add(console);

        doReturn(console).when(consoleDao).addConsole(console2);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(cList).when(consoleDao).getAllConsoles();
        doReturn(cList).when(consoleDao).getConsoleByManufacturer("Sony");

    }

    public void setUpGameDaoMock() {

        gameDao = mock(GameDaoJdbcTemplateImpl.class);
        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Horizon Zero Dawn");
        game.setEsrbRating("T");
        game.setDescription("post-apocalypse");
        game.setPrice(new BigDecimal("20.65"));
        game.setStudio("Guerrilla Games");
        game.setQuantity(1);

        Game game2 = new Game();
        game2.setTitle("Horizon Zero Dawn");
        game2.setEsrbRating("T");
        game2.setDescription("post-apocalypse");
        game2.setPrice(new BigDecimal("20.65"));
        game2.setStudio("Guerrilla Games");
        game2.setQuantity(1);

        List<Game> gList = new ArrayList<>();
        gList.add(game);

        doReturn(game).when(gameDao).addGame(game2);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(gList).when(gameDao).getAllGames();
        doReturn(gList).when(gameDao).getGamesByTitle("Horizon Zero Dawn");
        doReturn(gList).when(gameDao).getGamesByEsrb("T");
        doReturn(gList).when(gameDao).getGamesByStudio("Guerrilla Games");

    }

    public void setUpTShirtDaoMock() {

        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);
        TShirt shirt = new TShirt();
        shirt.setTshirtId(1);
        shirt.setSize("S");
        shirt.setColor("Blue");
        shirt.setDescription("Small Blue Shirt");
        shirt.setPrice(new BigDecimal("12.00"));
        shirt.setQuantity(1);

        TShirt shirt2 = new TShirt();
        shirt2.setSize("S");
        shirt2.setColor("Blue");
        shirt2.setDescription("Small Blue Shirt");
        shirt2.setPrice(new BigDecimal("12.00"));
        shirt2.setQuantity(1);

        List<TShirt> sList = new ArrayList<>();
        sList.add(shirt);

        doReturn(shirt).when(tShirtDao).addShirt(shirt2);
        doReturn(shirt).when(tShirtDao).getShirt(1);
        doReturn(sList).when(tShirtDao).getAllShirts();
        doReturn(sList).when(tShirtDao).getShirtBySize("S");
        doReturn(sList).when(tShirtDao).getShirtByColor("Blue");


    }

    public void setUpSalesTaxRateDaoMock() {
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);
        SalesTaxRate str = new SalesTaxRate();
        str.setState("GA");
        str.setRate(new BigDecimal("0.07"));

        SalesTaxRate str2 = new SalesTaxRate();
        str2.setState("GA");
        str2.setRate(new BigDecimal("0.07"));

        List<SalesTaxRate> strList = new ArrayList<>();
        strList.add(str);

        doReturn(str).when(salesTaxRateDao).addSTR(str);
        doReturn(str).when(salesTaxRateDao).getSTR("GA");
        doReturn(strList).when(salesTaxRateDao).getAllSTR();

    }

    public void setUpProcessingFeeDaoMock() {
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);
        ProcessingFee pf = new ProcessingFee();
        pf.setProductType("Consoles");
        pf.setFee(new BigDecimal("14.99"));

        ProcessingFee pf2 = new ProcessingFee();
        pf2.setProductType("Consoles");
        pf2.setFee(new BigDecimal("14.99"));

        List<ProcessingFee> pfList = new ArrayList<>();
        pfList.add(pf);

        doReturn(pf).when(processingFeeDao).addProcessingFee(pf2);
        doReturn(pf).when(processingFeeDao).getProcessingFee("Consoles");
        doReturn(pfList).when(processingFeeDao).getAllProcessingFees();
    }


}