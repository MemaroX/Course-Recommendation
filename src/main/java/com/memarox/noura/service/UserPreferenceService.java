package com.memarox.noura.service;

import com.memarox.noura.entity.User;
import com.memarox.noura.entity.UserPreference;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserPreferenceService {

    private static final Logger logger = LoggerFactory.getLogger(UserPreferenceService.class);
    private final EntityManagerFactory emf;

    public UserPreferenceService() {
        emf = Persistence.createEntityManagerFactory("noura-pu");
    }

    public User getOrCreateUser(String username) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getResultStream()
                    .findFirst()
                    .orElseGet(() -> {
                        em.getTransaction().begin();
                        User newUser = new User();
                        newUser.setUsername(username);
                        em.persist(newUser);
                        em.getTransaction().commit();
                        logger.info("Created new user: {}", username);
                        return newUser;
                    });
        } catch (Exception e) {
            logger.error("Error getting or creating user {}: {}", username, e.getMessage(), e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void saveUserPreferences(User user, Map<String, List<String>> preferences) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            // Clear existing preferences for the user
            em.createQuery("DELETE FROM UserPreference up WHERE up.user = :user")
                    .setParameter("user", user)
                    .executeUpdate();

            // Save new preferences
            for (Map.Entry<String, List<String>> entry : preferences.entrySet()) {
                UserPreference userPreference = new UserPreference();
                userPreference.setUser(user);
                userPreference.setPreferenceKey(entry.getKey());
                userPreference.setPreferenceValue(String.join(",", entry.getValue())); // Store list as comma-separated string
                em.persist(userPreference);
            }
            em.getTransaction().commit();
            logger.info("Saved preferences for user {}: {}", user.getUsername(), preferences);
        } catch (Exception e) {
            logger.error("Error saving preferences for user {}: {}", user.getUsername(), e.getMessage(), e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public Map<String, List<String>> loadUserPreferences(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            List<UserPreference> preferences = em.createQuery("SELECT up FROM UserPreference up WHERE up.user = :user", UserPreference.class)
                    .setParameter("user", user)
                    .getResultList();

            Map<String, List<String>> loadedPreferences = new HashMap<>();
            for (UserPreference up : preferences) {
                loadedPreferences.put(up.getPreferenceKey(), Arrays.asList(up.getPreferenceValue().split(",")));
            }
            logger.info("Loaded preferences for user {}: {}", user.getUsername(), loadedPreferences);
            return loadedPreferences;
        } catch (Exception e) {
            logger.error("Error loading preferences for user {}: {}", user.getUsername(), e.getMessage(), e);
            throw e;
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            logger.info("EntityManagerFactory closed.");
        }
    }
}
