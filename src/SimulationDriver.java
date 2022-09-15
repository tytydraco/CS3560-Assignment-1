import java.util.List;
import java.util.Random;

public class SimulationDriver {
    public static void main(String[] args) {
        System.out.println("Multiple choice test:");
        Question demoMCQuestion = new MultipleChoiceQuestion(
                "Here is an example multiple-choice question!",
                List.of("A", "B", "C", "D", "E", "F")
        );
        testQuestion(demoMCQuestion);

        System.out.println();

        System.out.println("Single choice test:");
        Question demoSingleQuestion = new SingleChoiceQuestion(
                "Here is an example single-choice question!",
                List.of("A", "B", "C", "D", "E", "F")
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

        List<String> candidateAnswers = question.getCandidateAnswers();
        for (int i = 0; i < 100; i++) {
            Student student = new Student(String.valueOf(i));
            String answer1 = candidateAnswers.get(random.nextInt(candidateAnswers.size()));
            String answer2 = candidateAnswers.get(random.nextInt(candidateAnswers.size()));
            votingService.vote(student, List.of(answer1, answer2));
        }

        votingService.printStats();
    }
}
