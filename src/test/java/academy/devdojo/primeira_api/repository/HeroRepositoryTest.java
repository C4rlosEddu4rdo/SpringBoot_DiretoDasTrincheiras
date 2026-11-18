package academy.devdojo.primeira_api.repository;

import academy.devdojo.primeira_api.data.HeroData;
import academy.devdojo.primeira_api.domain.Hero;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HeroRepositoryTest {
    @InjectMocks
    private HeroRepository heroRepository;
    @Mock
    private HeroData heroData;
    private final List<Hero> heroesList = new ArrayList<>();

    @BeforeEach
    void init(){
        var stu = new Hero(2L,"Stu","Avanço com rastro de fogo");
        var piper = new Hero(1L,"Piper","Deixar bombas ao pular de paraquedas");
        heroesList.addAll(List.of(piper,stu));
    }

    @Test
    @Order(1)
    @DisplayName("Listar Todos os heróis")
    void listAll_RetonarTodosHeroes_QuandoBemSucedido() {
        BDDMockito.when(heroData.getHeroes()).thenReturn(heroesList);
        var listAll = heroRepository.listAll();
        Assertions.assertThat(listAll).isNotNull().hasSize(heroesList.size());
    }
    @Test
    @Order(2)
    @DisplayName("Listar Nomes Passados Pelo Parâmetro")
    void findByName_RetorneListaDeNomesRequisitados_QuandoBemSucedido() {
        BDDMockito.when(heroData.getHeroes()).thenReturn(heroesList);
        var heroExpected = heroesList.getFirst();
        var heroByName = heroRepository.findByName(heroExpected.getName());
        Assertions.assertThat(heroByName).isNotNull().contains(heroExpected);
    }
    @Test
    @Order(3)
    @DisplayName("Lista vazia quando parâmetro for nulo")
    void findByNameEmpty_RetorneListaDeNomesVazia_QuandoParametroSerNulo(){
        BDDMockito.when(heroData.getHeroes()).thenReturn(heroesList);
        var heroByName = heroRepository.findByName(null);
        Assertions.assertThat(heroByName).isNotNull().isEmpty();
    }
    @Test
    @Order(4)
    @DisplayName("Encontrar Hero por id")
    void findByID_RetorneHero_QuandoBemSucedido() {
        BDDMockito.when(heroData.getHeroes()).thenReturn(heroesList);
        var heroFirstExpected = heroesList.getFirst();
        var hero = heroRepository.findById(heroFirstExpected.getId());
        Assertions.assertThat(hero).isPresent().contains(heroFirstExpected);
    }
    @Test
    @Order(5)
    @DisplayName("Salvar quando criar Hero")
    void save_CriarHero_QuandoBemSucessedido() {
        BDDMockito.when(heroData.getHeroes()).thenReturn(heroesList);
        var heroSave = Hero.builder().id(99L).name(" ").descriptionUltPower(" ").build();
        var save = heroRepository.save(heroSave);
        Assertions.assertThat(save).isEqualTo(heroSave).hasNoNullFieldsOrProperties();
        var byIdOptional = heroRepository.findById(heroSave.getId());
        Assertions.assertThat(byIdOptional).isPresent().contains(heroSave);
    }

    @Test
    @Order(6)
    @DisplayName("Deletar Hero")
    void delete_DeletarHero_QuandoBemSucessedido() {
        BDDMockito.when(heroData.getHeroes()).thenReturn(heroesList);
        var first = heroesList.getFirst();
        heroRepository.delete(first);
        Assertions.assertThat(heroesList).isNotEmpty().doesNotContain(first);
    }
    @Test
    @Order(7)
    @DisplayName("Atualizar Hero")
    void update_DeletarHero_QuandoBemSucessedido() {
        BDDMockito.when(heroData.getHeroes()).thenReturn(heroesList);
        var first = heroesList.getFirst();
        first.setName("NovoName");
        heroRepository.update(first);
        Assertions.assertThat(heroesList).contains(first);
        var heroByIdOptional  = heroRepository.findById(first.getId());
        Assertions.assertThat(heroByIdOptional).isPresent();
        Assertions.assertThat(heroByIdOptional.get().getName()).isEqualTo(first.getName());
    }
    


}