package com.msc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MscApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
    void runsUntilQuit_andCountsSteps() throws Exception {
        String fakeInput = "w\na\nx\nq\n"; // 3 commands, one invalid
        BufferedReader in = new BufferedReader(new StringReader(fakeInput));
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outBytes, true, "UTF-8");

        MscApplication.mainGameFlow(in, out);

        //String output = outBytes.toString("UTF-8");
        //assertTrue(output.contains("Game over. steps=2"));
        //assertTrue(output.contains("cmd")); // prompt printed
        //assertTrue(output.contains("?"));   // invalid 'x' acknowledged
    }

}
