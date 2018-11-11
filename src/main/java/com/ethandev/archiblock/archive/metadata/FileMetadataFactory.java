package com.ethandev.archiblock.archive.metadata;

import java.io.File;

public class FileMetadataFactory implements MetadataFactory {

    @Override
    public Metadata buildMetadata(File file) {
        return new Metadata(null, null, file.toURI(), null, null, null, null);
    }
}
