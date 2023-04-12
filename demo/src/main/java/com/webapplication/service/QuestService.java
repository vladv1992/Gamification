package com.webapplication.service;

import com.webapplication.model.Quest;

import java.util.List;

    public interface QuestService {
        void saveQuest(Quest quest);
        Quest getQuestById(Long id);
        List<Quest> getAllQuests();
        void delete(Quest quest);
    }



