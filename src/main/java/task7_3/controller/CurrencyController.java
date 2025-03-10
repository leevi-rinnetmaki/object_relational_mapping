package task7_3.controller;

import task7_3.dao.CurrencyDao;
import task7_3.dao.TransactionDao;
import task7_3.entity.CurrencyModel;
import task7_3.view.CurrencyView;
import task7_3.entity.TransactionModel;

import java.util.List;


public class CurrencyController {
    CurrencyModel model;
    CurrencyView view;
    CurrencyDao dao;
    TransactionDao tDao;
    public List<CurrencyModel> currensies;
    int idTracker=1;

    public CurrencyController(CurrencyView view, CurrencyDao dao, TransactionDao tDao) {
        this.view = view;
        this.dao = dao;
        this.tDao = tDao;
        currensies = dao.getAllCurrencies2();
        //System.out.println(currensies.get(0).getAbbreviation());
        //view.addCurrency(currensies.get(0).getAbbreviation());
        //view.addCurrency("test");

    }

    public void convert(){
        try {
            double value = Double.parseDouble(view.getValue());
            double convert = (double)view.radioLeft();
            double converted = (double)view.radioRight();
            CurrencyModel source = null;
            CurrencyModel target = null;
            //view.setCOnverted(String.format("%.2f", model.convert(value, convert, converted)));
            view.setCOnverted(String.format("%.2f", value/convert*converted));
            //System.out.println(value/convert*converted);
            view.setErrorLabel("");
            for(CurrencyModel currency : currensies){
                if (currency.getAbbreviation().equals(view.radioLeftString())){
                    source = currency;
                }
                if (currency.getAbbreviation().equals(view.radioRightString())){
                    target = currency;
                }

            }

            if(source != null || target != null){
                tDao.addTransaction(new TransactionModel(idTracker, value, source, target));
                idTracker++;
            }


        }catch (Exception e){
            view.setErrorLabel("ERROR");
            System.out.println("ERROR " + e.getMessage());
        }
    }

    public void add(){
        CurrencyModel newCurrency = new CurrencyModel(view.abbreviationTextField.getText(), view.nameTextField.getText(), Double.parseDouble(view.rateTextField.getText()));
        dao.addCurrency(newCurrency);
        currensies = dao.getAllCurrencies2();
        view.addCurrency(newCurrency);
        //view.addCurrency(newCurrency);
    }


}