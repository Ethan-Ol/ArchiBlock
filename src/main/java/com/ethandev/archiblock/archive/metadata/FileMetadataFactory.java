package com.ethandev.archiblock.archive.metadata;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.net.URI;

public class FileMetadataFactory implements MetadataFactory {

    @Override
    public Metadata buildMetadata(File file, String previousHash) {
        URI uri = file.toURI();
        String hash = DigestUtils.sha256Hex(uri.toString());
        return new Metadata(null, null, uri, null, null, previousHash, hash);
    }
}
