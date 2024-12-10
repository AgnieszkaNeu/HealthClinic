package com.example.HealthClinic.Mapper;

public interface myMapper<E,D>{
    E toEntity(D dto);
    D toDTO(E entity);
}

