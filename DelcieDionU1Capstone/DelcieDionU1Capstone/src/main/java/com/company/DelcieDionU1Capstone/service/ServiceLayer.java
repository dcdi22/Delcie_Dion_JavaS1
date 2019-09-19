package com.company.DelcieDionU1Capstone.service;

import com.company.DelcieDionU1Capstone.dao.*;
import com.company.DelcieDionU1Capstone.dto.Console;
import com.company.DelcieDionU1Capstone.dto.Game;
import com.company.DelcieDionU1Capstone.dto.Invoice;
import com.company.DelcieDionU1Capstone.dto.TShirt;
import com.company.DelcieDionU1Capstone.viewmodel.InvoiceViewModel;
import com.company.DelcieDionU1Capstone.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ServiceLayer {

    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private TShirtDao tShirtDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxRateDao salesTaxRateDao;

    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, TShirtDao tShirtDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.tShirtDao = tShirtDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
    }


    //
    // Invoice Api
    //

    @Transactional
    public InvoiceViewModel addInvoice(OrderViewModel orderViewModel) {

        /*
        private int invoiceId;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String itemType;
    private int itemId;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
    private BigDecimal total;
         */

        // Persist Invoice
        Invoice i = new Invoice();
        i.setName(orderViewModel.getName());
        i.setStreet(orderViewModel.getStreet());
        i.setCity(orderViewModel.getCity());
        i.setState(orderViewModel.getState());
        i.setZipcode(orderViewModel.getZipcode());
        i.setItemType(orderViewModel.getItemType());
        i.setItemId(orderViewModel.getItemId());
        i.setQuantity(orderViewModel.getQuantity());

        // get unit_price, using a switch statement, 2 switch statements?
        switch(orderViewModel.getItemType()) {
            case "Game":
                if (gameDao.getAllGames().contains(gameDao.getGame(orderViewModel.getItemId()))) {
                    i.setUnitPrice(gameDao.getGame(orderViewModel.getItemId()).getPrice());
//                    gameDao.getGame(orderViewModel.getItemId()).getPrice();

                    // update Quantity
                    Game gameUpdated = gameDao.getGame(orderViewModel.getItemId());
                    int userQuantity = orderViewModel.getQuantity();
                    int dbQuantity = gameUpdated.getQuantity();
                    int newQuantity = dbQuantity - userQuantity;
                    gameUpdated.setQuantity(newQuantity);
                    gameDao.updateGame(gameUpdated);
                }
                break;
            case "Console":
                if (consoleDao.getAllConsoles().contains(consoleDao.getConsole(orderViewModel.getItemId()))) {
                    i.setUnitPrice(consoleDao.getConsole(orderViewModel.getItemId()).getPrice());

                    // update Quantity
                    Console consoleUpdated = consoleDao.getConsole(orderViewModel.getItemId());
                    int userQuantity = orderViewModel.getQuantity();
                    int dbQuantity = consoleUpdated.getQuantity();
                    int newQuantity = dbQuantity - userQuantity;
                    consoleUpdated.setQuantity(newQuantity);
                    consoleDao.updateConsole(consoleUpdated);
                }
                break;
            case "TShirt":
                if (tShirtDao.getAllShirts().contains(tShirtDao.getShirt(orderViewModel.getItemId()))) {
                    i.setUnitPrice(tShirtDao.getShirt(orderViewModel.getItemId()).getPrice());

                    // update Quantity
                    TShirt shirtUpdated = tShirtDao.getShirt(orderViewModel.getItemId());
                    int userQuantity = orderViewModel.getQuantity();
                    int dbQuantity = shirtUpdated.getQuantity();
                    int newQuantity = dbQuantity - userQuantity;
                    shirtUpdated.setQuantity(newQuantity);
                    tShirtDao.updateShirt(shirtUpdated);
                }
                break;
            default:
                throw new IllegalArgumentException("Not a valid Item Type");
//                System.out.println("Not a valid Item Type");
        }

        // get subtotal
        BigDecimal myPrice = i.getUnitPrice();
        BigDecimal myQuantity = new BigDecimal(i.getQuantity());
        BigDecimal mySubTotal = myPrice.multiply(myQuantity);

        i.setSubtotal(mySubTotal);

        // get tax
        if (salesTaxRateDao.getAllSTR().contains(salesTaxRateDao.getSTR(orderViewModel.getState()))) {
            BigDecimal myRate = salesTaxRateDao.getSTR(orderViewModel.getState()).getRate();
            BigDecimal myTax = mySubTotal.multiply(myRate);

            i.setTax(myTax);
        }

        // get processing_fee
        if (processingFeeDao.getAllProcessingFees().contains(processingFeeDao.getProcessingFee(orderViewModel.getItemType()))) {
            if (orderViewModel.getQuantity() > 10) {
                BigDecimal ogFee = processingFeeDao.getProcessingFee(orderViewModel.getItemType()).getFee();
                BigDecimal myFee = ogFee.multiply(new BigDecimal("15.49"));

                i.setProcessingFee(myFee);
            } else {
                BigDecimal ogFee = processingFeeDao.getProcessingFee(orderViewModel.getItemType()).getFee();

                i.setProcessingFee(ogFee);
            }
        }

        // get total
        BigDecimal myTotal = mySubTotal.add(i.getTax()).add(i.getProcessingFee());

        i.setTotal(myTotal);

        i = invoiceDao.addInvoice(i);

        InvoiceViewModel vm = new InvoiceViewModel();
        vm.setInvoiceId(i.getInvoiceId());
        return vm;


    }



    //
    // Console Api
    //

    public Console addConsole(Console console) {
        return consoleDao.addConsole(console);
    }

    public List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    public List<Console> getConsoleByManufacturer(String manu) {
        return consoleDao.getConsoleByManufacturer(manu);
    }

    public Console getConsole(int consoleId) {
        return consoleDao.getConsole(consoleId);
    }

    public void updateConsole(Console console) {
        consoleDao.updateConsole(console);
    }

    public void deleteConsole(int consoleId) {
        consoleDao.deleteConsole(consoleId);
    }

    //
    // Game Api
    //

    public Game addGame(Game game) {
        return gameDao.addGame(game);
    }

    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    public List<Game> getGamesByStudio(String studio) {
        return gameDao.getGamesByStudio(studio);
    }

    public List<Game> getGamesByEsrb(String esrbRating) {
        return gameDao.getGamesByEsrb(esrbRating);
    }

    public List<Game> getGamesByTitle(String title) {
        return gameDao.getGamesByTitle(title);
    }

    public Game getGame(int gameId) {
        return gameDao.getGame(gameId);
    }

    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    public void deleteGame(int gameId) {
        gameDao.deleteGame(gameId);
    }

    //
    // Tshirt Api
    //

    public TShirt addShirt(TShirt shirt) {
        return tShirtDao.addShirt(shirt);
    }

    public List<TShirt> getAllShirts() {
        return tShirtDao.getAllShirts();
    }

    public List<TShirt> getShirtByColor(String color) {
        return tShirtDao.getShirtByColor(color);
    }

    public List<TShirt> getShirtBySize(String size) {
        return tShirtDao.getShirtBySize(size);
    }

    public TShirt getShirt(int shirtId) {
        return tShirtDao.getShirt(shirtId);
    }

    public void updateShirt(TShirt shirt) {
        tShirtDao.updateShirt(shirt);
    }

    public void deleteShirt(int shirtId) {
        tShirtDao.deleteShirt(shirtId);
    }




}
