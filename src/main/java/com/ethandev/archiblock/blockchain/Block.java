package com.ethandev.archiblock.blockchain;

public interface Block<T> {
    Block<T> getNext();
    Block<T> getPrevious();
    String getId();
}