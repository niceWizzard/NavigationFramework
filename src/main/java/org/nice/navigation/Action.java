package org.nice.navigation;

public interface Action<T> {
    void invoke(T obj);
}
