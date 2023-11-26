package br.com.smart_br.consulta_cnpj.rest;

import br.com.smart_br.consulta_cnpj.model.Company;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@ApplicationScoped
public class CnpjWsRest {
    private final String URL_API = System.getenv("BASE_API_URL") + "company/%s";

    public Company get(String cnpj) throws Exception {
        if(cnpj == null || cnpj.isEmpty())
            return null;
        StringBuilder sb = new StringBuilder();
        new BufferedReader(new InputStreamReader(new URL(String.format(URL_API, cnpj)).openConnection().getInputStream()))
                .lines().forEach(l -> sb.append(l.trim()));
        return new ObjectMapper().readValue(sb.toString(), Company.class);
    }

    public boolean save(Company dto) throws Exception{
        URL url = new URL(String.format(URL_API, "save"));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String json = new ObjectMapper().writeValueAsString(dto);
        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            outputStream.writeBytes(json);
            outputStream.flush();
        }

        int responseCode = connection.getResponseCode();
        connection.disconnect();
        return responseCode == HttpURLConnection.HTTP_OK;
    }
}
