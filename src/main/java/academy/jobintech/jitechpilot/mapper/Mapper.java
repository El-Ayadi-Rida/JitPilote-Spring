package academy.jobintech.jitechpilot.mapper;

public interface Mapper <E,D>{
    E toEntity(D dto);
    D toResponse(E entity);

}
