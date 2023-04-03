package vm.erik.simplebettinggame.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import vm.erik.simplebettinggame.dto.PlayerDTO;
import vm.erik.simplebettinggame.mapper.PlayerMapper;
import vm.erik.simplebettinggame.model.Player;
import vm.erik.simplebettinggame.repository.PlayerRepository;
import vm.erik.simplebettinggame.service.implementation.PlayerServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

class PlayerServiceTest {


    private PlayerServiceImpl underTest;
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private PlayerRepository playerRepository;

    Player player;

    @BeforeEach
    void setUp() {
        underTest = new PlayerServiceImpl(playerMapper, playerRepository);
        player = new Player();
        player.setPlayerName("Test name");
    }

    @AfterEach
    void tearDown() {
        playerRepository.deleteAll();
    }

    @Test
    void whenSaveNewPlayerThenReturnPlayer() {

        Mockito.when(playerRepository.save(any(Player.class))).thenReturn(new Player());

        PlayerDTO createdPlayer = underTest.saveNewPlayer(playerMapper.fromPlayerToDTO(player));

        assertThat(createdPlayer.getPlayerName()).isSameAs(player.getPlayerName());


    }

    @Test
    void loadPlayerById() {

        Player playerToLoad = new Player();
        playerToLoad.setPlayerName("Test");
        playerRepository.save(playerToLoad);

        boolean loadSuccessful = underTest.loadPlayerById(playerToLoad.getPlayerId()).equals(playerToLoad);

        assertTrue(loadSuccessful);

    }

    @Test
    void updatePlayer() {
    }
}
