package com.ethandev.archiblock;

import com.ethandev.archiblock.archive.metadata.FileMetadataFactory;
import com.ethandev.archiblock.archive.metadata.Metadata;
import com.ethandev.archiblock.blockchain.BlockChain;
import com.ethandev.archiblock.file.BlockChainSaver;
import com.ethandev.archiblock.file.LocalFileBlockChainSaver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class MainTest {
    private static final File fileTest = new File(MainTest.class.getClassLoader().getResource("files/test.json").getFile());
    private static final File fileTest2 = new File(MainTest.class.getClassLoader().getResource("files/test2.json").getFile());

    @Test
    void createBlockChain() {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
    }

    @Test
    void addFileAndGetInBlockChain() throws AlreadyExistFileException {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
        Metadata metadata = fmBlock.addFile(fileTest);

        File resp = fmBlock.getFile(metadata.getHash());
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
    void testHashDiffBetweenFile() throws AlreadyExistFileException {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
        String hash = fmBlock.addFile(fileTest).getHash();
        String hash2 = fmBlock.addFile(fileTest2).getHash();
        Assertions.assertNotEquals(hash, hash2);
    }

    @Test
    void testHashSameEveryTime() throws AlreadyExistFileException {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
        BlockChain<Metadata> fmBlock2 = new FileBlockChain(new FileMetadataFactory());
        String hash = fmBlock.addFile(fileTest).getHash();
        String hash2 = fmBlock2.addFile(fileTest).getHash();
        Assertions.assertEquals(hash, hash2);
    }

    @Test
    void testAddAndChain() throws AlreadyExistFileException {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
        Metadata metadata = fmBlock.addFile(fileTest);
        Metadata metadata2 = fmBlock.addFile(fileTest2);
        Assertions.assertEquals(metadata.getHash(),metadata2.getPreviousHash());
    }

    @Test
    void testGetDateTimeFileAddAndChain() throws AlreadyExistFileException {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
        Metadata metadata = fmBlock.addFile(fileTest);
        Metadata metadata2 = fmBlock.addFile(fileTest2);
        Assertions.assertEquals(metadata.getHash(), metadata2.getPreviousHash());
    }

    @Test
    void testSaveAndLoadBlockChain() throws AlreadyExistFileException, IOException {
        BlockChain<Metadata> fmBlock = new FileBlockChain(new FileMetadataFactory());
        Metadata metadata = fmBlock.addFile(fileTest);
        Metadata metadata2 = fmBlock.addFile(fileTest2);

        File tempFile = File.createTempFile("testSaveAndLoadBlockChain", "");
        BlockChainSaver saver = new LocalFileBlockChainSaver(tempFile);
        saver.saveBlockChain(fmBlock);

        //TODO read file metadata
        
        tempFile.delete();
    }

    //TODO test de robustesse du hash en changeant des valeurs des metadata


}