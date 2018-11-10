package com.ethandev.archiblock;

import com.ethandev.archiblock.archive.FileMetadata;
import com.ethandev.archiblock.blockchain.BlockChain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URI;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void createBlockChain() {
        BlockChain<FileMetadata> fmBlock = new FileBlockChain();
    }

    @Test
    void addFileAndGetInBlockChain() {
        File origin = new File(this.getClass().getClassLoader().getResource("file/test.json").getFile());

        BlockChain<FileMetadata> fmBlock = new FileBlockChain();
        String hash = fmBlock.addFile(origin);

        File resp = fmBlock.getFile(hash);
        Assertions.assertEquals(origin,resp);
        //TODO correct this
    }
}