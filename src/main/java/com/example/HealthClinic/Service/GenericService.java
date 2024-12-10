package com.example.HealthClinic.Service;

import com.example.HealthClinic.Mapper.myMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GenericService<E,D> {

    private final JpaRepository<E,Long> repository;
    private final myMapper<E,D> mapper;

    public GenericService(JpaRepository<E, Long> repository, myMapper<E,D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void save(D DTO){
        repository.save(mapper.toEntity(DTO));
    }

    public List<D> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public D findById(Long id){
        Optional<E> optionalEntity = repository.findById(id);

        if (optionalEntity.isPresent()) {
            E entity = optionalEntity.get();
            return mapper.toDTO(entity);
        } else {
            System.out.println("Entity with id: " + id + " does not exist.");
            return null;
        }
    }

    public void delete(Long id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            System.out.println("Entity with id: " + id + " does not exist.");
        }
    }
    public abstract void update(Long id, D DTO);
}