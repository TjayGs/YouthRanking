package com.tjay.youthranking.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor // Necessary for Jackson
@AllArgsConstructor
public class Player {
    private String id;
    private String foreName;
    private String surName;
}