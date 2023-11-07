package midterm_test_2_Java_ToyShop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        System.out.println("Лотерея проведена. Результаты записаны в файл 'results.txt'");
        Lottery raffle = new Lottery();
        raffle.add(new Toy(1, "Кукла"), 2);
        raffle.add(new Toy(2, "Конструктор"), 2);
        raffle.add(new Toy(3, "Машинка"), 6);

        saveResults(raffle);
    }

    public static void saveResults (Lottery raffle) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("results.txt"));
        LotteryToy result = raffle.get();
        while(result != null){
            outputWriter.write(result.toString());
            outputWriter.newLine();
            result = raffle.get();
        }
        outputWriter.flush();
        outputWriter.close();
    }
}
