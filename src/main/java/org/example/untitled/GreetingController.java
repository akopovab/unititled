package org.example.untitled;

import org.example.untitled.domain.Message.Message;
import org.example.untitled.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo MessageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name
            , Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<org.example.untitled.domain.Message.Message> messages = MessageRepo.findAll();
        model.put("messages", messages);
                return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {

        org.example.untitled.domain.Message.Message message = new Message(text, tag);

        MessageRepo.save(message);
        Iterable<org.example.untitled.domain.Message.Message> messages = MessageRepo.findAll();
        model.put("messages", messages);
        return  "main" ;
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<org.example.untitled.domain.Message.Message> messages;
        if (filter !=null && !filter.isEmpty()) {
            messages = MessageRepo.findByTag(filter);
        } else{
            messages = MessageRepo.findAll();
        }

        model.put("messages", messages);
        return  "main" ;
    }
    }

