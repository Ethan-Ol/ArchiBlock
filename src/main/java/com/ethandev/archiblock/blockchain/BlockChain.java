package com.ethandev.archiblock.blockchain;

import com.ethandev.archiblock.AlreadyExistFileException;
import com.ethandev.archiblock.archive.metadata.Metadata;

import java.io.File;

public interface BlockChain<T> {
    Metadata addFile(File file) throws AlreadyExistFileException;

    File getFile(String hash);
}
