package br.com.meli.spring1.M4PI01spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(path = "decodificador/{num}")
    public String decodificador(@PathVariable String num) {
        int numConvertido = Integer.parseInt(num);

        String[] milhar = { "", "M", "MM", "MMM" };
        String[] centena = { "", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM" };
        String[] decimal = { "", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC" };
        String[] unidade = { "", "I", "II", "III", "IV", "V", "VI",
                "VII", "VIII", "IX", "X" };

        int numMilhar = numConvertido / 1000;
        int numCentena = (numConvertido / 100) % 10;
        int numDecimal = (numConvertido / 10) % 10;
        int numUnidade = numConvertido % 10;

        String romanoNum = milhar[numMilhar] + centena[numCentena]
                + decimal[numDecimal] + unidade[numUnidade];
        return romanoNum;
    }
}
