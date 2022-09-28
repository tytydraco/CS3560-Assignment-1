/**
 * A base class for a question. It provides methods to get a question,
 * candidate answers, and valid answers.
 */
public interface Question {
    /**
     * @return The question being answered.
     */
    String getQuestion();

    /**
     * @return The possible answers that can be chosen.
     */
    String[] getCandidateAnswers();

    /**
     * @param candidateAnswers The answers selected by the user.
     * @return Only the valid answers.
     */
    String[] validateAnswers(String[] candidateAnswers);
}
