package com.example.practiceskay1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {

    @GetMapping("/currency-converter")
    public String currencyConverterPage() {
        return "currency-converter";
    }

    @PostMapping("/convert")
    public String convertCurrency(
            @RequestParam("fromCurrency") String fromCurrency,
            @RequestParam("toCurrency") String toCurrency,
            @RequestParam("amount") double amount,
            Model model) {
        double EUR = 103.92;
        double USD = 96.40;
        double convertedAmount = 0.0;

        if ("RUB".equals(fromCurrency) && "USD".equals(toCurrency)) {
            convertedAmount = amount * USD;
        } else if ("RUB".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            convertedAmount = amount / EUR;
        }

        else if ("EUR".equals(fromCurrency) && "USD".equals(toCurrency)) {
            convertedAmount = amount * (EUR / USD);
        }

        else if ("EUR".equals(fromCurrency) && "RUB".equals(toCurrency)) {
            convertedAmount = amount * EUR;
        }

        else if ("USD".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            convertedAmount = amount * (USD / EUR);
        }

        else if ("USD".equals(fromCurrency) && "RUB".equals(toCurrency)) {
            convertedAmount = amount * USD;
        }



        model.addAttribute("fromCurrency", fromCurrency);
        model.addAttribute("toCurrency", toCurrency);
        model.addAttribute("amount", amount);
        model.addAttribute("convertedAmount", convertedAmount);

        return "currency-converter";
    }


}