package com.ethandev.archiblock.archive.metadata;

import com.ethandev.archiblock.archive.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

import java.net.URI;
import java.util.List;

@Data
@AllArgsConstructor
public class Metadata {
    public final String name;
    public final List<Tag> tags;
    public final URI uri;
    public final DateTime utcCreationDateTime;
    public final DateTime utcFileDateTime;
    //hash du précédent dans la liste
    private final String previousHash;
    //hash de toute les infos de la metadata
    private final String hash;
}
