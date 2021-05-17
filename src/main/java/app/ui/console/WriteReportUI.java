package app.ui.console;

import app.controller.App;
import app.controller.RegisterNewCALController;
import app.controller.WriteReportController;
import auth.AuthFacade;

public class WriteReportUI {
    private WriteReportController writeReportController;
    private AuthFacade authFacade;

    /**
     * Constructor initiating the Controller and AuthFacade
     */
    public WriteReportUI()
    {
        this.writeReportController= new WriteReportController();
        this.authFacade = App.getInstance().getCompany().getAuthFacade();
    }

}
