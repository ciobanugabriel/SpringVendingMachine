package com.example.myspring;

import com.example.myspring.enums.SlotType;
import com.example.myspring.model.ProductsDto;
import com.example.myspring.service.VendingMachineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MyspringApplicationTests {
	@Autowired
	VendingMachineService vendingMachineServiceTest ;

	@Test
	void contextLoads() {
		List<ProductsDto> productsDto = new ArrayList<>();
		ProductsDto productDto = new ProductsDto();
		productDto.setQuantity(2);
		//productDto.setSlotCode(SlotType.A2);
		productsDto.add(productDto);
		//System.out.println(vendingMachineServiceTest.buyProducts("",productsDto));
	}

}
