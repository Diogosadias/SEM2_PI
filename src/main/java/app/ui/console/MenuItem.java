package app.ui.console;

import app.ui.Main;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 *
 */

public class MenuItem {
    private final String description;
    private Runnable ui;

    private String gui;
    private Main mainInstance;


    public MenuItem(String description,  Runnable ui)
    {
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("MenuItem description cannot be null or empty.");
        if (Objects.isNull(ui))
            throw new IllegalArgumentException("MenuItem does not support a null UI.");

        this.description = description;
        this.ui = ui;
    }
    public MenuItem(String description,  String gui)
    {
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("MenuItem description cannot be null or empty.");
        if (Objects.isNull(gui))
            throw new IllegalArgumentException("MenuItem does not support a null UI.");

        this.description = description;
        this.gui= gui;
    }
    public String getGui(){
        return gui;
    }
    public void Instance(Main mainInstance){
        this.mainInstance=mainInstance;
    }
    public void rungui(String fxml) throws Exception {

        this.mainInstance.replaceSceneContent(fxml);

    }

    public void run()
    {
        this.ui.run();
    }

    public boolean hasDescription(String description)
    {
        return this.description.equals(description);
    }

    public String toString()
    {
        return this.description;
    }


}
