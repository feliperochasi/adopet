package br.com.feliperochasi.service;

import br.com.feliperochasi.client.ClientHttpConfiguration;
import br.com.feliperochasi.domain.Abrigo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbrigoServiceTest {

    private final ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);//mockar é simular um objeto (NAO FAZ A CHAMADA REAL)
    private final AbrigoService abrigoService = new AbrigoService(client);
    private final HttpResponse<String> response = mock(HttpResponse.class);
    private final Abrigo abrigo = new Abrigo("Teste", "61981880392","abrigo@teste.com");

    @Test
    public void deveVerificarSeDispararRequisicaoGetSeraChamado() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expectedAbrigosCadastrados = "Abrigos cadastrados:";
        String expectedIdNome = "0 - Teste";

        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        try {
            when(response.body()).thenReturn("[{"+abrigo.toString()+"}]");
            when(client.dispararRequiscaoGet(anyString())).thenReturn(response);

            abrigoService.listarAbrigo();

            printStream.flush();
            String[] lines = baos.toString().split(System.lineSeparator());

            String actualAbrigoCadastrados = lines[0];
            String actualIdENome = lines[1];

            Assertions.assertEquals(expectedAbrigosCadastrados, actualAbrigoCadastrados);
            Assertions.assertEquals(expectedIdNome, actualIdENome);
        } finally {
            System.setOut(originalOut);
        }
    }
}
