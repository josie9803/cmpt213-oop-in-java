import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambda {

    interface Observer {
        void event(String description);
    }
    class Model {
        public void addObserver(Observer obs) {
            // ...
        }
//        public watchNetworkTraffic() {
//            while true...
////                get packet from network
//                if (packet.isForUs()) {
//                    // notify my observers
//                    for(Observer obs : myObservers) {
//                        obs.event("New packet!");
//                    }
//                }
//        }
    }

    class Client {
        private double height;

        private void regObserver() {
            Model model = new Model();
            String message = "Hello!";
            int count = 0;
            count++;

            for (int i = 0; i < 10; i++) {
                final int j = i;
                // Option 1: Anonymous Class
                model.addObserver(new Observer() {
                    private int countCalled = 0;
                    @Override
                    public void event(String description) {
                        handleEvent(description);
                        System.out.println("Message: " + message);
                        height++;
                        System.out.println(j);
                        countCalled ++;
                        System.out.println("This was the " + countCalled + " time you called!");
                    }
                });
            }

//            count++;

            // Option 2: Lambda
            model.addObserver(msg -> handleEvent(msg));

            // Option 3: Method Reference
            model.addObserver(this::handleEvent);
        }

        private void handleEvent(String description) {
            System.out.println(description);
        }
    }

}
