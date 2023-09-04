package com.example.practiceskay1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/calculator")
    public String calculatorPage() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("operation") String operation,
            Model model) {
        double result = 0.0;

        if ("add".equals(operation)) {
            result = num1 + num2;
        } else if ("subtract".equals(operation)) {
            result = num1 - num2;
        } else if ("multiply".equals(operation)) {
            result = num1 * num2;
        } else if ("divide".equals(operation)) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {

                model.addAttribute("error", "Деление на ноль невозможно.");
                return "calculator";
            }
        }

        model.addAttribute("result", result);
        return "result";
    }
}