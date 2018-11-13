package com.ethandev.archiblock.file;

import com.ethandev.archiblock.archive.metadata.Metadata;
import com.ethandev.archiblock.blockchain.BlockChain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LocalFileBlockChainSaver implements BlockChainSaver {
    private final ObjectMapper objectMapper;
    private File file;

    public LocalFileBlockChainSaver(File file) {
        this.file = file;
        objectMapper = new ObjectMapper();
    }

    private static void writeStringToFile(String value, File file)
            throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(value);
        printWriter.close();
    }

    @Override
    public void saveBlockChain(BlockChain<Metadata> fmBlock) throws IOException {
        ArrayList<Metadata> metadatas = new ArrayList<>(fmBlock.getAllData());
        try {
            String metaJson = objectMapper.writeValueAsString(metadatas);
            writeStringToFile(metaJson, file);
        } catch (JsonProcessingException e) {
            throw new IOException("Error on JSON serialization for data");
        }
    }
}
