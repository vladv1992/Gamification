package com.webapplication.service;

import com.webapplication.model.Badge;
import com.webapplication.model.Quest;
import com.webapplication.model.Ranking;
import com.webapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    @Autowired
    User user;
    @Autowired
    Quest quest;
    int correctAnswers = 0;
    int numberOfBadges = 0;

    public void answerQuestion(Quest quest, User user) {

        String userAnswer = user.getUserAnswer();
        String questAnswer = quest.getAnswer();

        if (userAnswer.equals(questAnswer)) {
            correctAnswers += 1;
        }
        user.setTokens(correctAnswers);
    }

    public void assignNumberOfBadgesAndBadgesType() {
        switch (correctAnswers) {
            case 1:
                numberOfBadges = 1;
                user.setUserBadges(String.valueOf(Badge.BEGINNER));
                break;
            case 2:
                numberOfBadges = 2;
                user.setUserBadges(String.valueOf(Badge.MEDIUM));
                break;
            case 3:
                numberOfBadges = 3;
                user.setUserBadges(String.valueOf(Badge.ADVANCED));
                break;
            default:
                numberOfBadges = 0;
                break;
        }
    }

    public void assignRating() {
        switch (user.getUserBadges()) {
            case "BEGINNER":
                user.setRanking(new Ranking(1));
                break;
            case "MEDIUM":
                user.setRanking(new Ranking(2));
                break;
            case "ADVANCED":
                user.setRanking(new Ranking(3));
                break;
            default:
                user.setRanking(new Ranking(0));
                break;
        }
    }

    public void setUserRightsToProposeQuests() {
        if (user.getRanking().getStars() == 3) {
            user.setCanProposeQuests(true);
        }
    }




}


