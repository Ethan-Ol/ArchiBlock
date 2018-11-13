package com.ethandev.archiblock.file;

import com.ethandev.archiblock.archive.metadata.Metadata;
import com.ethandev.archiblock.blockchain.BlockChain;

import java.io.IOException;

public interface BlockChainSaver {
    void saveBlockChain(BlockChain<Metadata> fmBlock) throws IOException;
}
