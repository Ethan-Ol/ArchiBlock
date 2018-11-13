package com.ethandev.archiblock.archive.metadata;

import com.ethandev.archiblock.archive.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.net.URI;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Metadata {
    public String name;
    public List<Tag> tags;
    public URI uri;
    public DateTime utcCreationDateTime;
    public DateTime utcFileDateTime;
    //hash du précédent dans la liste
    private String previousHash;
    //hash de toute les infos de la metadata
    private String hash;
}
