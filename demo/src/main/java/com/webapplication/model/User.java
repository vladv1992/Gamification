package com.webapplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String userAnswer;

    @Column
    private int tokens;

    @Column
    private String userBadges;

    @Column
    private boolean canProposeQuests;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ranking_id", referencedColumnName = "ranking_id")
    private Ranking ranking;


    public User(int userId,
                String name,
                String email,
                String password,
                Ranking ranking,
                String userAnswer,
                int tokens,
                boolean canProposeQuests) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.ranking = ranking;
        this.userAnswer = userAnswer;
        this.tokens = tokens;
        this.canProposeQuests = canProposeQuests;
    }

    public boolean isCanProposeQuests() {
        return canProposeQuests;
    }

    public void setCanProposeQuests(boolean canProposeQuests) {
        this.canProposeQuests = canProposeQuests;
    }

    public String getUserBadges() {
        return userBadges;
    }

    public void setUserBadges(String userBadges) {
        this.userBadges = userBadges;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer() {
        this.userAnswer = userAnswer;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
