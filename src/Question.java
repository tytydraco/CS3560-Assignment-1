/**
 * A base class for a question. It provides methods to get a question,
 * candidate answers, and valid answers.
 */
public abstract class Question {
    /**
     * The question being answered.
     */
    private final String question;

    /**
     * The possible answers that can be chosen.
     */
    private final String[] candidateAnswers;

    Question(String question, String[] candidateAnswers) {
        this.question = question;
        this.candidateAnswers = candidateAnswers;
    }

    /**
     * @return The question being answered.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return The possible answers that can be chosen.
     */
    public String[] getCandidateAnswers() {
        return candidateAnswers;
    }

    /**
     * @param selectedAnswers The answers selected by the user.
     * @return Only the valid answers.
     */
    abstract String[] validateAnswers(String[] selectedAnswers);
}
