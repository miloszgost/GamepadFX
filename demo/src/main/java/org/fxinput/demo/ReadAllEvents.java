package org.fxinput.demo;

import javafx.scene.control.TextArea;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;


public class ReadAllEvents implements Runnable {

    private final TextArea output;

    @Override
    public void run(){

        while(true){
            // Get the available controllers
            Controller[] controllers = ControllerEnvironment
                    .getDefaultEnvironment().getControllers();
            if (controllers.length == 0){
                System.out.println("Found no controllers.");
                output.setText(output.getText() + "\nFound no controllers");
                try{
                    Thread.sleep(3000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

            for (Controller controller : controllers) {
                // poll each one
                controller.poll();
                // get the controllers event queue
                EventQueue queue = controller.getEventQueue();
                // create an event object for the underlying plugin
                Event event = new Event();
                // for each object in the queue
                while (queue.getNextEvent(event)) {
                    /*
                     * Create a string buffer and put in it:
                     * the controller name, the time stamp of the event,
                     * the name of the component that changed
                     * and the new value.
                     * */
                    StringBuffer buffer = new StringBuffer(controller.getName());
                    buffer.append(" at ");
                    buffer.append(event.getNanos()).append(", ");
                    Component comp = event.getComponent();
                    buffer.append(comp.getName()).append(" changed to ");
                    float value = event.getValue();
                    /*
                     * Check the type of the component and display
                     * an appropiate value.*/
                    if (comp.isAnalog()) {
                        buffer.append(value);
                    } else {
                        if (value == 1.0f) {
                            buffer.append("On");
                        } else {
                            buffer.append("Off");
                        }
                    }
                    System.out.println(buffer);
                    output.setText(output.getText() + buffer);
                }

            }
            /*
             * Sleep for 20 miliseconds, in here only so the
             * example doesn't thrash the system.*/
            try {
                Thread.sleep(20);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public ReadAllEvents(TextArea output) {
        this.output = output;
    }
}
