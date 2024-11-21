package com.order.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.order.demo.dto.command.AddCommandDto;
import com.order.demo.model.Command;
import com.order.demo.model.OrderDetail;
import com.order.demo.routes.Route;
import com.order.demo.service.CommandService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(Route.command)
@RestController
public class CommandController {

    @Autowired
    CommandService commandService;

    @GetMapping("commands")
    public ResponseEntity<Page<Command>> getCommands(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Command> commands = this.commandService.getCommands(page, size);
        return ResponseEntity.ok().body(commands);
    }
   
  
    @PostMapping("create")
    public ResponseEntity<List<OrderDetail>> createCommand(@Valid @RequestBody AddCommandDto addCommandDto) {
        System.out.println(addCommandDto);
        List<OrderDetail> details = this.commandService.createCommands(addCommandDto);
        return ResponseEntity.ok().body(details);
    }

}
