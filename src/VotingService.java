import java.util.HashMap;

/**
 * Tracks user answers for a given question.
 */
public class VotingService {
    private final Question question;

    /**
     * A map between student IDs and their selected answers.
     */
    private final HashMap<String, String[]> studentAnswers = new HashMap<>();

    public VotingService(Question question) {
        this.question = question;
    }

    /**
     * Mark a vote for a student.
     *
     * @param student The student who is voting,
     * @param answers The answers this student has chosen.
     */
    public void vote(Student student, String[] answers) {
        final String[] validatedAnswers = question.validateAnswers(answers);
        studentAnswers.put(student.id, validatedAnswers);
    }

    /**
     * Print how many votes each answer received from users.
     */
    public void printStats() {
        HashMap<String, Integer> answerStats = new HashMap<>();
        studentAnswers.values().forEach((String[] answers) -> {
            for (String answer : answers) {
                answerStats.put(answer, answerStats.getOrDefault(answer, 0) + 1);
            }
        });

        answerStats.forEach((String answer, Integer votes) -> System.out.println(answer + ": " + votes.toString()));
    }
}
