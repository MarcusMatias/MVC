package com.vendas.conversor.service;

import org.springframework.stereotype.Service;

@Service
public class ConversaoService {

    public double converter(double valor, String moedaOrigem, String moedaDestino) {
        double taxaConversao = obterTaxaConversao(moedaOrigem, moedaDestino);
        return valor * taxaConversao;
    }

    private double obterTaxaConversao(String moedaOrigem, String moedaDestino) {
        switch (moedaOrigem) {
            case "USD":
                switch (moedaDestino) {
                    case "BRL":
                        return 5.0; // ex: 1 dollar = 5 reais
                    case "BTC":
                        return 0.000015; // ex: 1 dollar = 0.000015 BTC
                    case "EUR":
                        return 0.92; // ex: 1 dollar = 0.92 euro
                    default:
                        return 1.0; // quando não há conversão
                }
            case "BRL":
                switch (moedaDestino) {
                    case "USD":
                        return 0.20; // ex: 1 reais = 0.20 dollar
                    case "BTC":
                        return 0.0000028; // ex: 1 real = 0.0000028 bitcoin
                    case "EUR":
                        return 0.18; // ex: 1 real = 0.18 euro
                    default:
                        return 1.0; // quando não há conversão
                }
            case "BTC":
                switch (moedaDestino) {
                    case "BRL":
                        return 356.833; // ex: 1 BTC = 356.833,84 euro
                    case "USD":
                        return 68.556; // ex: 1 BTC = 68.556,80 Dollar
                    case "EUR":
                        return 63.262; // ex: 1 BTC = 63.262,84 Dollar
                    default:
                        return 1.0; // quando não há conversão
                }
            case "EUR":
                switch (moedaDestino) {
                    case "BRL":
                        return 5.64; // ex: 1 EUR = 5.64 Real
                    case "USD":
                        return 1.08; // ex: 1 EUR = 1.08 Dollar
                    case "BTC":
                        return 0.000016; // ex: 1 EUR = 0.000015 BTC
                    default:
                        return 1.0; // quando não há conversão
                }
            default:
                return 1.0; // quando não há conversão
        }
    }
    
}

