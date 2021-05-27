package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
    public class HelloController {

        //Handles request at path /hello
    /*@GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }*/
        @GetMapping("goodbye")
        @ResponseBody
        public String goodBye(){
            return "Goodbye, Spring!";
        }

        //Handles request of the form /hello?name=LaunchCode
        //@GetMapping("hello")
        //@PostMapping("hello")
        @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
        @ResponseBody
        public String helloWithQueryParam(@RequestParam String name) {
            return "Hello, " + name + "!";
        }

        // Handles requests of the form /hello/LaunchCode
        // Path parameter to make dynamic request
        @GetMapping("hello/{name}")
        @ResponseBody
        public String helloWithPathParam(@PathVariable String name){
            return "Hello "+ name + "!";
        }

        @GetMapping("form")
        @ResponseBody
        public String helloForm() {
            return "<html>" +
                    "<body>" +
                    "<form action='hello' method='post'>" + // submit a request to /hello
                    "<input type='text' name='name'>" +
                    "<input type='submit' value='Greet me!'>" +
                    "</form>" +
                    "</body>" +
                    "</html>";
        }
    }
