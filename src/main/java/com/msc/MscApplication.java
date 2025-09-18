package com.msc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.msc.Common.GamePhrases;
import com.msc.Common.GameUtilities;
import com.msc.GameItems.GameBoard;
import com.msc.GameItems.GameState;

@SpringBootApplication
public class MscApplication {

	public static void main(String[] args) throws InterruptedException {
		System.out.print("\033[2J\033[H");
		BlockingQueue<String> inputs = new LinkedBlockingQueue<>();
		Thread inputThread = new Thread(() -> {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
				String line;
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) inputs.offer(line);
                }
			} catch (IOException ignored) {}
		}, "input-thread");
        inputThread.start();
		GameState GS = new GameState();
		while(!GS.terminateState){
			if(GS.setup){
				System.out.println(GamePhrases.INTRO_TEXT);
				System.out.println(GamePhrases.INPUT_HELP_TEXT);
				inputs.take();
				String setupInput = inputs.poll();
				int[] setUp = GameUtilities.parseUserInput(setupInput);
				GS.SetUp(setUp[0], setUp[1]);
			}
		}
		//SpringApplication.run(MscApplication.class, args);
	}

}
