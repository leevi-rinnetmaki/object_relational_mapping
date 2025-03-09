package task7_3.controller;

import task7_3.dao.CurrencyDao;
import task7_3.entity.CurrencyModel;
import task7_3.view.CurrencyView;

import java.util.List;


public class CurrencyController {
    CurrencyModel model;
    CurrencyView view;
    CurrencyDao dao;
    public List<CurrencyModel> currensies;

    public CurrencyController(CurrencyView view, CurrencyDao dao) {
        this.view = view;
        this.dao = dao;
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
            //view.setCOnverted(String.format("%.2f", model.convert(value, convert, converted)));
            view.setCOnverted(String.format("%.2f", value/convert*converted));
            //System.out.println(value/convert*converted);
            view.setErrorLabel("");

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