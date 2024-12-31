package com.darlanmarangoni.financeapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankStatementController {

    @GetMapping("/bankStatement")
    public String bankStatement(Model model) {
        model.addAttribute("message", "Hello World Extrato");
        return "bankStatement";
    }
}
