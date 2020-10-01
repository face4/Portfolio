package com.app.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SolvedController {

    @GetMapping("/solved")
    public String solved(Model model){
        model.addAttribute("solved", 833);
        return "index";
    }
}
