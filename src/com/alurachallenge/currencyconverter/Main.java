package com.alurachallenge.currencyconverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CurrencyInfo baseCurrencyInfo = new CurrencyInfo();

        //Welcome & base currency
        System.out.println("Bienvenid@ al conversor de monedas");

        //Base currency
        Scanner Input = new Scanner(System.in);
        System.out.println("Ingresa código moneda base:");
        String currencyInput = Input.nextLine();

        //conversion currency
        System.out.println("Ingresa código moneda esperado:");
        String currencyOutput = Input.nextLine();

        //Get info base currency and value of conversion currency
        Currency currencyInfo = baseCurrencyInfo.currencyInfo(currencyInput);
        double currencyRate = currencyInfo.conversion_rates().get(currencyOutput);

        //value & casting str to int
        System.out.println("Ingresa el valor a calcular: ");
        int changeValue = Integer.valueOf(Input.nextLine());

        //currency change
        double currencyChange = changeValue * currencyRate;
        System.out.println("El valor ingresado equivale a " + currencyChange + " " + currencyOutput);
    }
}
