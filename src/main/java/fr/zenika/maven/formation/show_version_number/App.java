package fr.zenika.maven.formation.show_version_number;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class App {
	private static final Logger logger = Logger.getLogger(App.class.getName());

	public App() {
	}

	public static void main(String[] args) throws Throwable {
		App app = new App();
		app.run();
	}

	private void run() throws IOException {
		logger.info(String.format("Version %s", getProperties().getProperty("version")));
		logger.info(String.format("Git commit hash %s", getProperties().getProperty("commit")));
		logger.info(String.format("Git branch %s", getProperties().getProperty("branch")));
	}

	private Properties getProperties() throws IOException {
		try (InputStream stream = getClass().getClassLoader().getResourceAsStream("version.properties")) {
			Properties props = new Properties();
			props.load(stream);
			return props;
		}
	}

}
