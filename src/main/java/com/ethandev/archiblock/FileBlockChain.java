package com.ethandev.archiblock;

import com.ethandev.archiblock.archive.metadata.Metadata;
import com.ethandev.archiblock.archive.metadata.MetadataFactory;
import com.ethandev.archiblock.blockchain.BlockChain;

import java.io.File;
import java.util.HashMap;

public class FileBlockChain implements BlockChain<Metadata> {

    private HashMap<String, Metadata> metaFiles;
    private MetadataFactory metadataFactory;

    public FileBlockChain(MetadataFactory metadataFactory) {
        this.metadataFactory = metadataFactory;
        this.metaFiles = new HashMap<>();
    }

    @Override
    public String addFile(File file) {
        Metadata metadata = metadataFactory.buildMetadata(file);
        String hash = metadata.getHash();
        metaFiles.put(metadata.getHash(), metadata);
        return hash;
    }

    @Override
    public File getFile(String hash) {
        Metadata metadata = metaFiles.get(hash);
        return new File(metadata.uri);
    }
}
