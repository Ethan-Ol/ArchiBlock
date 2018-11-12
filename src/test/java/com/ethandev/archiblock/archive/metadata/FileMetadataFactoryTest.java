package com.ethandev.archiblock.archive.metadata;

import org.junit.jupiter.api.Test;

import java.io.File;

class FileMetadataFactoryTest {

    private static final File testFile = new File(FileMetadataFactoryTest.class.getClassLoader().getResource("files/test.json").getFile());

    @Test
    void testBuildMetadata() {
        FileMetadataFactory factory = new FileMetadataFactory();
        Metadata metadata = factory.buildMetadata(testFile, null);
    }
}