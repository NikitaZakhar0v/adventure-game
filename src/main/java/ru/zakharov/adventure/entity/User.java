package ru.zakharov.adventure.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public final class User implements Serializable {
    private final String id;
    private final String name;
    @Setter
    private int questionId;
    private final Statistics statistics;
}
