import java.util.Random;

public class SimulationDriver {
    /**
     * The number of students to use per simulation test.
     */
    static final int numberOfStudents = 100;

    public static void main(String[] args) {
        // Do a multiple choice test.
        System.out.println("Multiple choice test:");
        Question demoMCQuestion = new MultipleChoiceQuestion(
                "Here is an example multiple-choice question!",
                new String[]{"A", "B", "C", "D", "E", "F"}
        );
        testQuestion(demoMCQuestion);

        // Space between tests.
        System.out.println();

        // Do a single choice test.
        System.out.println("Single choice test:");
        Question demoSingleQuestion = new SingleChoiceQuestion(
                "Here is an example single-choice question!",
                new String[]{"A", "B", "C", "D", "E", "F"}
        );
        testQuestion(demoSingleQuestion);
    }

    /**
     * Run through 100 test students for a given question.
     *
     * @param question The question to test.
     */
    private static void testQuestion(Question question) {
        System.out.println("Prompt: " + question.getQuestion());

        Random random = new Random();

        VotingService votingService = new VotingService(question);

        String[] candidateAnswers = question.getCandidateAnswers();
        for (int i = 0; i < numberOfStudents; i++) {
            Student student = new Student(String.valueOf(i));

            // Allow students to vote for any random number of answers.
            final int answerCount = random.nextInt(candidateAnswers.length - 1) + 1;
            final String[] answers = new String[answerCount];
            for (int answerIdx = 0; answerIdx < answerCount; answerIdx++) {
                answers[answerIdx] = candidateAnswers[random.nextInt(candidateAnswers.length)];
            }

            // Mark the votes for this student.
            votingService.vote(student, answers);
        }

        // Print the test statistics to the standard output.
        votingService.printStats();
    }
}
