package savingbox.example.my_saving_box.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoinController {
    
    @GetMapping("/")
    public String index(){
        return "index"; // Vozvrat faila index.html is papki tamplates
    }
}
