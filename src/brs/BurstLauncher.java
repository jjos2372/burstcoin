package brs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class BurstLauncher {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(BurstLauncher.class);
        boolean canRunGui = true;

        if (Arrays.asList(args).contains("--headless")) {
            logger.info("Running in headless mode as specified by argument");
            canRunGui = false;
        }

        if (canRunGui && GraphicsEnvironment.isHeadless()) {
            logger.error("Cannot start GUI as running in headless environment");
            canRunGui = false;
        }

        if (canRunGui) {
            try {
                Class.forName("brs.BurstGUI")
                        .getDeclaredMethod("main", String[].class)
                        .invoke(null, (Object) args);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                logger.warn("Your build does not seem to include the BurstGUI extension or it cannot be run. Running as headless...");
                Burst.main(args);
            }
        } else {
            Burst.main(args);
        }
    }    
}
