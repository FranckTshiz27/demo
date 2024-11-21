package com.order.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.order.demo.dto.command.AddCommandDto;
import com.order.demo.dto.detailOrder.DetailOrderDto;
import com.order.demo.model.Command;
import com.order.demo.model.OrderDetail;
import com.order.demo.model.Product;
import com.order.demo.repository.CommandRepository;
import com.order.demo.repository.OrderDetailRepository;

import jakarta.transaction.Transactional;

@Service
public class CommandService {

    @Autowired
    CommandRepository commandRepository;

    @Autowired
    ProductService productService;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Transactional
    public List<OrderDetail> createCommands(AddCommandDto addCommandDto) {

        Command command = new Command();
        command.setCreatedat(new Date());
       
        command = this.commandRepository.save(command);
        if (command != null) {
            List<OrderDetail> orderDetails = new ArrayList<>();
            for (DetailOrderDto orderDto : addCommandDto.getDetailOrderDtos()) {
                OrderDetail orderDetail = new OrderDetail();
                Product product = this.productService.getProduct(orderDto.getProduct_id());
                orderDetail.setCommand(command);
                orderDetail.setProduct(product);
                orderDetail.setQuantity(orderDto.getQuantity());
                orderDetails.add(orderDetail);
            }

            return this.orderDetailRepository.saveAll(orderDetails);
        }
        return new ArrayList<>();
    }

    @Transactional
    public Page<Command> getCommands(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.commandRepository.findAll(pageable);
    }
}
