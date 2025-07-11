package br.edu.ifpb.gestaobibliotecadigital.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador {

    /**
     * Serializa um objeto e o escreve em um arquivo.
     *
     * @param caminho O caminho do arquivo onde o objeto será salvo.
     * @param objetoASalvar O objeto a ser salvo.
     * @throws FileNotFoundException Se o arquivo não for encontrado.
     * @throws IOException Se ocorrer um erro de entrada/saída.
     */
    public static void escrever(String caminho, Object objetoASalvar)
            throws FileNotFoundException, IOException {

        try (FileOutputStream FileOutput = new FileOutputStream(caminho); ObjectOutputStream ObjectOutput = new ObjectOutputStream(FileOutput)) {
            ObjectOutput.writeObject(objetoASalvar);
        }
    }

    /**
     * Lê um objeto de um arquivo e desserializa.
     *
     * @param caminho O caminho do arquivo de onde o objeto será lido.
     * @throws FileNotFoundException Se o arquivo não for encontrado.
     * @throws IOException Se ocorrer um erro de entrada/saída.
     * @throws ClassNotFoundException Se a classe do objeto não for encontrada.
     * @return O objeto lido do arquivo.
     */
    public static Object ler(String caminho)
            throws FileNotFoundException, IOException, ClassNotFoundException {

        try (FileInputStream fileInput = new FileInputStream(caminho); ObjectInputStream ObjectInput = new ObjectInputStream(fileInput)) {
            return ObjectInput.readObject();
        }
    }
}
