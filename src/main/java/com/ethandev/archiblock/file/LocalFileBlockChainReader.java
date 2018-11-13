package com.ethandev.archiblock.file;

import com.ethandev.archiblock.FileBlockChain;
import com.ethandev.archiblock.archive.metadata.Metadata;
import com.ethandev.archiblock.archive.metadata.MetadataFactory;
import com.ethandev.archiblock.blockchain.BlockChain;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class LocalFileBlockChainReader implements BlockChainReader {
    private final ObjectMapper objectMapper;
    private final File tempFile;
    private final MetadataFactory factory;

    public LocalFileBlockChainReader(File tempFile, MetadataFactory factory) {
        this.tempFile = tempFile;
        this.factory = factory;
        objectMapper = new ObjectMapper();
    }

    @Override
    public BlockChain<Metadata> read() throws IOException {
        ArrayList<Metadata> metaList = objectMapper.readValue(tempFile,ArrayListMeta.class);
        String lastHash;
        HashMap<String, Metadata> metaMapFiles = new HashMap<>();

        for (Metadata metadata : metaList) {
            metaMapFiles.put(metadata.getHash(),metadata);
        }

        return new FileBlockChain(metaMapFiles, lastHash, factory);
    }

    private static class ArrayListMeta extends ArrayList<Metadata>{
        public ArrayListMeta(int initialCapacity) {
            super(initialCapacity);
        }

        public ArrayListMeta() {
        }

        public ArrayListMeta(Collection<? extends Metadata> c) {
            super(c);
        }
    }
}
