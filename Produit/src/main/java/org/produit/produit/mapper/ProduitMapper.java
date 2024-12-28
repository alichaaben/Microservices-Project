package org.produit.produit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.produit.produit.dto.ProduitDto;
import org.produit.produit.entity.Produit;

import java.util.List;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduitMapper {

    @Mapping(source = "name",target = "name")
    @Mapping(source = "price",target = "price")
    @Mapping(source = "quantite",target = "quantite")
    ProduitDto map(Produit entity);

    List<ProduitDto> map(List<Produit> entities);

    @Mapping(source = "name",target = "name")
    @Mapping(source = "price",target = "price")
    @Mapping(source = "quantite",target = "quantite")
    Produit unMap(ProduitDto dto);

    @Mapping(source = "name",target = "name")
    @Mapping(source = "price",target = "price")
    @Mapping(source = "quantite",target = "quantite")
    void updateEntityFromDto(@MappingTarget Produit entity, ProduitDto dto);

}




