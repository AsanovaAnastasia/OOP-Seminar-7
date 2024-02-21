package Utils;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import Controller.CalcController;
import Model.Calculator;
import Model.ComplexNumber;
import Model.ComplexNumberCalculator;
import View.UI;

public class AppRunner {
    public static void run() throws SecurityException, IOException {
        final Logger calcLogger = Logger.getLogger(UI.class.getName());
        calcLogger.setLevel(Level.ALL);
        FileHandler fh = new FileHandler("log.txt", true);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        calcLogger.addHandler(fh);

        Calculator<ComplexNumber> calc = new ComplexNumberCalculator(calcLogger);
        CalcController<ComplexNumber> calcController = new CalcController<>(calc);

        UI ui = new UI(calcController, new InputUtil(new Scanner(System.in)), calcLogger);
        ui.run();
    }
}
