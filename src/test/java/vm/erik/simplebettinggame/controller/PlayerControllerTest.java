package vm.erik.simplebettinggame.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import vm.erik.simplebettinggame.dto.PlayerDTO;
import vm.erik.simplebettinggame.service.PlayerService;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlayerController.class)
class PlayerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    PlayerService playerService;

    @Test
    void savePlayer() throws Exception {

        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlayerName("Test payer");

        mockMvc.perform(post("/player")
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(playerDTO)))
                .andExpect(status().isCreated());
    }
}
