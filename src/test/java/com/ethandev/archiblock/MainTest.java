package com.ethandev.archiblock;

import com.ethandev.archiblock.archive.metadata.FileMetadataFactory;
import com.ethandev.archiblock.archive.metadata.Metadata;
import com.ethandev.archiblock.blockchain.BlockChain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class MainTest {
    private static final File fileTest = new File(MainTest.class.getClassLoader().getResource("files/test.json").getFile());

    @Test
    void createBlockChain() {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
    }

    @Test
    void addFileAndGetInBlockChain() {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
        String hash = fmBlock.addFile(fileTest);

        File resp = fmBlock.getFile(hash);
        Assertions.assertEquals(fileTest, resp);
        //TODO correct this
    }
}