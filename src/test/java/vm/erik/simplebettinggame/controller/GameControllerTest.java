package vm.erik.simplebettinggame.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import vm.erik.simplebettinggame.dto.PlayerDTO;
import vm.erik.simplebettinggame.mapper.PlayerMapper;
import vm.erik.simplebettinggame.model.Player;
import vm.erik.simplebettinggame.service.GameService;
import vm.erik.simplebettinggame.service.PlayerService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameController.class)
class GameControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    GameService gameService;

    @MockBean
    PlayerService playerService;
    @MockBean
    PlayerMapper playerMapper;

    PlayerDTO playerDTO;
    UUID playerId;

    @BeforeEach
    void setUp() {
        playerDTO = new PlayerDTO();
        playerDTO.setPlayerName("Test player");
        PlayerDTO savedPlayer = playerService.saveNewPlayer(playerDTO);
        Player playerToLoad = playerMapper.fromDTOToPlayer(savedPlayer);
        playerId = playerToLoad.getPlayerId();
    }

    @Test
    void playGame() throws Exception {


        mockMvc.perform(post("/game/"+playerId+"/40.5/50")
                        .accept(APPLICATION_JSON)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(playerDTO)))
                .andExpect(status().isOk());
    }
}
