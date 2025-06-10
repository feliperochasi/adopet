package br.com.feliperochasi;

import br.com.feliperochasi.client.ClientHttpConfiguration;
import br.com.feliperochasi.service.AbrigoService;

import java.io.IOException;

public class ListarAbrigoCommand implements Command {

    @Override
    public void execute() {
        ClientHttpConfiguration client = new ClientHttpConfiguration();
        AbrigoService abrigoService = new AbrigoService(client);
        try {
            abrigoService.listarAbrigo();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
