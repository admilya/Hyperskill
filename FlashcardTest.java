import org.hyperskill.hstest.dynamic.input.DynamicTestingMethod;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.TestCase;
import org.hyperskill.hstest.testing.TestedProgram;
import static org.hyperskill.hstest.testing.expect.Expectation.expect;


import flashcard.Main;

import java.util.Arrays;
import java.util.List;


public class TicTacToeTest {


    public static class TestUserProgram extends StageTest<String> {
        @Override
        public List<TestCase<String>> generate() {
            return Arrays.asList(
                    new TestCase<String>()
                            .setDynamicTesting(() -> {
                                TestedProgram main = new TestedProgram(Main.class);
                                String output = main.start().toLowerCase();

                                if (!output.contains("input the number of cards:")) {
                                    return CheckResult.wrong(
                                            "Your program should greet the user " +
                                                    "with the word \"Input the number of cards:\"");
                                }

                                String output2 = main.execute("2");
                                output2 = output2.toLowerCase();

                                if (!output2.contains("the card #1:")) {
                                        return CheckResult.wrong(
                                            "Your program should greet the user " +
                                                    "with the word \"The card #1:\"");
                                }
                                String output3 = main.execute("a brother of one's parent");
                                output3 = output3.toLowerCase();
                                if (!output3.contains("the definition of the card #1:")) {
                                    return CheckResult.wrong(
                                            "Your program should greet the user " +
                                                    "with the word \"The definition of the card #1:\"");
                                }
                                
                                
                                String output4 = main.execute("uncle");
                                output4 = output4.toLowerCase();
                                if (!output4.contains("the card #2:")) {
                                    return CheckResult.wrong(
                                            "Your program should greet the user " +
                                                    "with the word \"The card #2:\"");
                                }

                                String output5 = main.execute("a part of the body where the foot and the leg meet");
                                output5 = output5.toLowerCase();
                                if (!output5.contains("the definition of the card #2:")) {
                                    return CheckResult.wrong(
                                            "Your program should greet the user " +
                                                    "with the word \"The definition of the card #2:\"");
                                }

                                String output6 = main.execute("ankle");
                                output6 = output6.toLowerCase();
                                if (!output6.contains("print the definition of \"a brother of one's parent\":")) {
                                    return CheckResult.wrong(
                                            "Your program should greet the user " +
                                                    "with the word \"Print the definition of \"a brother of one's parent\":\"");
                                }

                                String output7 = main.execute("ankle");
                                output7 = output7.toLowerCase();
                                if (!output7.contains("wrong answer. the correct one is \"uncle\", you've just written the definition of " +
                                        "\"a part of the body where the foot and the leg meet\".\n" +
                                        "print the definition of \"a part of the body where the foot and the leg meet\":")) {
                                    return CheckResult.wrong("Wrong answer. The correct one is \"uncle\", you've just written the definition of " +
                                            "\"a part of the body where the foot and the leg meet\".\n" +
                                            "Print the definition of \"a part of the body where the foot and the leg meet\":");
                                }

                                String output8 = main.execute("@@@");
                                output8 = output8.toLowerCase();
                                if (!output8.contains("wrong answer. the correct one is\"ankle\"") ){
                                    return CheckResult.wrong("Wrong answer. The correct one is \"ankle\"");
                                }

                                String reply = output + output2 + output3 + output4 + output5 + output6 + output7 + output8;
                                if (reply.trim().split("\n").length != 9) {
                                    return CheckResult.wrong("Your program should print exactly 9 lines");
                                }



                                if (!main.isFinished()) {
                                    return CheckResult.wrong(
                                            "Your program should not request more, than 3 lines.");
                                }

                                return CheckResult.correct();
                            })
            );
        }
    }
    @DynamicTestingMethod
    void test(){
       TestedProgram main = new TestedProgram(Main.class);
       String output = main.start();

       expect(output).toContain();
       System.out.println("There is nothing in output ");

    }

    public static void main(String[] args) {
        TestUserProgram testUserProgram = new TestUserProgram();
        TestedProgram testedProgram = new TestedProgram(Main.class);
    }

}
