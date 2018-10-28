package com.ethandev.archiblock.archive.local;

import com.ethandev.archiblock.archive.Archive;
import com.ethandev.archiblock.archive.FileMetadata;
import com.ethandev.archiblock.archive.Tag;
import org.joda.time.DateTime;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LocalArchive implements Archive {

    ArrayList<FileMetadata> archiveMetadata;

    public LocalArchive(Path rootDirectory) {
        //load file metadata
    }

    @Override
    public List<FileMetadata> getFiles() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Tag> getTags() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addFile(File file, List<Tag> tags, DateTime utcDateFile) {
        throw new UnsupportedOperationException();
    }
}
