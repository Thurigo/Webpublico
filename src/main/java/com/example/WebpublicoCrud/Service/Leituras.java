package com.example.WebpublicoCrud.Service;

import com.example.WebpublicoCrud.models.FisicaModel;
import com.example.WebpublicoCrud.repositories.FisicaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class Leituras {

    @Autowired
    FisicaRepositorio fisicaRepositorio;


    String nomeArquivo = "src\\main\\java\\com\\example\\WebpublicoCrud\\Webpublico.csv";
    public  ArrayList<String> listFolks() {
        ArrayList<String> lista = new ArrayList<>();
        File file = new File(nomeArquivo);

        try {
            // Abrir o leitor para ler o arquivo
            BufferedReader leitor = new BufferedReader(new FileReader(file));
            String linha;
            boolean primeiraLinha = true;

            if ( fisicaRepositorio.findAll().isEmpty()){
            while ((linha = leitor.readLine()) != null) {

                FisicaModel model = new FisicaModel();
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] partes = linha.split(",");
                if (partes.length > 0) {
                    model.setName(partes[1]);
                    model.setEmail(partes[3]);
                    model.setCpf(partes[4]);

                    fisicaRepositorio.save(model);


                    System.out.println(model.getName());
                }
            }
            }
            leitor.close();

        } catch(IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
