
package com.mycompany.calculadoramvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @author francisco.marquez
 */
@Controller
public class CalculadoraController {
    
    @Autowired
    CurrentValue cv;
    
    @GetMapping("/add")
    public String add(@RequestParam(name="number", required=false, defaultValue="0") String valor, Model model){
        cv.setCurrentValue(cv.getCurrentValue() + Double.parseDouble(valor));   
        model.addAttribute("currval", cv.getCurrentValue());
        return "calculadora";
    }
    
     @GetMapping("/mult")
    public String mult(@RequestParam(name="number", required=false, defaultValue="0") String valor, Model model){
       
        cv.setCurrentValue(cv.getCurrentValue()  * Double.parseDouble(valor));
        model.addAttribute("currval", cv.getCurrentValue());
        return "calculadora";
    }
    
    @GetMapping("/div")
    public String div(@RequestParam(name="number", required=false, defaultValue="0") String valor, Model model){
       
        cv.setCurrentValue(cv.getCurrentValue()  / Double.parseDouble(valor));
        model.addAttribute("currval", cv.getCurrentValue());
        return "calculadora";
    }
        
    @GetMapping("/rest")
    public String rest(@RequestParam(name="number", required=false, defaultValue="0") String valor, Model model){
        
        cv.setCurrentValue(cv.getCurrentValue()  - Double.parseDouble(valor));
        model.addAttribute("currval", cv.getCurrentValue());
        return "calculadora";
        
    }
    
    @GetMapping("/calc")
    public String defaultCalt(Model model){
        model.addAttribute(0);
                
        return "calculadora";
    }
    
}
