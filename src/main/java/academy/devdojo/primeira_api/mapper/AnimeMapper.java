package academy.devdojo.primeira_api.mapper;

import academy.devdojo.primeira_api.domain.Anime;
import academy.devdojo.primeira_api.dto.request.AnimePostRequest;
import academy.devdojo.primeira_api.dto.response.AnimeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimeMapper {
    Anime toAnime(AnimePostRequest request);
    AnimeResponse toAnimeResponse(Anime anime);
    List<AnimeResponse> toAnimeResponseList(List<Anime> animes);
}
