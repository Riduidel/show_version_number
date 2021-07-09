package fr.zenika.maven.formation.show_version_number;

import java.io.IOException;
import java.util.logging.Logger;

public class App {
	private static final Logger logger = Logger.getLogger(App.class.getName());

	private String version = "${project.version}";
	private String commit = "${buildNumber}";
	private String branch = "${scmBranch}";
	
	public static void main(String[] args) throws Throwable {
		App app = new App();
		app.run();
	}

	private void run() throws IOException {
		logger.info(String.format("Version %s", version));
		logger.info(String.format("Git commit hash %s", commit));
		logger.info(String.format("Git branch %s", branch));
	}
}
