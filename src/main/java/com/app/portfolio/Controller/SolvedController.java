package com.app.portfolio.Controller;

import com.app.portfolio.Service.FetchSolvedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SolvedController {

    @Autowired
    private FetchSolvedService fetchSolvedService;

    @GetMapping("/")
    public String solved(Model model){
        model.addAttribute("yukisolved", fetchSolvedService.getYukicoderSolved());
        model.addAttribute("codeforcessolved", fetchSolvedService.getCodeforcesSolved());
        model.addAttribute("atcodersolved", fetchSolvedService.getAtCoderSolved());
        model.addAttribute("aojsolved",fetchSolvedService.getAojSolved());
        return "index";
    }
}