package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/")
@ResponseBody
public class HelloController {

    @PostMapping("hello")
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }
    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        } else if (l.equals("french")) {
            greeting = "Bonjourno";
        } else if (l.equals("spanish")) {
            greeting = "Hola";
        } else if (l.equals("german")) {
            greeting = "Hallo";
        }
        return greeting + " " + n;
    }


       @GetMapping("form")
       @ResponseBody
                public String greetForm() {
                  return "<html>" +
                    "<body>" +
                    "<form action = '/hello' method = 'post'>" +
                    "<input type = 'text' name = 'name'>" +
                    //"<input type = 'text' language = 'language'>" +
                          "<select name = 'language'>" +
                          "<option value = 'english'>English</option>" +
                          "<option value = 'french'>French</option>" +
                          "<option value = 'spanish'>Spanish</option>" +
                          "<option value = 'german'>German</option>" +
                    "<input type = 'submit' value = 'Greet Me!'>" +
                    "</form>" +
                    "</body>" +
                    "</html>";
        }
    }

