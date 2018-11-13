package com.ethandev.archiblock.file;

import com.ethandev.archiblock.archive.metadata.Metadata;
import com.ethandev.archiblock.blockchain.BlockChain;

import java.io.IOException;

public interface BlockChainReader {
    BlockChain<Metadata> read() throws IOException;
}
