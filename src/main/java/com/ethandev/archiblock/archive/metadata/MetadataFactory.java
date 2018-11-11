package com.ethandev.archiblock.archive.metadata;

import java.io.File;

public interface MetadataFactory {
    Metadata buildMetadata(File file);
}
