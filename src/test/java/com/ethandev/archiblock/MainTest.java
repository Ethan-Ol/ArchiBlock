package com.ethandev.archiblock;

import com.ethandev.archiblock.archive.metadata.FileMetadataFactory;
import com.ethandev.archiblock.archive.metadata.Metadata;
import com.ethandev.archiblock.blockchain.BlockChain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class MainTest {
    private static final File fileTest = new File(MainTest.class.getClassLoader().getResource("files/test.json").getFile());
    private static final File fileTest2 = new File(MainTest.class.getClassLoader().getResource("files/test2.json").getFile());

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
    }

    @Test
    void testAddSameFileError() {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
        //TODO : improve this test with a modification of file
        try {
            fmBlock.addFile(fileTest);
            fmBlock.addFile(fileTest);
            Assertions.fail("Impossible to add the same file second time.");
        } catch (Exception e) {

        }
    }

    @Test
    void testHashDiffBetweenFile() {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
        String hash = fmBlock.addFile(fileTest);
        String hash2 = fmBlock.addFile(fileTest2);

        Assertions.assertNotEquals(hash, hash2);
    }
}