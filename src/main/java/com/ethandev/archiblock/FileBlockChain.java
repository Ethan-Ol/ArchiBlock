package com.ethandev.archiblock;

import com.ethandev.archiblock.archive.FileMetadata;
import com.ethandev.archiblock.blockchain.BlockChain;

import java.io.File;

public class FileBlockChain implements BlockChain<FileMetadata> {
    @Override
    public String addFile(File file) {

        return null;
    }

    @Override
    public File getFile(String hash) {
        return null;
    }
}
