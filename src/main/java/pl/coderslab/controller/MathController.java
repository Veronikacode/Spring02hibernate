package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.service.MathService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    @GetMapping("/factorial")
    public long factorial(@RequestParam int n) {
        return mathService.factorial(n);
    }

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        return mathService.add(a, b);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        return mathService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        return mathService.multiply(a, b);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        return mathService.divide(a, b);
    }
}
