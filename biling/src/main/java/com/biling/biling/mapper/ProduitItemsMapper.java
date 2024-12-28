package com.biling.biling.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.biling.biling.entity.ProduitItems;
import com.biling.biling.dto.ProduitItemsDto;

@Mapper(componentModel = "spring")
public interface ProduitItemsMapper {


    // Mapping ProduitItems -> ProduitItemsDto
    @Mapping(source = "produitId", target = "produitId")
    @Mapping(source = "facture", target = "facture")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    ProduitItemsDto map(ProduitItems entity);


    // Mapping List<ProduitItems> -> List<ProduitItemsDto>
    List<ProduitItemsDto> map(List<ProduitItems> entities);

    // Mapping ProduitItemsDto -> ProduitItems
    @Mapping(source = "produitId", target = "produitId")
    @Mapping(source = "facture", target = "facture")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    ProduitItems unMap(ProduitItemsDto dto);

    // Mapping ProduitItemsDto -> ProduitItems pour mise à jour
    @Mapping(source = "produitId", target = "produitId")
    @Mapping(source = "facture", target = "facture")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    void updateEntityFromDto(@MappingTarget ProduitItems entity, ProduitItemsDto dto);


}
