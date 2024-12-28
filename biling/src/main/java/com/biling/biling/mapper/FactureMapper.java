package com.biling.biling.mapper;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.biling.biling.dto.FactureDto;
import com.biling.biling.entity.Facture;

@Mapper(componentModel = "spring")
public interface FactureMapper {

    // Mapping facture -> facureDto
    @Mapping(source = "dateFacture", target = "dateFacture")
    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "customerName", target = "customerName")
    FactureDto map(Facture entity);


    // Mapping List<facture> -> List<facureDto>
    List<FactureDto> map(List<Facture> entities);

    // Mapping facureDto -> facture
    @Mapping(source = "dateFacture", target = "dateFacture")
    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "customerName", target = "customerName")
    @Mapping(target = "produitItems", ignore = true)
    Facture unMap(FactureDto dto);

    // Mapping facureDto -> facture pour mise à jour
    @Mapping(source = "dateFacture", target = "dateFacture")
    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "customerName", target = "customerName")
    @Mapping(target = "produitItems", ignore = true)
    void updateEntityFromDto(@MappingTarget Facture entity, FactureDto dto);


}
