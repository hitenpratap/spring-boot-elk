package com.elk.todo.controller;

import com.elk.todo.commandObject.ToDoCO;
import com.elk.todo.domain.ToDo;
import com.elk.todo.repository.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToDoController.class);

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/todo/create")
    public String create() {
        LOGGER.info("Going to Open Create ToDo Page");
        return "/todo/create";
    }

    @PostMapping(value = "/todo/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(ToDoCO toDoCO) {
        ToDo toDo = new ToDo(toDoCO);
        toDoRepository.save(toDo);
        LOGGER.info("Created new Todo named => {}", toDoCO.getName());
        return "redirect:/todo/list";
    }

    @GetMapping(value = "/todo/list")
    public String list(Model model) {
        LOGGER.info("Fetching List of All Todo");
        model.addAttribute("todoList", toDoRepository.findAll());
        return "/todo/list";
    }

}
