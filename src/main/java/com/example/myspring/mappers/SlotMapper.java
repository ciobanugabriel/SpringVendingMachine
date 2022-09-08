package com.example.myspring.mappers;

import com.example.myspring.entities.Slot;
import com.example.myspring.model.SlotDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = { EnumMapper.class})
public interface SlotMapper {

    @Mapping(source = "quantity", target = "stock")
    Slot slotDtoToSlot(SlotDto slotDto);

    List<Slot> slotDtosToSlots(List<SlotDto> slotDtos);


    @Mapping(source = "stock", target = "quantity")
    SlotDto slotToSlotDto(Slot slot);

    List<SlotDto> slotsToSlotDtos(List<Slot> slots);
}
