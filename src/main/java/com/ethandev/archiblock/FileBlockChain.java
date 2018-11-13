package com.ethandev.archiblock;

import com.ethandev.archiblock.archive.metadata.Metadata;
import com.ethandev.archiblock.archive.metadata.MetadataFactory;
import com.ethandev.archiblock.blockchain.BlockChain;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;

public class FileBlockChain implements BlockChain<Metadata> {

    private HashMap<String, Metadata> metaFiles;
    private String lastHash;
    private MetadataFactory metadataFactory;

    public FileBlockChain(MetadataFactory metadataFactory) {
        this.metadataFactory = metadataFactory;
        this.metaFiles = new HashMap<>();
        lastHash = null;
    }

    public FileBlockChain(HashMap<String, Metadata> metaFiles, String lastHash, MetadataFactory metadataFactory) {
        this.metaFiles = metaFiles;
        this.lastHash = lastHash;
        this.metadataFactory = metadataFactory;
    }

    @Override
    public Metadata addFile(File file) throws AlreadyExistFileException {
        Metadata metadata = metadataFactory.buildMetadata(file,lastHash);
        String hash = metadata.getHash();
        if (!metaFiles.containsKey(hash)) {
            metaFiles.put(hash, metadata);
            lastHash = hash;
            return metadata;
        } else {
            throw new AlreadyExistFileException("File " + file.getName() + " already exist in FileBlockChain.");
        }
    }

    @Override
    public File getFile(String hash) {
        Metadata metadata = metaFiles.get(hash);
        return new File(metadata.uri);
    }

    @Override
    public Collection<Metadata> getAllData() {
        return metaFiles.values();
    }
}
