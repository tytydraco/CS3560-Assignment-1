import java.util.Random;

public class SimulationDriver {
    public static void main(String[] args) {
        System.out.println("Multiple choice test:");
        Question demoMCQuestion = new MultipleChoiceQuestion(
                "Here is an example multiple-choice question!",
                new String[]{"A", "B", "C", "D", "E", "F"}
        );
        testQuestion(demoMCQuestion);

        System.out.println();

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
        System.out.println("Prompt: " + question.question);

        Random random = new Random();

        VotingService votingService = new VotingService(question);

        String[] candidateAnswers = question.candidateAnswers;
        for (int i = 0; i < 100; i++) {
            Student student = new Student(String.valueOf(i));
            String answer1 = candidateAnswers[random.nextInt(candidateAnswers.length)];
            String answer2 = candidateAnswers[random.nextInt(candidateAnswers.length)];
            votingService.vote(student, new String[]{answer1, answer2});
        }

        votingService.printStats();
    }
}
