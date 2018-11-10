package com.ethandev.archiblock.blockchain;

import java.io.File;

public interface BlockChain<T> {
    String addFile(File file);

    File getFile(String hash);
}
