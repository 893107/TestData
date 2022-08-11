package com.springbatch.crawapi.controller.stock;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbatch.crawapi.domain.dto.stock.KospiStockDto;
import com.springbatch.crawapi.service.stock.StockService;

@RestController
@RequiredArgsConstructor
public class StockController {

  private final StockService stockService;

  @GetMapping("/kospi/all")
  public List<KospiStockDto> getKosPiStockList(HttpServletRequest request) {
    return stockService.getKosPiStockList();

  }
}
