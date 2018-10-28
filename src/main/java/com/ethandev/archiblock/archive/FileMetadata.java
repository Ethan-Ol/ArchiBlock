package com.ethandev.archiblock.archive;

import lombok.Data;
import org.joda.time.DateTime;

import java.net.URI;
import java.util.List;

@Data
public class FileMetadata {
    public String name;
    public List<Tag> tags;
    public URI uri;
    public DateTime utcCreationDateTime;
    public DateTime utcFileDateTime;
    //hash du précédent dans la liste
    public String previousHash;
    //hash de toute les infos de la metadata
    public String hash;
}
