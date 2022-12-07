package core;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivoUtils implements AutoCloseable{
    
    private final FileWriter writer;
    private final PrintWriter printWriter;

    public ArquivoUtils(String path) throws Exception {
        writer = new FileWriter(path);
        printWriter = new PrintWriter(writer);
    }

    public void escrever(String texto) throws Exception {
        printWriter.println(texto);
    }

    public void close() throws IOException {
        writer.close();
    }


}
