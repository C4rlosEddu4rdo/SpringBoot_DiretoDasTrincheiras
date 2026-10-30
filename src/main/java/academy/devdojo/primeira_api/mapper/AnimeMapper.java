package academy.devdojo.primeira_api.mapper;

import academy.devdojo.primeira_api.domain.Anime;
import academy.devdojo.primeira_api.dto.request.AnimePostRequest;
import academy.devdojo.primeira_api.dto.request.AnimePutRequest;
import academy.devdojo.primeira_api.dto.response.AnimeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnimeMapper {
    AnimeResponse toAnimeResponse(Anime anime);
    Anime toAnime(AnimePostRequest animePostRequest);
    Anime toAnime(AnimePutRequest animePutRequest);

    List<AnimeResponse> toAnimeResponseList(List<Anime> animes);
}
