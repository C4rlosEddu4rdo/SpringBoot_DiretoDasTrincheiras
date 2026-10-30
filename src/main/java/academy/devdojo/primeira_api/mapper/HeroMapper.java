package academy.devdojo.primeira_api.mapper;

import academy.devdojo.primeira_api.domain.Hero;
import academy.devdojo.primeira_api.dto.request.HeroPostRequest;
import academy.devdojo.primeira_api.dto.request.HeroPutRequest;
import academy.devdojo.primeira_api.dto.response.HeroResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HeroMapper {

   Hero toHero(HeroPostRequest hero);

   HeroResponse toHeroResponse(Hero hero);

   List<HeroResponse> toHeroResponseList(List<Hero> hero);

   Hero toHero(HeroPutRequest heroPutRequest);
}
