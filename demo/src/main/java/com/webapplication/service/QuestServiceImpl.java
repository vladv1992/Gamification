package com.webapplication.service;

import com.webapplication.model.Quest;
import com.webapplication.repository.QuestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class QuestServiceImpl implements QuestService {

        @Autowired
        private QuestRepository questRepository;

        @Override
        @Transactional
        public void saveQuest(Quest quest) {
            questRepository.save(quest);
        }

        @Override
        public Quest getQuestById(Long id) {
            return questRepository.findById(id).orElse(null);
        }

        @Override
        public List<Quest> getAllQuests() {
            return (List<Quest>) questRepository.findAll();
        }

        @Override
        public void delete(Quest quest) {
            questRepository.delete(quest);
        }
}


