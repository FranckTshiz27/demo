package com.order.demo.dto.command;

import java.util.List;

import com.order.demo.dto.detailOrder.DetailOrderDto;

import lombok.Data;

@Data
public class AddCommandDto {

    List<DetailOrderDto> detailOrderDtos;

}
