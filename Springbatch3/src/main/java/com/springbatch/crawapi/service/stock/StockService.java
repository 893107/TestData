package com.springbatch.crawapi.service.stock;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.springbatch.crawapi.component.stock.JsoupComponent;
import com.springbatch.crawapi.domain.dto.stock.KospiStockDto;

@Service
@RequiredArgsConstructor
public class StockService {

  private final JsoupComponent jsoupComponent;

  public List<KospiStockDto> getKosPiStockList() {
    return jsoupComponent.getKosPiStockList();
  }
}
