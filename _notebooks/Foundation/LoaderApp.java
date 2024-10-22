public class LoaderApp {

    public static void main(String[] args) {
        // Start the loading animation in a separate thread
        Thread loadingThread = new Thread(() -> {
            String[] loadingSymbols = {"|", "/", "-", "\\"}; // Loader symbols
            int totalSteps = 20; // Total steps for the progress bar
            
            for (int i = 0; i <= totalSteps; i++) {
                // Calculate the progress percentage
                int percentage = (i * 100) / totalSteps;

                // Create a visual representation of the progress bar
                StringBuilder progressBar = new StringBuilder("[");
                int progress = (int) (i * 50.0 / totalSteps); // Scale the progress to 50 characters
                for (int j = 0; j < 50; j++) {
                    if (j < progress) {
                        progressBar.append("=");
                    } else {
                        progressBar.append(" ");
                    }
                }
                progressBar.append("] " + percentage + "%");

                // Print the loading message with the progress bar
                System.out.print("\rLoading " + loadingSymbols[i % loadingSymbols.length] + " " + progressBar);
                
                // Sleep for a short duration to simulate work being done
                try {
                    Thread.sleep(200); // Adjust sleep time for speed of loading
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Handle interruption
                }
            }

            // Clear the line and print completion message
            System.out.print("\rLoading complete!                   \n");
        });

        // Start the loading animation thread
        loadingThread.start();

        // Simulate some work being done
        try {
            Thread.sleep(4000); // Simulate work for 4 seconds (can be adjusted)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Wait for the loading thread to finish (optional)
        try {
            loadingThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}