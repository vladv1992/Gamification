
package com.webapplication.model;


import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "tokens")
public class Tokens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "quest_id")
    private Quest quest;

    @NotNull
    @Column(name = "num_tokens")
    private Integer tokens;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Badge badge;

    public Tokens(User user, boolean tokensRequired) {
    }

    public Integer getId() {
        return tokens;
    }

    public Quest getQuest() {
        return quest;
    }

    public Integer getTokens() {
        return tokens;
    }

    public Badge getBadge() {
        return badge;
    }


    public Tokens(Long id, @NotNull Quest quest, @NotNull Integer tokens, @NotNull Badge badge) {
        this.id = id;
        this.quest = quest;
        this.tokens = tokens;
        this.badge = badge;
    }
}

