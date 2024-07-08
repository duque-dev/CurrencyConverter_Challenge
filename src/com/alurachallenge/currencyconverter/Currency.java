package com.alurachallenge.currencyconverter;

import java.util.Map;

public record Currency(String baseCode, Map<String, Double> conversionRates) {
}
