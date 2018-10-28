package com.ethandev.archiblock.archive;

import org.joda.time.DateTime;

import java.io.File;
import java.util.List;

public interface Archive {
    List<FileMetadata> getFiles();
    List<Tag> getTags();
    void addFile(File file, List<Tag> tags, DateTime utcDateFile);
}
