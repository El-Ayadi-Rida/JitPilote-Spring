package academy.jobintech.jitechpilot.mapper;

public interface Mapper <Entity,Res,Req>{
    Entity toEntity(Req request);
    Res toResponse(Entity entity);

}
