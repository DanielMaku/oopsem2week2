package ie.atu.sem2week2;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping
public class RequestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/greet/{name}")
    public String greetByName(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/details")
    public String details(@RequestParam String name, @RequestParam Integer age) {
        return "Hello " + name + " " + age;
    }

    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person("Daniel", 18);
        return person;
    }

    @GetMapping("/calulator")
    public Map<String, Object> calulator(@RequestParam double num1, @RequestParam double num2, @RequestParam String choice) {
        Map<String, Object> response = new HashMap<>();
        response.put("operation", choice);

        double result;

        switch (choice) {

            case "add":
                result = num1 + num2;
                response.put("answer is", result);
                break;

            case "subtract":
                result = num1 - num2;
                response.put("answer is", result);
                break;

            case "multiply":
                result = num1 * num2;
                response.put("answer is", result);
                break;

            case "divide":

                if (num2 == 0) {
                    response.put("error", "cant divide by 0");
                } else {
                    result = num1 / num2;
                    response.put("answer is", result);
                    break;
                }

            default:
                response.put("error", "invalid choice");
                break;
        }
        return response;
    }
}
