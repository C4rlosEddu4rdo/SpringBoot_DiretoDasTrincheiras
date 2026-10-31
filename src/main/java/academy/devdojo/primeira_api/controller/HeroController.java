package academy.devdojo.primeira_api.controller;

import academy.devdojo.primeira_api.domain.Hero;
import academy.devdojo.primeira_api.dto.request.HeroPostRequest;
import academy.devdojo.primeira_api.dto.request.HeroPutRequest;
import academy.devdojo.primeira_api.dto.response.HeroResponse;
import academy.devdojo.primeira_api.mapper.HeroMapper;
import academy.devdojo.primeira_api.service.HeroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/hero")
public class HeroController{
    private final HeroService service;
    private final HeroMapper mapper;

    @GetMapping()
    public ResponseEntity<List<HeroResponse>> listAllOrFindByName(@RequestParam(required = false) String name){
        log.info("Solitação recebida para listar todos os heroes ou encontrar por nome {}",name);
        var hero = service.listAllOrFindByName(name);
        var heroResponseList = mapper.toHeroResponseList(hero);
        return ResponseEntity.ok(heroResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroResponse> findById(@PathVariable Long id){
        log.debug("Solitação para achar Hero por id {}",id);
        var heroId = service.findByIdOrElseThrow(id);
        var heroResponse = mapper.toHeroResponse(heroId);
        return ResponseEntity.ok(heroResponse);
    }

    @PostMapping()
    public ResponseEntity<HeroResponse> save(@RequestBody HeroPostRequest heroPostRequest){
        log.debug("Solicitação para adicionar novo Hero {}", heroPostRequest);
        Hero hero = mapper.toHero(heroPostRequest);
        Hero heroSaved = service.save(hero);
        var heroResponse = mapper.toHeroResponse(heroSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(heroResponse);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        log.debug("Solicitação para deletar Hero por id{}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody HeroPutRequest heroPutRequest){
        log.debug("Atualizando Hero por id {}", heroPutRequest);
        Hero hero = mapper.toHero(heroPutRequest);
        service.update(hero);
        return ResponseEntity.noContent().build();
    }


}
