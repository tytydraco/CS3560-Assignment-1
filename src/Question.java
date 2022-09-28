/**
 * A base class for a question. It provides methods to get a question,
 * candidate answers, and valid answers.
 */
public abstract class Question {
    /**
     * The question being answered.
     */
    public String question;

    /**
     * The possible answers that can be chosen.
     */
    public String[] candidateAnswers;

    /**
     * @param selectedAnswers The answers selected by the user.
     * @return Only the valid answers.
     */
    abstract String[] validateAnswers(String[] selectedAnswers);
}
